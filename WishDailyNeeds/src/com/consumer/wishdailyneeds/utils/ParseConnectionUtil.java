package com.consumer.wishdailyneeds.utils;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class ParseConnectionUtil {
	private final static String PARSE_URL = "https://api.parse.com/";
	private final static String APPLICATION_ID = "BODt20HM2EoHCHp5VZDQRnpSjeVUR3k6Ik32lHpo";
	private final static String REST_API_KEY = "Aqk4qWKXQ06HretvE2RjKUukGZ5EtPyY1Cw8WaK9";
	private final static String PARSE_VERSION = "1";
	private final static String PARSE_OBJECT = "/classes";
	private String string;


	@SuppressWarnings("deprecation")
	public String getParseConnectionObject(final String objectClass) {

		@SuppressWarnings("deprecation")
		HttpClient client = new DefaultHttpClient();
		@SuppressWarnings("deprecation")
		HttpGet httpGet = new HttpGet(PARSE_URL + PARSE_VERSION + PARSE_OBJECT
				+ "/" + objectClass);
		httpGet.addHeader("X-Parse-Application-Id", APPLICATION_ID);
		httpGet.addHeader("X-Parse-REST-API-Key", REST_API_KEY);

		HttpResponse res = null;
		try {
			res = client.execute(httpGet);
			string = EntityUtils.toString(res.getEntity());
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}
}
