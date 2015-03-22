package cn.mycommons.myobjsp;

import java.lang.reflect.Type;

/**
 * IParse <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public interface IParse {

    <T> T from(String text, Type type);

    String to(Object obj);
}