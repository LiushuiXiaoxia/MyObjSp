package cn.mycommons.myobjsp;

import android.content.Context;
import android.text.TextUtils;

import cn.mycommons.myobjsp.impl.DesEncryption;
import cn.mycommons.myobjsp.impl.EntpyEncryption;
import cn.mycommons.myobjsp.impl.GsonJsonParse;
import cn.mycommons.myobjsp.impl.MyObjSpEncoder;
import cn.mycommons.myobjsp.impl.SpStorage;

/**
 * MyObjSpFactory <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class MyObjSpFactory {

    public static MyObjSp newInstance(Context context, String name) {
        return newInstance(context, name, null);
    }

    public static MyObjSp newInstance(Context context, String name, String passwd) {
        IEncryption encryption = TextUtils.isEmpty(passwd) ? new EntpyEncryption() : new DesEncryption(passwd);

        IStorage storage = new SpStorage(context, name);
        IParse parse = new GsonJsonParse();

        IEncoder encoder = new MyObjSpEncoder(parse, encryption);

        return new MyObjSp(storage, encoder);
    }
}