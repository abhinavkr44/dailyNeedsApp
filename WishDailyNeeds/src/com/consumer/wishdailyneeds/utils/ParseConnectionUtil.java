package com.consumer.wishdailyneeds.utils;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class ParseConnectionUtil {
	private final static String PARSE_URL = "https://api.parse.com/";
	private final static String APPLICATION_ID = "BODt20HM2EoHCHp5VZDQRnpSjeVUR3k6Ik32lHpo";
	private final static String REST_API_KEY = "Aqk4qWKXQ06HretvE2RjKUukGZ5EtPyY1Cw8WaK9";
	private final static String PARSE_VERSION = "1";
	private final static String PARSE_OBJECT = "/classes";
	private WebResource resource;
	
	public ParseConnectionUtil(){
		DefaultClientConfig clientConfig= new DefaultClientConfig(JacksonJsonProvider.class);
		Client client = Client.create(clientConfig);
		resource = client.resource(PARSE_URL)
				.path(PARSE_VERSION)
				.path(PARSE_OBJECT);
	}

	public Builder getParseConnectionObject(final String objectClass){
		Builder builder = resource.path(objectClass)
				.header("X-Parse-Application-Id", APPLICATION_ID)
				.header("X-Parse-REST-API-Key", REST_API_KEY)
				.accept(MediaType.APPLICATION_JSON);
		return builder;
	}
}
