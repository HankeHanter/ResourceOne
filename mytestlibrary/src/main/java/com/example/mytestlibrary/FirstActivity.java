
package com.example.mytestlibrary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oneactivity.ShutUpPlease;

public class FirstActivity extends Activity {
	
	private TextView tv;
	
	private Button btn;
	
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//下面都是获得R文件下面的资源标识的例子
		setContentView(ResourceUtil.getLayoutId(FirstActivity.this,"activity_first"));
		tv = (TextView) findViewById(ResourceUtil.getId(FirstActivity.this,"tv"));
		btn = (Button) findViewById(ResourceUtil.getId(FirstActivity.this,"btn"));
		img = (ImageView) findViewById(ResourceUtil.getId(FirstActivity.this,"img"));
		tv.setText("hello");
		look();
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				Intent data = getIntent();
				data.putExtra(IntentUtils.RESULT_NAME, "交易取消");
				setResult(IntentUtils.FIRST_RESULT_CODE,data);
				finish();
			}
		});
	}
	
	private void look() {
		ShutUpPlease.shut(FirstActivity.this);
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.e("onStart", "onStart");
	}

}
