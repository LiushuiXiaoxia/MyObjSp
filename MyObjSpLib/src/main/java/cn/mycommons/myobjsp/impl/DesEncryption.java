package cn.mycommons.myobjsp.impl;

import android.util.Base64;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import cn.mycommons.myobjsp.IEncryption;
import cn.mycommons.myobjsp.MyObjSpLog;

/**
 * DesEncryption <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class DesEncryption implements IEncryption {
    Key key;

    public DesEncryption(String passwd) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(new SecureRandom(passwd.getBytes()));
            key = keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String encrypt(byte[] value) {
        if (value == null) {
            throw new NullPointerException("value is null.");
        }
        try {
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] datas = cipher.doFinal(value);
            return Base64.encodeToString(datas, Base64.DEFAULT);
        } catch (Exception e) {
            e.printStackTrace();
            MyObjSpLog.e("", e);
        }
        return null;
    }

    @Override
    public byte[] decrypt(String value) {
        if (value == null) {
            throw new NullPointerException("value is null.");
        }
        try {
            byte[] datas = Base64.decode(value, Base64.DEFAULT);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            return cipher.doFinal(datas);
        } catch (Exception e) {
            e.printStackTrace();
            MyObjSpLog.e("", e);
        }
        return null;
    }
}