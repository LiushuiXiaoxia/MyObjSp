package cn.mycommons.myobjsp.impl;

import android.content.Context;
import android.content.SharedPreferences;

import cn.mycommons.myobjsp.IStorage;

/**
 * SpStorage <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class SpStorage implements IStorage {

    private SharedPreferences sharedPreferences;

    public SpStorage(Context context, String name) {
        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    @Override
    public <T> boolean put(String key, T value) {
        return edit().putString(key, String.valueOf(value)).commit();
    }

    @Override
    public <T> T get(String key) {
        return (T) sharedPreferences.getString(key, null);
    }

    @Override
    public boolean remove(String key) {
        return sharedPreferences.edit().remove(key).commit();
    }

    @Override
    public boolean remove(String... keys) {
        SharedPreferences.Editor editor = edit();
        for (String key : keys) {
            editor.remove(key);
        }
        return editor.commit();
    }

    @Override
    public boolean clear() {
        return edit().clear().commit();
    }

    @Override
    public int count() {
        return sharedPreferences.getAll().size();
    }

    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    private SharedPreferences.Editor edit() {
        return sharedPreferences.edit();
    }
}
