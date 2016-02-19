package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class TestDaoGenerator {

    private static final int CURR_DB_VERSION = 1;//当前数据库版本

    private static final String OUT_DIR = "../testgreendao/app/src/main/java";//生成文件输出基础路径

    private static final String DEFAULT_JAVA_PACKAGE = "com.youcheyihou.testgreendao";//默认实体类生成位置

    private static final String DEFAULT_JAVA_PACKAGE_DAO = "com.youcheyihou.testgreendao.database.dao";//dao文件生成位置

    private static final String DEFAULT_JAVA_PACKAGE_BEAN = "com.youcheyihou.testgreendao.database.bean";//bean文件生成位置

    private static final String BEAN_TABLE = "bean_table";//数据表名

    private static final String DATA_BEAN = "Bean";//数据Bean名

    public static void main(String[] args) throws Exception {
        TestDaoGenerator testDaoGenerator = new TestDaoGenerator();
        testDaoGenerator.generate();
    }

    private static Schema mSchema;//The "root" model class to which you can add entities to.

    public TestDaoGenerator() {
        mSchema = new Schema(CURR_DB_VERSION, DEFAULT_JAVA_PACKAGE);
        mSchema.setDefaultJavaPackageDao(DEFAULT_JAVA_PACKAGE_DAO);
        mSchema.enableActiveEntitiesByDefault();//是否激活实体
        mSchema.enableKeepSectionsByDefault();//是否使用sections,表示生成代码可编辑
        addBean();
    }

    public void generate() throws Exception {
        DaoGenerator daoGenerator = new DaoGenerator();
        daoGenerator.generateAll(mSchema, OUT_DIR);
    }

    private void addBean() {
        Entity beanEntity = mSchema.addEntity(DATA_BEAN);
        beanEntity.setJavaPackage(DEFAULT_JAVA_PACKAGE_BEAN);//设置bean文件生成路径
        beanEntity.setTableName(BEAN_TABLE);
        beanEntity.addIdProperty().primaryKey().unique().notNull();
        beanEntity.addIntProperty("int_field");
        beanEntity.addLongProperty("long_field");
        beanEntity.addShortProperty("short_field");
        beanEntity.addFloatProperty("float_field");
        beanEntity.addDoubleProperty("double_field");
        beanEntity.addByteProperty("byte_field");
        beanEntity.addByteArrayProperty("byte_array_field");
        beanEntity.addStringProperty("string_field");
        beanEntity.addBooleanProperty("boolean_field");
        beanEntity.addDateProperty("date_field");
    }

}
