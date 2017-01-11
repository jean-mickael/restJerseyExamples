package com.tk.restjersey;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/weather")
public class WeatherService {
	
	private static final String WEATHER_API_URL = "api.openweathermap.org/data/2.5/weather?zip=";
	private static final String WEATHER_APP_ID = "&appid=3fc4f975042ac1f526178dc791d189af";
	private static final int DEFAULT_ZIP_CODE = 94158;
 
	  @GET
	  @Produces("application/json")
	  public Response getWeather() throws JSONException {
		  return getWeatherFromZip(DEFAULT_ZIP_CODE);
	  }
	  
	  @Path("{zip}")
	  @GET
	  @Produces("application/json")
	  public Response getWeatherFromZip(@PathParam("zip") int zipCode) throws JSONException {
 
		  URL url = getAPIUrl(zipCode);
		  JSONObject jsonObject = getJSONObject(url);
			
	 
		  String result = "@Produces(\"application/json\") Output:  \n\n" + jsonObject;
		  return Response.status(200).entity(result).build();
	  }
	  
	  private final URL getAPIUrl(int zipCode) {
		  URL url = null;
		  try {
			url = new URL("http://"+WEATHER_API_URL+zipCode+",us"+WEATHER_APP_ID);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		  return url;
	  }
	  
	  private JSONObject getJSONObject(URL url) {
		  JSONObject jsonObject = null;
		  BufferedReader reader = null;
		  String source = null;
		  try {
			  reader = new BufferedReader(new InputStreamReader(url.openStream()));
			  StringBuffer buffer = new StringBuffer();
			  int read;
			  char[] chars = new char[1024];
			  while ((read = reader.read(chars)) != -1)
				  buffer.append(chars, 0, read); 
			  source = buffer.toString();
			  jsonObject = new JSONObject(source);
			  reader.close();
		  } catch (Exception e) {
		  }
		  
		  return jsonObject;
	  }
}