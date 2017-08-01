package com.midland.core.redis;

import com.hxin.common.cache.client.api.standalone.IBaseRedisTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseRedisTemplate<V, HK>
  implements IBaseRedisTemplate<V, HK>
{

  @Autowired
  protected RedisTemplate<Serializable, Serializable> redisTemplate;

  @Resource(name="redisTemplate")
  protected ValueOperations<Object, V> valueOperations;

  @Resource(name="redisTemplate")
  protected ListOperations<Object, V> listOps;

  @Resource(name="redisTemplate")
  protected HashOperations<Object, HK, V> hashOps;

  public int delByKeys(String[] keys)
  {
    return ((Integer)this.redisTemplate.execute(new RedisCallback(keys) {
      public Integer doInRedis(RedisConnection connection) throws DataAccessException {
        int count = 0;
        for (int i = 0; i < this.val$keys.length; i++)
        {
          count = count + connection
            .del(new byte[][] { this.val$keys[i]
            .getBytes() })
            .intValue();
        }return Integer.valueOf(count);
      }
    })).intValue();
  }

  public Long incrByKey(String keys, long num) {
    return (Long)this.redisTemplate.execute(new RedisCallback(keys, num)
    {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.incrBy(this.val$keys.getBytes(), this.val$num);
      } } );
  }

  public Long decrByKey(String keys, long num) {
    return (Long)this.redisTemplate.execute(new RedisCallback(keys, num)
    {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.decrBy(this.val$keys.getBytes(), this.val$num);
      } } );
  }

  public Set<byte[]> getKeysLike(String pattern) {
    return (Set)this.redisTemplate.execute(new RedisCallback(pattern)
    {
      public Set<byte[]> doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.keys(this.val$pattern.getBytes());
      }
    });
  }

  public void set(byte[] key, byte[] value, long liveTime)
  {
    this.redisTemplate.execute(new RedisCallback(key, value, liveTime) {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        connection.set(this.val$key, this.val$value);
        if (this.val$liveTime > 0L) {
          connection.expire(this.val$key, this.val$liveTime);
        }
        return Long.valueOf(1L);
      } } );
  }

  public void saveValue(String key, V value) {
    this.valueOperations.set(key, value);
  }

  public boolean exists(String key)
  {
    return ((Boolean)this.redisTemplate.execute(new RedisCallback(key) {
      public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.exists(this.val$key.getBytes());
      }
    })).booleanValue();
  }

  public String flushDB()
  {
    return (String)this.redisTemplate.execute(new RedisCallback() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        connection.flushDb();
        return "ok";
      }
    });
  }

  public String ping()
  {
    return (String)this.redisTemplate.execute(new RedisCallback() {
      public String doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.ping();
      }
    });
  }

  public long del(String[] keys)
  {
    return ((Long)this.redisTemplate.execute(new RedisCallback(keys) {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        long result = 0L;
        for (int i = 0; i < this.val$keys.length; i++) {
          result = connection.del(new byte[][] { this.val$keys[i].getBytes() }).longValue();
        }
        return Long.valueOf(result);
      }
    })).longValue();
  }

  public long dbSize()
  {
    return ((Long)this.redisTemplate.execute(new RedisCallback() {
      public Long doInRedis(RedisConnection connection) throws DataAccessException {
        return connection.dbSize();
      }
    })).longValue();
  }

  public void saveValue(String key, V value, long offset)
  {
    this.valueOperations.set(key, value, offset);
  }

  public void saveValue(String key, V value, long timeout, TimeUnit unit) {
    this.valueOperations.set(key, value, timeout, unit);
  }

  public V getValueByKey(String key) {
    return this.valueOperations.get(key);
  }

  public int addListItem(String key, V value) {
    return this.listOps.leftPush(key, value).intValue();
  }

  public int removeListItem(String key, long count, V value) {
    return this.listOps.remove(key, count, value).intValue();
  }

  public int getListSize(String key) {
    return this.listOps.size(key).intValue();
  }

  public List<V> getListByKey(String key) {
    List l = this.listOps.range(key, 0L, -1L);
    return l;
  }

  public List<V> getListByKeyAndIndex(String key, long start, long end) {
    List l = this.listOps.range(key, start, end);
    return l;
  }

  public void putHashItem(String key, HK hashKey, V value) {
    this.hashOps.put(key, hashKey, value);
  }

  public void removeHashItem(String key, HK[] hashKeys) {
    this.hashOps.delete(key, hashKeys);
  }

  public int getHashSize(String key) {
    return this.hashOps.size(key).intValue();
  }

  public HashMap<HK, V> getHashByKey(String key) {
    HashMap m = (HashMap)this.hashOps.entries(key);
    return m;
  }

  public List<V> getHashValuesByKey(String key) {
    List l = this.hashOps.values(key);
    return l;
  }

  public Set<HK> getHashKeysByKey(String key) {
    Set s = this.hashOps.keys(key);
    return s;
  }

  public V getHashValueByKeyAndHashKey(String key, HK hashKey) {
    return this.hashOps.get(key, hashKey);
  }
}