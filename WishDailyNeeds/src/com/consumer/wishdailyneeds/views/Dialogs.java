package com.consumer.wishdailyneeds.views;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import com.app.consumer.wishdailyneeds.R;
import com.consumer.wishdailyneeds.activity.SplashActivity;

public class Dialogs {
	private Context mContext;
	
	private Dialogs(){}
	
	public synchronized static Dialogs getDialogs(){
		return new Dialogs();
	}

	public void dialogOfflineOrder(final Context context) {
		mContext = (SplashActivity) context;
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		alertDialogBuilder.setTitle(R.string.dialog_offline_title);

		alertDialogBuilder.setPositiveButton(R.string.dialog_offiline_ok,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						Toast.makeText(context, "Order Offline",
								Toast.LENGTH_LONG).show();
					}
				});

		alertDialogBuilder.setNegativeButton(R.string.dialog_offiline_cancel,
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						((SplashActivity) mContext).finish();
					}
				});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.setCanceledOnTouchOutside(false);
		alertDialog.setCancelable(false);
		alertDialog.show();
	}

}
