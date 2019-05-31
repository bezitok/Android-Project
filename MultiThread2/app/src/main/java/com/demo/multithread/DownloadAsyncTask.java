package com.demo.multithread;

import android.os.AsyncTask;

public class DownloadAsyncTask extends AsyncTask<String, Integer, Boolean> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Boolean doInBackground(String... strings) {
        //giá trị trả ra sẽ được chuyển vào onPostExecute();
        publishProgress();
        //dữ liệu trong publishProgress() lại được chuyển vào
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
    }
}
