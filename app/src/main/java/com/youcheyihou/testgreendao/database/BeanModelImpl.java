package com.youcheyihou.testgreendao.database;

import com.youcheyihou.testgreendao.database.bean.Bean;
import com.youcheyihou.testgreendao.database.dao.BeanDao;

import java.util.List;

/**
 * Created by sunxiaodong on 2015/12/31.
 */
public class BeanModelImpl implements IBeanModel {

    private BeanDao mBeanDao;

    public BeanModelImpl() {
        mBeanDao = TestDB.getInstance().getBeanDao();
    }

    @Override
    public long insert(Bean entity) {
        return mBeanDao.insert(entity);
    }

    @Override
    public long insertWithoutSettingPk(Bean entity) {
        return 0;
    }

    @Override
    public long insertOrReplace(Bean entity) {
        return mBeanDao.insertOrReplace(entity);
    }

    @Override
    public void insertInTx(Iterable<Bean> entities) {

    }

    @Override
    public void insertInTx(Bean... entities) {

    }

    @Override
    public void insertInTx(Iterable<Bean> entities, boolean setPrimaryKey) {

    }

    @Override
    public void insertOrReplaceInTx(Iterable<Bean> entities, boolean setPrimaryKey) {

    }

    @Override
    public void insertOrReplaceInTx(Iterable<Bean> entities) {

    }

    @Override
    public void insertOrReplaceInTx(Bean... entities) {

    }

    @Override
    public List<Bean> loadAll() {
        return null;
    }

    @Override
    public Bean load(long key) {
        return null;
    }

    @Override
    public Bean loadByRowId(long rowId) {
        return null;
    }

    @Override
    public void refresh(Bean entity) {
        mBeanDao.refresh(entity);
    }

    @Override
    public void update(Bean entity) {
        mBeanDao.update(entity);
    }

    @Override
    public void updateInTx(Iterable<Bean> entities) {

    }

    @Override
    public void delete(long entity) {

    }

    @Override
    public void deleteByKey(long key) {

    }

    @Override
    public void deleteInTx(Iterable<Long> entities) {

    }

    @Override
    public void deleteInTx(long... entities) {

    }

    @Override
    public void deleteByKeyInTx(Iterable<Long> keys) {

    }

    @Override
    public void deleteByKeyInTx(long... keys) {

    }
}
