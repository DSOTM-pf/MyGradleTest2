package com.wyb.mylibrary2;

public class SameName {
    public static String Name_one;
    public String Name_two;
    public int Name_N1;

    //自定义同名类公有的方法
    public String SameMethod2()
    {
        return "MyGradle2.SameName.SameMethod";
    }
    //自定义同名类特有的方法
    public String NotSameMethod()
    {
        return "MyGradle2.SameName.NotSameMethod";
    }
    //get set
    public static String getName_one() {
        return Name_one;
    }

    public static void setName_one(String name_one) {
        Name_one = name_one;
    }

    public String getName_two() {
        return Name_two;
    }

    public void setName_two(String name_two) {
        Name_two = name_two;
    }

    public int getName_N1() {
        return Name_N1;
    }

    public void setName_N1(int name_N1) {
        Name_N1 = name_N1;
    }
}
