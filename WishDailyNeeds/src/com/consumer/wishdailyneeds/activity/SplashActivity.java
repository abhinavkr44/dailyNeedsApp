package com.consumer.wishdailyneeds.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.utils.NetworkUtil;

public class SplashActivity extends Activity {

	private static int SPLASH_TIME_OUT = 3000;
	ProgressBar mProgressBar = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_splash);

		mProgressBar = (ProgressBar) findViewById(R.id.progressbar_splash);

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (dataConnected()) {
					Toast.makeText(getApplicationContext(), "online",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(SplashActivity.this,
							MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);
				} else {
					mProgressBar.setVisibility(View.GONE);
					Toast.makeText(getApplicationContext(), "offline",
							Toast.LENGTH_SHORT).show();

				}
				mProgressBar.setVisibility(View.GONE);
				finish();

			}
		}, SPLASH_TIME_OUT);

	}

	private boolean dataConnected() {
		if (NetworkUtil.getConnectivityStatus(this) == 0)
			return false;
		else
			return true;
	}

}
