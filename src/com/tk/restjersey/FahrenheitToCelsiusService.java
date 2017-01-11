package com.tk.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;
 
@Path("/fahrenheit")
public class FahrenheitToCelsiusService {
	
	/**
	 * Returns a JSON object
	 */
 
	private static final float DEFAULT_FAHRENHEIT_VALUE = 68;

	  @GET
	  @Produces("application/json")
	  public Response convertFahrenheitToCelsius() throws JSONException {
		return convertFahrenheitToCelsius(DEFAULT_FAHRENHEIT_VALUE);
	  }
 
	  @Path("{f}")
	  @GET
	  @Produces("application/json")
	  public Response convertFahrenheitToCelsius(@PathParam("f") float f) throws JSONException {
 
		JSONObject jsonObject = new JSONObject();
		float celsius;
		celsius =  (f - 32)*5/9; 
		jsonObject.put("Fahrenheit Value", f); 
		jsonObject.put("Celsius Value", celsius);
 
		String result = "@Produces(\"application/json\") Output: \n\nF to C Converter Output: \n\n" + jsonObject;
		return Response.status(200).entity(result).build();
	  }
}