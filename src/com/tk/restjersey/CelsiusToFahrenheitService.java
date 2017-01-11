package com.tk.restjersey;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
 
@Path("/celsius")
public class CelsiusToFahrenheitService {
	
	/**
	 * Returns a XML result
	 */
	
	private static final double DEFAULT_CELSIUS_VALUE = 20;
	
	@GET
	@Produces("application/xml")
	public String convertCelsiusToFahrenheit() {
		return convertCelsiusToFahrenheit(DEFAULT_CELSIUS_VALUE);
	}
 
	@Path("{c}")
	@GET
	@Produces("application/xml")
	public String convertCelsiusToFahrenheit(@PathParam("c") Double c) {
		Double celsius = c;
		Double fahrenheit = ((celsius * 9) / 5) + 32;
 
		String result = "@Produces(\"application/xml\") Output: \n\nC to F Converter Output: \n\n" + fahrenheit;
		return "<ctofservice>" + "<celsius>" + celsius + "</celsius>" + "<ctofoutput>" + result + "</ctofoutput>" + "</ctofservice>";
	}
}