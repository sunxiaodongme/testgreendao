package com.youcheyihou.testgreendao.database;

import com.youcheyihou.testgreendao.database.bean.Bean;

import java.util.List;

/**
 * Created by sunxiaodong on 2015/12/31.
 */
public interface IBeanModel {

    /**
     * Insert an entity into the table associated with a concrete DAO.
     *
     * @return row ID of newly inserted entity
     */
    long insert(Bean entity);

    /**
     * Insert an entity into the table associated with a concrete DAO <b>without</b> setting key property. Warning: This
     * may be faster, but the entity should not be used anymore. The entity also won't be attached to identy scope.
     *
     * @return row ID of newly inserted entity
     */
    long insertWithoutSettingPk(Bean entity);

    /**
     * Insert an entity into the table associated with a concrete DAO.
     *
     * @return row ID of newly inserted entity
     */
    long insertOrReplace(Bean entity);

    /**
     * Inserts the given entities in the database using a transaction.
     *
     * @param entities The entities to insert.
     */
    void insertInTx(Iterable<Bean> entities);

    /**
     * Inserts the given entities in the database using a transaction.
     *
     * @param entities The entities to insert.
     */
    void insertInTx(Bean... entities);

    /**
     * Inserts the given entities in the database using a transaction. The given entities will become tracked if the PK
     * is set.
     *
     * @param entities      The entities to insert.
     * @param setPrimaryKey if true, the PKs of the given will be set after the insert; pass false to improve performance.
     */
    void insertInTx(Iterable<Bean> entities, boolean setPrimaryKey);

    /**
     * Inserts or replaces the given entities in the database using a transaction. The given entities will become
     * tracked if the PK is set.
     *
     * @param entities      The entities to insert.
     * @param setPrimaryKey if true, the PKs of the given will be set after the insert; pass false to improve performance.
     */
    void insertOrReplaceInTx(Iterable<Bean> entities, boolean setPrimaryKey);

    /**
     * Inserts or replaces the given entities in the database using a transaction.
     *
     * @param entities The entities to insert.
     */
    void insertOrReplaceInTx(Iterable<Bean> entities);

    /**
     * Inserts or replaces the given entities in the database using a transaction.
     *
     * @param entities The entities to insert.
     */
    void insertOrReplaceInTx(Bean... entities);


    /** Loads all available entities from the database. */
    List<Bean> loadAll();

    /**
     * Loads and entity for the given PK.
     *
     * @param key a PK value or null
     * @return The entity or null, if no entity matched the PK value
     */
    Bean load(long key);

    Bean loadByRowId(long rowId);

    void refresh(Bean entity);//将数据库中的数据，刷新到存储Bean中

    void update(Bean entity);//数据库字段更新，数据库中的字段完全更新为entity中的数据，包括null，所以具体逻辑需要上层控制

    /**
     * Updates the given entities in the database using a transaction.
     *
     * @param entities The entities to insert.
     */
    void updateInTx(Iterable<Bean> entities);

    /**
     * Updates the given entities in the database using a transaction.
     *
     * @param entities The entities to update.
     */

    /** Deletes the given entity from the database. Currently, only single value PK entities are supported. */
    void delete(long entity);

    /** Deletes an entity with the given PK from the database. Currently, only single value PK entities are supported. */
    void deleteByKey(long key);

    /**
     * Deletes the given entities in the database using a transaction.
     *
     * @param entities The entities to delete.
     */
    void deleteInTx(Iterable<Long> entities);

    void deleteInTx(long... entities);

    /**
     * Deletes all entities with the given keys in the database using a transaction.
     *
     * @param keys Keys of the entities to delete.
     */
    void deleteByKeyInTx(Iterable<Long> keys);

    /**
     * Deletes all entities with the given keys in the database using a transaction.
     *
     * @param keys Keys of the entities to delete.
     */
    void deleteByKeyInTx(long... keys);

    //===========================================特定查询条件下的实体操作===========================================

    //更多的数据库操作，需要使用查询语句进行组合处理queryBuilder()后可组合
    // （where,whereOr,and,or,join,orderAsc,orderDesc,orderCustom,orderRaw,limit,list）

    //listLazy()       实体按需加载到内存。当列表中的其中一个元素第一次被访问，它会被加载并缓存备将来使用。使用完必须关闭。
    //listLazyUncached()       一个“虚拟”的实体列表：任何访问列表中的元素都会从数据库中读取。使用完必须关闭。
    //listIterator()       可迭代访问结果集，按需加载数据，数据不缓存。使用完必须关闭。

    //方法listLazy，listLazyUncached和 listIterator需使用greenDAO的LazyList类。
    //LazyList持有一个数据库游标，可按需加载数据。这也是为什么必须确保关闭懒加载列表和迭代器（通常使用try/finally包裹）。
    //listLazy()的懒加载列表和listIterator()懒加载迭代器，在所有元素被访为或遍历后自动关闭游标。但是，还是必须调用close()方法，防止list的执行过早结束。
}
