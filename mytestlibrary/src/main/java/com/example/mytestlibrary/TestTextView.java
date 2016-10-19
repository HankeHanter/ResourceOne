package com.example.mytestlibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

public class TestTextView extends TextView {
	
	private String[] attrsStr = {"txtSize","txtStr"};
	
	public TestTextView(Context context, AttributeSet attrs) {
		super(context, attrs);
//		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.texts);	原本应该是这样获取declare - style数组的
		TypedArray ta = context.obtainStyledAttributes(attrs, ResourceUtil.getDeclareStybleId(context, attrsStr));
		
//		int text = ta.getInteger(R.styleable.tests_txtSize, -1);	原本应该是这样获取styleable下面的attr属性的
		//TypedArray.getInteger(int index, int defValue)的下标其实就是styleable里面属性的列表顺序，所以可以直接用数组的下表来代替
		int text = ta.getInteger(ResourceUtil.getDeclareAttrIndex(attrsStr, attrsStr[0]), -1);
		String str = ta.getString(ResourceUtil.getDeclareAttrIndex(attrsStr, attrsStr[1]));
		setTextSize(text);
		setText(str);
		ta.recycle();
	}

}
