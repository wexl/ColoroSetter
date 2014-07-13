package com.coloro.main;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.coloro.R;

public class SplashActivity extends Activity {
	/**
	 * 定义Splash最短时间
	 */
	private static final int SHOW_TIME_MIN = 2000;

	/**
	 * 程序名称
	 */
	private TextView appName;
	/**
	 * 程序版本
	 */
	private  TextView appVersion;
	/**
	 * 程序描述
	 */
	private TextView appDescription;
	/**
	 * 版权信息
	 */
	private TextView copyRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new AsyncTask<Void, Void, String>() {
			@Override
			protected String doInBackground(Void... params) {
				String result="0";
				long startTime = System.currentTimeMillis();
				//后台耗时操作
				result="2.0";
				long loadingTime = System.currentTimeMillis() - startTime;
				if (loadingTime < SHOW_TIME_MIN) {
                    try {
                        Thread.sleep(SHOW_TIME_MIN - loadingTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

				return result;
			}

			@Override
			protected void onPostExecute(String result) {
				//根据执行结果更新UI
				appVersion = (TextView) findViewById(R.id.app_version);
				appVersion.setText(result);
				//
				Intent  intent = new Intent(SplashActivity.this,LoginActivity.class);
				startActivity(intent);
				finish();
				overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
			}

		}.execute(new Void[] {});
	}
}
