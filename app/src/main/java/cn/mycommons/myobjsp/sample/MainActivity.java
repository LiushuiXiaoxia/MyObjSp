package cn.mycommons.myobjsp.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import org.liushui.mycommons.android.log.McLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import cn.mycommons.myobjsp.MyObjSp;
import cn.mycommons.myobjsp.MyObjSpFactory;
import cn.mycommons.myobjsp.ObjType;


public class MainActivity extends ActionBarActivity {

    MyObjSp myObjSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        testWithNoPasswd();
        testWithPasswd();
    }

    void testWithNoPasswd() {
        McLog.mByStackTrace();

        long start = System.currentTimeMillis();

        myObjSp = MyObjSpFactory.newInstance(this, "app_config");

        testInt();

        testString();
        testStringList();

        testUser();
        testUserList();

        testClear();

        McLog.i("time = %s", System.currentTimeMillis() - start);
    }

    void testWithPasswd() {
        McLog.mByStackTrace();
        long start = System.currentTimeMillis();


        myObjSp = MyObjSpFactory.newInstance(this, "app_config", "abc");

        testInt();

        testString();
        testStringList();

        testUser();
        testUserList();

        testClear();
        McLog.i("time = %s", System.currentTimeMillis() - start);
    }

    void testInt() {
        String key = "int";
        myObjSp.put(key, 100);

        McLog.i("get int = " + myObjSp.get(key, int.class));
        McLog.i("get int = " + myObjSp.get(key, new ObjType<Integer>() {
        }));
        McLog.i("count = " + myObjSp.count());
        McLog.i("contains = " + myObjSp.contains(key));
    }

    void testString() {
        String key = "string";
        myObjSp.put(key, "abc123");

        McLog.i("get String = " + myObjSp.get(key, String.class));
        McLog.i("get String = " + myObjSp.get(key, new ObjType<String>() {
        }));
        McLog.i("count = " + myObjSp.count());
        McLog.i("contains = " + myObjSp.contains(key));
    }

    void testStringList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            list.add("test" + i);
        }

        String key = "string_list";
        myObjSp.put(key, list);

        McLog.i("get String List = " + Arrays.toString(myObjSp.get(key, String[].class)));
        McLog.i("get String List = " + myObjSp.get(key, new ObjType<List<String>>() {
        }));
        McLog.i("count = " + myObjSp.count());
        McLog.i("contains = " + myObjSp.contains(key));
    }

    void testUser() {
        User user = new User();
        user.name = "name";
        user.age = 100;
        user.sex = true;

        String key = "user";
        myObjSp.put(key, user);

        McLog.i("get user = " + myObjSp.get(key, User.class));
        McLog.i("get user = " + myObjSp.get(key, new ObjType<User>() {
        }));
        McLog.i("count = " + myObjSp.count());
        McLog.i("contains = " + myObjSp.contains(key));
    }

    void testUserList() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            User user = new User();
            user.name = "name" + i;
            user.age = 100 + i;
            user.sex = true;

            list.add(user);
        }

        String key = "user_list";
        myObjSp.put(key, list);

        McLog.i("get user list = " + Arrays.toString(myObjSp.get(key, User[].class)));
        McLog.i("get user list = " + myObjSp.get(key, new ObjType<List<User>>() {
        }));
        McLog.i("count = " + myObjSp.count());
        McLog.i("contains = " + myObjSp.contains(key));
    }

    void testClear() {
        McLog.i("clear = " + myObjSp.clear());
        McLog.i("count = " + myObjSp.count());
    }
}