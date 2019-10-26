package com.wyb.mylibrary2;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.webkit.PermissionRequest;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.mylibrary.People;

//引用MyLibrary1，判断对依赖包中的依赖包的删除情况
public class TestMyLibrary1 extends Activity {
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

    public void Demo3(Activity activity){
        //请求READ_PHONE_NUMBERS
        //检查是否获取到权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            String[] permissions = new String[]{Manifest.permission.READ_PHONE_NUMBERS}; // 选择你需要申请的权限
            for (int i = 0; i < permissions.length; i++) {
                int state = ContextCompat.checkSelfPermission(activity, permissions[i]);
                if (state != PackageManager.PERMISSION_GRANTED) { // 判断权限的状态
                    ActivityCompat.requestPermissions(activity, permissions, 200); // 申请权限
                    return;
                }
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && requestCode == 200) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) { // 用户点的拒绝，仍未拥有权限
                    Toast.makeText(this, "请在设置中打开摄像头或存储权限", Toast.LENGTH_SHORT).show();
                    // 可以选择添加如下代码在系统设置中打开该应用的设置页面
                    Intent intent = new Intent();
                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                    Uri uri = Uri.fromParts("package", getPackageName(), null);
                    intent.setData(uri);
                    startActivity(intent);
                    return;
                }
            }
        }
    }
}
