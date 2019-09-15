package com.wyb.mylibrary2;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import com.example.mylibrary.People;

//引用MyLibrary1，判断对依赖包中的依赖包的删除情况
public class TestMyLibrary1 {
    public static void Demo1(Activity MainActivity)
    {
        //先不使用
        People people = new People();
        people.setName("wyb");
        if(people.Eat(MainActivity))//如果方法成功运行，Toast提示
        {
            Toast toast = Toast.makeText(MainActivity,"MyGradle2",Toast.LENGTH_SHORT);
            toast.show();
            Log.e("TestMyLibrary1:",people.getName());
        }
    }
    public void Demo2()
    {
        Log.e("MyGradle:","Demo2");
    }
}
