package com.edu.zscdm.servicedemo;

import android.os.AsyncTask;

public class DownloadTask extends AsyncTask<Void, Integer, Boolean> {

    //执行耗时操作，由return语句返回任务结果。
    @Override
    protected Boolean doInBackground(Void... params) {
        return null;
    }

    //后台任务结束并通过return语句返回结果时调用，比如提醒任务处理完毕，关闭对话框。
    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }

    //更新UI。
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    //后台任务初始化之前调用，用于界面上的初始化操作，比如对话框的显示。
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }
}