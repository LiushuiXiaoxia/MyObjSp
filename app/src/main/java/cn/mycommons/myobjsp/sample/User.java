package cn.mycommons.myobjsp.sample;

/**
 * User <br/>
 * Created by xiaqiulei on 2015-03-22.
 */
public class User {

    public String name;

    public int age;

    public boolean sex;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}