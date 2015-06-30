package maintest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import de.uni.potsdam.dto.CourseCompetenceDto;
import de.uni.potsdam.dto.LearnPathDto;
import de.uni.potsdam.dto.UserCompetenceDto;

public class DataCrawler {

//	private static final String BASE_URL = "http://www.escasia.net:8080/shop/";
	
	public static String getData(String url) {
		final StringBuilder stringBuilder = new StringBuilder();
		try {
			URL oracle = new URL(url);
			URLConnection yc = oracle.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	                                yc.getInputStream()));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) 
	            stringBuilder.append(inputLine);
	        in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return stringBuilder.toString();
	}
	
	public static LearnPathDto getLearnPath() {
		final String url = "http://localhost:8084/competences/json/prerequisite/graph/university";
		final String data = getData(url);
		
		GsonBuilder builder = new GsonBuilder(); 
		
		final Gson gson=  builder.create();
		LearnPathDto learnPathDto =  null;
		try{
			learnPathDto = gson.fromJson(data, LearnPathDto.class);
		}catch(Exception ex){
			System.out.println(ex);
			return null;
		}
		return learnPathDto;
	}
	
	public static void getUserCompetences() {
		final String url = "http://localhost:8084/competences/json/link/overview/Admin%20User";
		final String data = getData(url);
		
		GsonBuilder builder = new GsonBuilder(); 
		
		final Gson gson=  builder.create();
		UserCompetenceDto userCompetenceDto = null;
		try{
			userCompetenceDto = gson.fromJson(data, UserCompetenceDto.class);
			System.out.println(userCompetenceDto);
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
	
	public static void getCompetence() throws JAXBException {
		final String url = "http://localhost:8084/competences/xml/competencetree/university/all/nocache";
		final String data = getData(url);
		
		JAXBContext jaxbContext = JAXBContext.newInstance(CourseCompetenceDto.class);
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		StringReader reader = new StringReader(data);
		CourseCompetenceDto customer = (CourseCompetenceDto) jaxbUnmarshaller.unmarshal(reader);
		System.out.println(customer);
	}
}
