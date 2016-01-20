package com.consumer.wishdailyneeds.fragments;

import com.app.consumer.wishdailyneeds.R;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class WaterFragment extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {

		// Inflate the layout for this fragment
		View rootView = inflater.inflate(R.layout.layout_fragment_water, container, false);
		
        return rootView;

	}

}
