package cn.mycommons.myobjsp;

/**
 * IEncryption <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public interface IEncryption {
    String encrypt(byte[] value);

    byte[] decrypt(String value);
}