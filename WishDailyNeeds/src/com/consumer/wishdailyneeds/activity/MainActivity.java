package com.consumer.wishdailyneeds.activity;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.model.Product;

public class MainActivity extends Activity {

	private List<Product> products = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);

//		products = new ArrayList<Product>();
//		products = (ArrayList<Product>) getIntent().getSerializableExtra(
//				Const.EXTRAS_PRODUCT_LIST);
//		TextView tv = (TextView) findViewById(R.id.text_temp);
//
//		if (products != null) {
//			for (int i = 0; i < products.size(); i++) {
//				Log.v("name", products.get(i).getProductName());
//			}
//
//			tv.setText(products.get(0).getProductName() + " and"
//					+ products.get(1).getProductName());
//		}

	}
}
