package cn.mycommons.myobjsp.impl;

import cn.mycommons.myobjsp.IEncryption;

/**
 * EntpyEncryption <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class EntpyEncryption implements IEncryption {


    public EntpyEncryption() {
    }

    @Override
    public String encrypt(byte[] value) {
        return new String(value);
    }

    @Override
    public byte[] decrypt(String value) {
        if (value == null) {
            throw new NullPointerException("value is null.");
        }
        return value.getBytes();
    }
}