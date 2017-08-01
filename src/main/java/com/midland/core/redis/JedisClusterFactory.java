package com.midland.core.redis;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisClusterFactory
  implements FactoryBean<JedisCluster>, InitializingBean
{
  private Resource addressConfig;
  private String addressKeyPrefix;
  private JedisCluster jedisCluster;
  private Integer timeout;
  private Integer maxRedirections;
  private GenericObjectPoolConfig genericObjectPoolConfig;
  private Pattern p = Pattern.compile("^.+[:]\\d{1,5}\\s*$");

  public JedisCluster getObject() throws Exception
  {
    return this.jedisCluster;
  }

  public Class<? extends JedisCluster> getObjectType()
  {
    return this.jedisCluster != null ? this.jedisCluster.getClass() : JedisCluster.class;
  }

  public boolean isSingleton()
  {
    return true;
  }

  public void afterPropertiesSet() throws Exception {
    Set haps = parseHostAndPort();
    this.jedisCluster = new JedisCluster(haps, this.timeout.intValue(), this.maxRedirections.intValue(), this.genericObjectPoolConfig);
  }
  private Set<HostAndPort> parseHostAndPort() throws Exception {
    try {
      Properties prop = new Properties();
      prop.load(this.addressConfig.getInputStream());
      Set haps = new HashSet();
      for (Iterator localIterator = prop.keySet().iterator(); localIterator.hasNext(); ) { Object key = localIterator.next();
        if (!((String)key).startsWith(this.addressKeyPrefix)) {
          continue;
        }
        String val = (String)prop.get(key);
        boolean isIpPort = this.p.matcher(val).matches();
        if (!isIpPort) {
          throw new IllegalArgumentException("ip 格式错误！");
        }
        String[] ipAndPort = val.split(":");
        HostAndPort hap = new HostAndPort(ipAndPort[0], Integer.parseInt(ipAndPort[1]));
        haps.add(hap);
      }

      return haps;
    } catch (IllegalArgumentException ex) {
      throw ex; } catch (Exception ex) {
    }
    throw new Exception("无效的参数异常！");
  }

  public void setAddressConfig(Resource addressConfig) {
    this.addressConfig = addressConfig;
  }

  public void setTimeout(int timeout) {
    this.timeout = Integer.valueOf(timeout);
  }

  public void setMaxRedirections(int maxRedirections) {
    this.maxRedirections = Integer.valueOf(maxRedirections);
  }

  public void setAddressKeyPrefix(String addressKeyPrefix) {
    this.addressKeyPrefix = addressKeyPrefix;
  }

  public void setGenericObjectPoolConfig(GenericObjectPoolConfig genericObjectPoolConfig) {
    this.genericObjectPoolConfig = genericObjectPoolConfig;
  }
}