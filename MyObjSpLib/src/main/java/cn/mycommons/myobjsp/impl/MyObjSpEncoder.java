package cn.mycommons.myobjsp.impl;

import java.lang.reflect.Type;

import cn.mycommons.myobjsp.IEncoder;
import cn.mycommons.myobjsp.IEncryption;
import cn.mycommons.myobjsp.IParse;

/**
 * MyObjSpEncoder <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class MyObjSpEncoder implements IEncoder {

    private IParse parse;

    private IEncryption encryption;

    public MyObjSpEncoder(IParse parse, IEncryption encryption) {
        this.parse = parse;
        this.encryption = encryption;
    }

    @Override
    public <T> String encode(T t) {
        if (t == null) {
            throw new NullPointerException("t is null.");
        }
        String text = parse.to(t);
        String encryptText = encryption.encrypt(text.getBytes());
        return encryptText;
    }

    @Override
    public <T> T decode(String value, Type type) {
        if (value == null) {
            throw new NullPointerException("value is null.");
        }
        byte[] datas = encryption.decrypt(value);
        return parse.from(new String(datas), type);
    }
}