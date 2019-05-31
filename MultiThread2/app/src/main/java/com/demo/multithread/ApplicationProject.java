package com.demo.multithread;

import android.app.Application;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationProject extends Application {

    private static ApplicationProject instance;
    public ExecutorService mExecutorService;
    // Số lượng thread chạy 1 thời điểm
    public final int mThreadLimit = 3;

    public static ApplicationProject getInstance(){
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    /**
     * Khởi tạo đối tượng ExecutorService để quản lí các thread sẽ chạy
     * @param arrThread
     */
    public void startMultiThread(List<Runnable> arrThread){

        // Khởi tạo ExecutorService để quản lí các thread sẽ chạy :
        // mThreadLimit : số lượng thread chạy 1 thời điểm
        mExecutorService = Executors.newFixedThreadPool(mThreadLimit);

        for (int i = 0; i < arrThread.size(); i++) {
            // Thêm thread vào trong ExecutorService để quản lí việc thread hoạt động
            mExecutorService.execute(arrThread.get(i));
        }

        // giải phóng ExecutorService để tiết kiệm bộ nhớ
        mExecutorService.shutdown();
    }
}
