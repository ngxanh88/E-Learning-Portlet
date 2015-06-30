package de.uni.potsdam.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Query {

	private String queryStringUrl;

	public Query(String queryStringUrl) {
		this.queryStringUrl = queryStringUrl;
	}
	
	/**
	 * verbinden mit bestimmte URL und convert Json zu java object
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	public <T> T executeFromJson(Class<T> classOfT) throws Exception {
		final String data = getData(queryStringUrl);
		
        GsonBuilder builder = new GsonBuilder(); 
		
		final Gson gson=  builder.create();
		T tObject = null;
		tObject = gson.fromJson(data, classOfT);
		
        return tObject;
	}
	
	/**
	 * verbinden mit bestimmte URL und convert XML zu java object
	 * @param classOfT
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public <T> T executeFromXML(Class<T> classOfT) throws Exception {
		final String data = getData(queryStringUrl);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(classOfT);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		T tObject = (T) jaxbUnmarshaller.unmarshal(new StringReader(data));
		
		return tObject;
	}
	
	/**
	 * schicken Post request zur bestimmte URL
	 * @return true wenn 200 bekommt sonst false
	 * @throws Exception
	 */
	public boolean executeWithPostMethode() throws Exception {
		final URL obj = new URL(queryStringUrl);
	    final HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    
	    con.setRequestMethod("POST");
	    con.setRequestProperty("content-type", "application/json");
	    
	    con.setDoOutput(true);
	    final DataOutputStream wr = new DataOutputStream(con.getOutputStream());
	    wr.flush();
	    wr.close();
	    
	    final int responseCode = con.getResponseCode();
	    return responseCode == 200 ? true : false;
	}
	
	/**
	 * hilfe class zum URL verbinden.
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private String getData(String url) throws Exception{
		final StringBuilder stringBuilder = new StringBuilder();
		final URL oracle = new URL(url);
		final URLConnection yc = oracle.openConnection();
        final BufferedReader in = new BufferedReader(new InputStreamReader(
                                yc.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) 
            stringBuilder.append(inputLine);
        in.close();
        return stringBuilder.toString();
	}
}
