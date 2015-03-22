package cn.mycommons.myobjsp.impl;

import com.google.gson.Gson;

import java.lang.reflect.Type;

import cn.mycommons.myobjsp.IParse;

/**
 * GsonJsonParse <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class GsonJsonParse implements IParse {
    Gson gson;

    public GsonJsonParse() {
        this.gson = new Gson();
    }

    @Override
    public <T> T from(String text, Type type) {
        return gson.fromJson(text, type);
    }

    @Override
    public String to(Object obj) {
        return gson.toJson(obj);
    }
}