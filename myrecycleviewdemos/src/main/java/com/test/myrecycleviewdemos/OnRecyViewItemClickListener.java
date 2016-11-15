package com.test.myrecycleviewdemos;

import android.view.View;

/**
 * Created by Administrator on 2016/11/15.
 */
public interface OnRecyViewItemClickListener {

    void onClick(View view,int position);

    void onLongClick(View view,int position);
}
