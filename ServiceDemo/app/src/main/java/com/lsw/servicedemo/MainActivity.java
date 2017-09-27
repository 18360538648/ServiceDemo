package com.lsw.servicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MyService.MyBind myBind;
    ServiceConnection serviceConnection = new ServiceConnection() {
        // 连接
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBind = (MyService.MyBind) iBinder;
            myBind.doDown();
        }

        // 取消连接
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 开始Service
     *
     * @param view
     */
    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    /**
     * 结束Service
     *
     * @param view
     */
    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }

    /**
     * 绑定Service
     *
     * @param view
     */
    public void bindService(View view) {
        Intent intent = new Intent(this, MyService.class);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    /**
     * 解绑Service
     *
     * @param view
     */
    public void unbindService(View view) {
        unbindService(serviceConnection);
    }
}
