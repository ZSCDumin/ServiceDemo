package com.edu.zscdm.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private MyService.DownloadBinder downloadBinder;

    private ServiceConnection connection = new ServiceConnection() {//匿名类

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            downloadBinder = (MyService.DownloadBinder) service;
            downloadBinder.startDownload();//开始下载
            downloadBinder.getProgress();//获取下载进度
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startService = (Button) findViewById(R.id.start_service);//开始服务按钮
        Button stopService = (Button) findViewById(R.id.stop_service);//停止服务按钮
        Button bindService = (Button) findViewById(R.id.bind_service);//绑定服务按钮
        Button unbindService = (Button) findViewById(R.id.unbind_service);//解绑服务按钮
        Button startIntentService = (Button) findViewById(R.id.start_intent_service);//启动IntentService按钮

        startService.setOnClickListener(this);//开始服务监听事件
        stopService.setOnClickListener(this);//停止服务监听事件
        bindService.setOnClickListener(this);//绑定服务监听事件
        unbindService.setOnClickListener(this);//解绑服务监听事件
        startIntentService.setOnClickListener(this);//启动IntentService监听事件
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_service:
                Intent startIntent = new Intent(this, MyService.class);
                startService(startIntent); // 启动服务
                break;
            case R.id.stop_service:
                Intent stopIntent = new Intent(this, MyService.class);
                stopService(stopIntent); // 停止服务
                break;
            case R.id.bind_service:
                Intent bindIntent = new Intent(this, MyService.class);
                bindService(bindIntent, connection, BIND_AUTO_CREATE); // 绑定服务
                break;
            case R.id.unbind_service:
                unbindService(connection); // 解绑服务
                break;
            case R.id.start_intent_service:
                // 打印主线程的id
                Log.d("MainActivity", "Thread id is " + Thread.currentThread(). getId());
                Intent intentService = new Intent(this, MyIntentService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }

}
