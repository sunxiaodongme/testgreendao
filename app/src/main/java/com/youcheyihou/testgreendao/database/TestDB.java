package com.youcheyihou.testgreendao.database;

import android.content.Context;

import com.youcheyihou.testgreendao.database.dao.BeanDao;
import com.youcheyihou.testgreendao.database.dao.DaoMaster;
import com.youcheyihou.testgreendao.database.dao.DaoSession;
import com.youcheyihou.testgreendao.database.helper.TestDevOpenHelper;

/**
 * Created by sunxiaodong on 2015/12/31.
 */
public class TestDB {

    private static final String DATABASE_NAME = "testgreendao.db";//数据库名

    private static TestDB sInstance;

    private Context mContext;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;

    private TestDB(Context context) {
        mContext = context.getApplicationContext();
        getDaoMaster(mContext);
        getDaoSession(mContext);
    }

    public static synchronized void init(Context context) {
        if (sInstance == null) {
            sInstance = new TestDB(context);
        }
    }

    public static TestDB getInstance() {
        if (sInstance == null) {
            throw new ExceptionInInitializerError("TestDB not init!");
        }
        return sInstance;
    }

    public DaoMaster getDaoMaster(Context context) {
        if (mDaoMaster == null) {
            DaoMaster.OpenHelper helper = new TestDevOpenHelper(context, DATABASE_NAME, null);
            mDaoMaster = new DaoMaster(helper.getWritableDatabase());
        }
        return mDaoMaster;
    }

    public DaoSession getDaoSession(Context context) {
        if (mDaoSession == null) {
            mDaoMaster = getDaoMaster(context);
            mDaoSession = mDaoMaster.newSession();
        }
        return mDaoSession;
    }

    public BeanDao getBeanDao() {
        return mDaoSession.getBeanDao();
    }

}
