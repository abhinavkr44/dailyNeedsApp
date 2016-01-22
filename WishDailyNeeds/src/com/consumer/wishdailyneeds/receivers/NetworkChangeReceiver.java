package com.consumer.wishdailyneeds.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.consumer.wishdailyneeds.utils.Utils;

public class NetworkChangeReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(final Context context, final Intent intent) {

		Boolean isDataConnected = Utils.isDataConnected(context);

		//Toast.makeText(context, status, Toast.LENGTH_LONG).show();
	}
}