package cn.mycommons.myobjsp;

/**
 * IStorage <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public interface IStorage {

    <T> boolean put(String key, T value);


    <T> T get(String key);

    boolean remove(String key);

    boolean remove(String... keys);

    boolean clear();

    int count();

    boolean contains(String key);
}