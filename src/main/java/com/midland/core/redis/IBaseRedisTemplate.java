//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.midland.core.redis;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface IBaseRedisTemplate<V, HK> {
    int delByKeys(String[] var1);

    Long incrByKey(String var1, long var2);

    Long decrByKey(String var1, long var2);

    Set<byte[]> getKeysLike(String var1);

    void saveValue(String var1, V var2);

    void saveValue(String var1, V var2, long var3);

    void saveValue(String var1, V var2, long var3, TimeUnit var5);

    void set(byte[] var1, byte[] var2, long var3);

    V getValueByKey(String var1);

    int addListItem(String var1, V var2);

    int removeListItem(String var1, long var2, V var4);

    long del(String... var1);

    int getListSize(String var1);

    List<V> getListByKey(String var1);

    List<V> getListByKeyAndIndex(String var1, long var2, long var4);

    void putHashItem(String var1, HK var2, V var3);

    void removeHashItem(String var1, HK[] var2);

    int getHashSize(String var1);

    HashMap<HK, V> getHashByKey(String var1);

    List<V> getHashValuesByKey(String var1);

    Set<HK> getHashKeysByKey(String var1);

    V getHashValueByKeyAndHashKey(String var1, HK var2);

    boolean exists(String var1);

    String flushDB();

    long dbSize();

    String ping();
}
