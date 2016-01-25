package com.consumer.wishdailyneeds.activity;

import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.model.ProductDTO;
import com.consumer.wishdailyneeds.service.DailyNeedService;
import com.consumer.wishdailyneeds.service.impl.DailyNeedServiceImpl;

public class CategoryActivity extends ActionBarActivity {

	private TextView categoryMilk, categoryWater = null;
	private ProgressBar categoryProgress = null;
	List<ProductDTO> categoryItem = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_category);

		setActionBarBackground();
		categoryProgress = (ProgressBar) findViewById(R.id.progressbar_category);
		categoryMilk = (TextView) findViewById(R.id.text_milk);
		categoryWater = (TextView) findViewById(R.id.text_water);

		/*
		 * if (savedInstanceState == null) {
		 * getFragmentManager().beginTransaction() .add(R.id.fragment_category,
		 * new WaterFragment()) .commit(); }
		 */
		new CategoryAsync().execute();
		
		categoryWater.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "water", Toast.LENGTH_SHORT).show();
				
			}
		});
		categoryMilk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "milk", Toast.LENGTH_SHORT).show();
				
			}
		});

	}

	private class CategoryAsync extends
			AsyncTask<List<ProductDTO>, Void, List<ProductDTO>> {

		@Override
		protected List<ProductDTO> doInBackground(List<ProductDTO>... params) {

			DailyNeedService dain = new DailyNeedServiceImpl();
			List<ProductDTO> allProductList = dain.getAllProductList();
			return allProductList;
		}

		@Override
		protected void onPostExecute(List<ProductDTO> result) {
//			categoryWater.setText(result.get(1).getProductName());
//			categoryMilk.setText(result.get(0).getProductName());
			categoryProgress.setVisibility(View.GONE);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuInflater menuInflater = getMenuInflater();
		menuInflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
	}

	private void setActionBarBackground() {
		ActionBar bar = this.getSupportActionBar();
		bar.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.action_bar_background));
	}

}
