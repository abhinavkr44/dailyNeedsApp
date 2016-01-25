/**
 * The DailyNeedDAOImpl class implements 
 * methods to fetch brands and category of products.
 * @author  Abhinav Kumar
 * @version 1.0
 * @since   2016-01-19 
 */
package com.consumer.wishdailyneeds.dao.impl;

import android.util.Log;

import com.consumer.wishdailyneeds.dao.DailyNeedDAO;
import com.consumer.wishdailyneeds.utils.ParseConnectionUtil;

public class DailyNeedDAOImpl implements DailyNeedDAO {

	private final static String BRAND = "/Brand";
	private final static String PRODUCT_DETAIL = "/ProductDetail";
	private final static String PRODUCT = "/Products";

	private ParseConnectionUtil parse = new ParseConnectionUtil();

	@Override
	public String getAllProductList() {
		String res = parse.getParseConnectionObject(PRODUCT);
		Log.v("res", res);
		return res;
	}

	@Override
	public String getAllBrandList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAllProductDetailList() {
		// TODO Auto-generated method stub
		return null;
	}

}
