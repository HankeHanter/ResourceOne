package com.test.myrecycleviewdemos;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private MyAdapter adapter;

    private ArrayList<String> myData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

/*
    * 你想要控制其显示的方式，请通过布局管理器LayoutManager
    * 你想要控制Item间的间隔（可绘制），请通过ItemDecoration
    * 你想要控制Item增删的动画，请通过ItemAnimator
    * 你想要控制点击、长按事件，请自己写（擦，这点尼玛。）*/
    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        myData = new ArrayList<String>();
        adapter = new MyAdapter(MainActivity.this,myData);
        //水平布局
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false));
/*        默认是竖直的
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));*/

        //注意，前后布局方式得一致
        recyclerView.addItemDecoration(new DivideItemDecorator(MainActivity.this,DivideItemDecorator.HORIZONTAL_LIST));
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 15; i ++) {
            myData.add("你好" + i);
        }
        adapter.notifyDataSetChanged();
    }



    private class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

        private Context context;

        private ArrayList<String> datas;

        public MyAdapter(Context context,ArrayList<String> datas){
            this.context = context;
            this.datas = datas;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle_one,parent,false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(datas.get(position));
            holder.tv2.setText(datas.get(position));
            holder.tv3.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;
            TextView tv2;
            TextView tv3;

            public MyViewHolder(View view) {
                super(view);
                tv = (TextView) view.findViewById(R.id.tv);
                tv2 = (TextView) view.findViewById(R.id.tv2);
                tv3 = (TextView) view.findViewById(R.id.tv3);
            }
        }
    }
}
