#MyObjSp
---
##Abstract 
MyObjSp is like [hawk](https://github.com/orhanobut/hawk)

I just rewrite hawk,becase I don't like it style for use.

>**MyObjSp uses:**
>gson to serializable
>des to crypto
>SharedPreferences for the storage

##Gradle dependency
```
repositories {
    maven {
        url "https://raw.githubusercontent.com/LiushuiXiaoxia/MyObjSp/repository/repository/"
    }
}

compile 'cn.mycommons:myobjsp:1.0'
```

##Init

```java
// init with no password
 MyObjSp myObjSp = MyObjSpFactory.newInstance(context, "config");
// init with password
  MyObjSp myObjSp = MyObjSpFactory.newInstance(context, "config"，"abc123!!");
```

##Put
```
// int
myObjSp.put("int", 100);
// string
myObjSp.put("string", "abc123");
// string array
myObjSp.put("string array", new String[]{"abc", "123"});
// string list
myObjSp.put("string list", Arrays.asList("abc", 123));
// object
myObjSp.put("object", new User("abc", 100, true));
// object array
myObjSp.put("object array", new User[]{
        new User("abc", 100, true),
        new User("abc", 100, true)
});
// object list
myObjSp.put("object list", Arrays.asList(
        new User("abc", 100, true),
        new User("abc", 100, true)
));
```

##Get
```java
int i = myObjSp.get("int", int.class);
String s = myObjSp.get("string", String.class);

String[] strintArray = myObjSp.get("string array", String[].class);
List<String> stringList = myObjSp.get("string list", new ObjType<List<String>>() {
});

User user = myObjSp.get("object", User.class);
User[] users = myObjSp.get("object array", User[].class);
List<User> userList = myObjSp.get("ojbect list", new ObjType<List<User>>() {
});
```


##Other
```
boolean isSuccess = myObjSp.clear();
boolean isRemoveSuccess = myObjSp.remove("key");
boolean isContains = myObjSp.contains("key");
```

##Attention
```
List<User> userList = myObjSp.get("ojbect list", new ObjType<List<User>>() {
});
// The second param must like this

new ObjType<List<User>>() {} // ture

new ObjType<List<User>>()  // false
```
