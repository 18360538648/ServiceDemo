package com.lsw.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Luosiwei on 2017/9/27.
 */

public class MyService extends Service {
    public MyBind myBind = new MyBind();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("lsw", "MyService onCreate");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("lsw", "MyService onBind");
        return myBind;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("lsw", "MyService onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("lsw", "MyService onStartCommand");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("lsw", "MyService onDestroy");
    }

    public class MyBind extends Binder {
        public void doDown() {
            Log.i("lsw", "下载任务----");
        }
    }
}
