package com.poison.loadpagertest;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

/**
 * Created by Administrator on 2016/5/10 0010.
 */
public class APP extends Application {

    private static APP app;
    private static Handler mMainThreadHandler = null;


    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        mMainThreadHandler = new Handler();
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }
    public static Context getInstance() {
        return  app;
    }
}
