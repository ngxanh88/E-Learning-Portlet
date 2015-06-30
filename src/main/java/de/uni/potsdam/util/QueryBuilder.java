package de.uni.potsdam.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class QueryBuilder {
	
	private static final Object SLASH = "/";
	private static final Object AND = "&";
	private static final Object EQUALS_SIGN = "=";
	private static final String QUESTION_MARK = "?";
//	private static final String DEFAULT_HOST = "http://localhost:8084";
	
	private final StringBuilder pathParams = new StringBuilder();
	private final StringBuilder queryParams = new StringBuilder();
	
	private final String host;
	
	public QueryBuilder() {
		Properties prop = new Properties();
		InputStream inputStream = DefaultValue.class.getClassLoader().getResourceAsStream("config.properties");
		 
		try {
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		host = prop.getProperty("competenceHost");
	}
	
	/**
	 * neue Path-Parameter hinzufuegen.
	 * @param pathParam
	 * @return
	 */
	public QueryBuilder withPathParam(String pathParam){
		
		this.pathParams.append(SLASH);
		this.pathParams.append(pathParam);
		return this;
	}
	
	/**
	 * neue Query-Parameter hinzufuegen.
	 * @param queryParam
	 * @param value
	 * @return
	 */
	public QueryBuilder withQueryParam(String queryParam, String value){
		if(this.queryParams.length() > 0) {
			this.queryParams.append(AND);
		}
		this.queryParams.append(queryParam)
						.append(EQUALS_SIGN)
						.append(value);
		return this;
	}
	
	/**
	 * erstellen Query mit Path-Parameter und Query-Parameter 
	 * 
	 * @return
	 */
	public Query build(){
		return new Query(host + this.pathParams.toString() +
							QUESTION_MARK + this.queryParams.toString());
	}
}
