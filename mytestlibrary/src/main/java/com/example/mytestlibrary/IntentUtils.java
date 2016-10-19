package com.example.mytestlibrary;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

public class IntentUtils {
	
	public static final int FIRST_REQUEST_CODE = 90;
	
	public static final int FIRST_RESULT_CODE = FIRST_REQUEST_CODE + 1;
	
	public static final String RESULT_NAME = "result_name";

	public static void startMainAct(Context context) {
		Intent intent = new Intent(context,FirstActivity.class);
		((Activity)context).startActivityForResult(intent, FIRST_REQUEST_CODE);
	}
}
