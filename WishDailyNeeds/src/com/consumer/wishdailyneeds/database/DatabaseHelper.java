package com.consumer.wishdailyneeds.database;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.consumer.wishdailyneeds.model.Product;
import com.consumer.wishdailyneeds.utils.Const;

public class DatabaseHelper extends SQLiteOpenHelper {

	private static final String TAG = "DatabaseHelper";

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "WishDailyNeeds";
	private static final String TABLE_PRODUCT = "product";

	// Product table create statement
	private static final String CREATE_TABLE_PRODUCT = "CREATE TABLE IF NOT EXISTS "
			+ TABLE_PRODUCT + "(" + Const.KEY_PRODUCT_ID
			+ " INTEGER PRIMARY KEY," + Const.KEY_PRODUCT_NAME + " TEXT NOT NULL)";

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// creating required tables
		db.execSQL(CREATE_TABLE_PRODUCT);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// on upgrade drop older tables
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
		// create new tables
		onCreate(db);
	}

	/**
	 * Creating a product
	 */
	public long createProduct(Product product) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(Const.KEY_PRODUCT_ID, product.getId());
		values.put(Const.KEY_PRODUCT_NAME, product.getProductName());

		// insert row
		long todo_id = db.insert(TABLE_PRODUCT, null, values);

		return todo_id;
	}

	/**
	 * getting all Product
	 * */
	public List<Product> getAllProduct() {
		List<Product> products = new ArrayList<Product>();
		String selectQuery = "SELECT  * FROM " + TABLE_PRODUCT;

		Log.d(TAG, selectQuery);

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Product product = new Product();
				product.setId(cursor.getInt((cursor
						.getColumnIndex(Const.KEY_PRODUCT_ID))));
				product.setProductName((cursor.getString(cursor
						.getColumnIndex(Const.KEY_PRODUCT_NAME))));

				// adding to product list
				products.add(product);
			} while (cursor.moveToNext());
		}

		return products;
	}

}
