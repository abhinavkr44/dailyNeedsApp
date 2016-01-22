package com.consumer.wishdailyneeds.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Utils {

	public static int TYPE_NOT_CONNECTED = 0;
	public static int TYPE_WIFI = 1;
	public static int TYPE_MOBILE = 2;

	private static int getConnectivityStatus(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);

		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		if (activeNetwork != null) {
			if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
				return TYPE_WIFI;

			if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
				return TYPE_MOBILE;
		}
		return TYPE_NOT_CONNECTED;
	}

	private static String getConnectivityStatusString(Context context) {
		int conn = getConnectivityStatus(context);
		String status = null;
		if (conn == Utils.TYPE_WIFI) {
			status = "Wifi enabled";
		} else if (conn == Utils.TYPE_MOBILE) {
			status = "Mobile data enabled";
		} else if (conn == Utils.TYPE_NOT_CONNECTED) {
			status = "Not connected to Internet";
		}
		return status;
	}

	public static boolean isDataConnected(Context context) {
		if (getConnectivityStatus(context) == 0)
			return false;
		else
			return true;
	}
}
