package com.youcheyihou.testgreendao.database.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.youcheyihou.testgreendao.database.dao.DaoMaster;

/**
 * Created by sunxiaodong on 2015/12/31.
 */
public class TestDevOpenHelper extends DaoMaster.OpenHelper {


    public TestDevOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库升级

    }

}
