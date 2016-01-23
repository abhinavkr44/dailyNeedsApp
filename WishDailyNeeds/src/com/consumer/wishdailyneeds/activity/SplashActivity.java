package com.consumer.wishdailyneeds.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.database.DatabaseHelper;
import com.consumer.wishdailyneeds.model.Product;
import com.consumer.wishdailyneeds.utils.Const;
import com.consumer.wishdailyneeds.utils.Utils;

public class SplashActivity extends Activity {

	private static final String TAG = "SplashActivity";
	private static int SPLASH_TIME_OUT = 2000;
	private ProgressBar mProgressBar = null;
	private Context mContext = null;
	private DatabaseHelper db = null;
	private List<Product> productList = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_splash);

		mContext = this;
		mProgressBar = (ProgressBar) findViewById(R.id.progressbar_splash);

		init();

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				if (Utils.isDataConnected(getApplicationContext())) {
					Intent intent = new Intent(SplashActivity.this,
							CategoryActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					startActivity(intent);

				} else {
					Intent intent = new Intent(SplashActivity.this,
							MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					intent.putExtra(Const.EXTRAS_PRODUCT_LIST,
							(Serializable) productList);
					startActivity(intent);
					// Dialogs.getDialogs().dialogOfflineOrder(mContext);
				}
				mProgressBar.setVisibility(View.GONE);
				finish();
			}
		}, SPLASH_TIME_OUT);

	}

	private void init() {
		db = new DatabaseHelper(getApplicationContext());
		productList = new ArrayList<Product>();

		Product milk = new Product(2, "Milk");
		Product water = new Product(1, "Water");
		long waterRes = db.createProduct(water);
		long milkRes = db.createProduct(milk);

		Log.d(TAG, "Water product inserted response = " + waterRes
				+ " and Milk product inserted response = " + milkRes);

		productList = db.getAllProduct();
	}
}
