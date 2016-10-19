package com.test.testrefreshlayoutdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private SwipeRefreshLayout swipeRefLy;

    private ListView lv;

    private ArrayAdapter<String> mAdapter;

    public static final int A = 2;

    private ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefLy = (SwipeRefreshLayout) findViewById(R.id.swipe_ref_ly);
        lv = (ListView) findViewById(R.id.lv);
        mData = new ArrayList<String>();
        mData.add("aa");
        mData.add("bbb00");
        mData.add("ccc");
        mAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,mData);
        lv.setAdapter(mAdapter);
        swipeRefLy.setColorSchemeResources(R.color.orange,R.color.skyBlue,R.color.brown);
        //,R.color.skyBlue,R.color.brown
        swipeRefLy.setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        new Thread() {
            @Override
            public void run() {
                Message message = Message.obtain(mHandler);
                mHandler.sendEmptyMessageDelayed(A,5000);

            }
        }.start();
        //刷新时候需要添加的数据操作全部都在这
//        if (mData != null) {
//            mData.add("aa");
//            mData.add("bbb00");
//            mData.add("ccc");
//            mAdapter.notifyDataSetChanged();
//            if (swipeRefLy.isRefreshing()) {
//                swipeRefLy.setRefreshing(false);
//            }
//        }

    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case A:
                if (mData != null) {
                    mData.add("aa");
                    mData.add("bbb00");
                    mData.add("ccc");
                    mAdapter.notifyDataSetChanged();
                    if (swipeRefLy.isRefreshing()) {
                        swipeRefLy.setRefreshing(false);
                    }
                }
                break;
                default:
                    break;
            }

        }
    };
}
