package com.coloro.main;

import com.coloro.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class WelcomeAcitvity extends Activity implements Runnable {
	
	/**
	 * 定义Splash最短时间
	 */
	private static final int SHOW_TIME_MIN = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);
		/**
		 * 启动一个延迟线程
		 */
		new Thread(this).start();
	}

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		// TODO 运行后台加载数据和资源等耗时操作
		long loadingTime = System.currentTimeMillis() - startTime;
		if (loadingTime < SHOW_TIME_MIN) {
            try {
                Thread.sleep(SHOW_TIME_MIN - loadingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
		
		startActivity(new Intent(WelcomeAcitvity.this,WelcomeGuideActivity.class));
		
		finish();

	}

}
