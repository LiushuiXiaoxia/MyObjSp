package cn.mycommons.myobjsp;

import android.text.TextUtils;

import java.lang.reflect.Type;

/**
 * MyObjSp <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class MyObjSp {

    private IStorage storage;
    private IEncoder encoder;

    protected MyObjSp(IStorage storage, IEncoder encoder) {
        this.storage = storage;
        this.encoder = encoder;
    }

    public boolean put(String key, Object obj) {
        if (obj == null) {
            throw new NullPointerException("obj is null.");
        }
        String encodeStr = encoder.encode(obj);

        if (!TextUtils.isEmpty(encodeStr)) {
            return storage.put(key, encodeStr);
        }
        return false;
    }

    public <T> T get(String key, Class<T> tClass) {
        return get(key, tClass, null);
    }

    public <T> T get(String key, IMyObjType<T> type) {
        return get(key, type.type(), null);
    }


    public <T> T get(String key, Type type, T defaultValue) {
        if (key == null) {
            throw new NullPointerException("key is null");
        }
        if (type == null) {
            throw new NullPointerException("type is null");
        }
        String value = storage.get(key);
        T t = null;
        try {
            t = encoder.decode(value, type);
            if (t == null) {
                t = defaultValue;
            }
        } catch (Exception e) {
            MyObjSpLog.e("", e);
        }
        return t;
    }

    public boolean remove(String key) {
        return storage.remove(key);
    }

    public boolean remove(String... keys) {
        return storage.remove(keys);
    }

    public boolean storage(String key) {
        return storage.contains(key);
    }

    public int count() {
        return storage.count();
    }

    public boolean clear() {
        return storage.clear();
    }

    public boolean contains(String key) {
        return storage.contains(key);
    }
}