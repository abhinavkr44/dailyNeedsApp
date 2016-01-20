package com.consumer.wishdailyneeds.activity;

import android.app.Activity;
import android.os.Bundle;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.fragments.WaterFragment;

public class CategoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_category);
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.fragment_category, new WaterFragment())
					.commit();
		}

	}

}
