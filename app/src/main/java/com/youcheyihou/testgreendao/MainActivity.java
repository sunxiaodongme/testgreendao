package com.youcheyihou.testgreendao;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.youcheyihou.testgreendao.database.BeanModelImpl;
import com.youcheyihou.testgreendao.database.IBeanModel;
import com.youcheyihou.testgreendao.database.bean.Bean;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView mText;
    TextView mText1;
    IBeanModel mIBeanModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        mText = (TextView) this.findViewById(R.id.text);
        mText1 = (TextView) this.findViewById(R.id.text1);
        initData();
    }

    private void initData() {
        mIBeanModel = new BeanModelImpl();
        //1.增加一个数据项
//        addBean();
        //2.刷新数据项
//        refreshBean();
        //3.更新数据库
//        updateBean();
        //4.插入更新数据库
        insertOrReplace();
    }

    private void addBean() {
        Bean bean = new Bean();
        bean.setId(2);
        bean.setInt_field(1);
        bean.setLong_field(1L);
        bean.setShort_field((short)1);
        bean.setFloat_field(1F);
        bean.setDouble_field(1D);
        bean.setByte_field(new Byte("1"));
//        bean.setByte_array_field();
        bean.setString_field("1");
        bean.setBoolean_field(true);
        bean.setDate_field(new Date());
        mText.setText(bean.toString());
        long i = mIBeanModel.insert(bean);
        Log.i("sxd", "addBean--i:" + i);
    }

    private void refreshBean() {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setInt_field(2);
        mText.setText(bean.toString());
        mIBeanModel.refresh(bean);
        mText1.setText(bean.toString());
    }

    private void updateBean() {
        Bean bean = new Bean();
        bean.setId(1);
        bean.setInt_field(2);
        mText.setText(bean.toString());
        mIBeanModel.update(bean);
    }

    private void insertOrReplace() {
        Bean bean = new Bean();
        bean.setId(2);
        bean.setInt_field(2);
        mText.setText(bean.toString());
        mIBeanModel.insertOrReplace(bean);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
