package cn.mycommons.myobjsp;

import java.lang.reflect.Type;

/**
 * IEncoder <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public interface IEncoder {

    <T> String encode(T t);

    <T> T decode(String value, Type type);
}