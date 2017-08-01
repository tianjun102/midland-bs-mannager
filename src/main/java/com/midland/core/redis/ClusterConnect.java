package com.midland.core.redis;

import redis.clients.jedis.JedisCluster;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClusterConnect
{
  private JedisCluster jedisCluster;

  public JedisCluster getJedisCluster()
  {
    return this.jedisCluster;
  }

  public void setJedisCluster(JedisCluster jedisCluster) {
    this.jedisCluster = jedisCluster;
  }

  public String set(String key, String value)
  {
    return getJedisCluster().set(key, value);
  }

  public String set(String key, String value, int seconds)
  {
    return getJedisCluster().setex(key, seconds, value);
  }

  public String get(String key)
  {
    return getJedisCluster().get(key);
  }

  public long reSetMap(String cacheKey, String mapKey, String mapValue)
  {
    return getJedisCluster().hset(cacheKey, mapKey, mapValue).longValue();
  }

  public boolean hexists(String cacheKey, String mapKey)
  {
    return getJedisCluster().hexists(cacheKey, mapKey).booleanValue();
  }

  public String setMap(String key, Map<String, String> hash)
  {
    return getJedisCluster().hmset(key, hash);
  }

  public List<String> getMap(String key, String[] fields)
  {
    return getJedisCluster().hmget(key, fields);
  }

  public String getMapVal(String key, String field)
  {
    return getJedisCluster().hget(key, field);
  }

  public Map<String, String> getMapAll(String key)
  {
    return getJedisCluster().hgetAll(key);
  }

  public Set<String> getMapKeys(String key)
  {
    return getJedisCluster().hkeys(key);
  }

  public List<String> getMapVals(String key)
  {
    return getJedisCluster().hvals(key);
  }

  public Long delMap(String key, String[] fields)
  {
    return getJedisCluster().hdel(key, fields);
  }

  public Boolean exists(String key)
  {
    return getJedisCluster().exists(key);
  }

  public Long del(String key)
  {
    return getJedisCluster().del(key);
  }

  public Long expire(String key, int seconds)
  {
    return getJedisCluster().expire(key, seconds);
  }

  public Long persist(String key)
  {
    return getJedisCluster().persist(key);
  }

  public Long getExpireTime(String key)
  {
    return getJedisCluster().ttl(key);
  }

  public Long append(String key, String value)
  {
    return getJedisCluster().append(key, value);
  }

  public Long addMembers(String key, String[] members)
  {
    return getJedisCluster().sadd(key, members);
  }

  public Long removeMembers(String key, String[] members)
  {
    return getJedisCluster().srem(key, members);
  }

  public Set<String> getMembers(String key)
  {
    return getJedisCluster().smembers(key);
  }

  public Boolean isMember(String key, String member)
  {
    return getJedisCluster().sismember(key, member);
  }

  public Long getMemberCount(String key)
  {
    return getJedisCluster().scard(key);
  }
}