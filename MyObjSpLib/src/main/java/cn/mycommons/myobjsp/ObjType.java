package cn.mycommons.myobjsp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ObjType <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class ObjType<T> implements IMyObjType<T> {

    protected ObjType() {

    }

    Type getTypeOfT() {
        Type sType = ((Object) this).getClass().getGenericSuperclass();
        Type[] generics = ((ParameterizedType) sType).getActualTypeArguments();

        if (generics == null || generics.length == 0) {
            return null;
        }
        return generics[0];
    }

    @Override
    public Type type() {
        return getTypeOfT();
    }
}