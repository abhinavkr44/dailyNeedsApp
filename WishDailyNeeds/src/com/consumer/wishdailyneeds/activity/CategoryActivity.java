package com.consumer.wishdailyneeds.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.app.consumer.wishdailyneeds.R;

public class CategoryActivity extends Activity {
	
	private ProgressBar categoryProgress = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_category);
		
		categoryProgress = (ProgressBar)findViewById(R.id.progressbar_category);
		
		/*if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.fragment_category, new WaterFragment())
					.commit();
		}*/
		
		TextView tv = (TextView) findViewById(R.id.text_temp);

	}

}
