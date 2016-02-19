package com.youcheyihou.testgreendao;

import android.app.Application;

import com.youcheyihou.testgreendao.database.TestDB;

/**
 * Created by sunxiaodong on 2015/12/31.
 */
public class TestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        TestDB.init(getApplicationContext());
    }

}
