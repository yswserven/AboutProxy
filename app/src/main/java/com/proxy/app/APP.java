package com.proxy.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by: Ysw on 2020/2/11.
 */
public class APP extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
    }

    public static Context getContext() {
        return context;
    }
}
