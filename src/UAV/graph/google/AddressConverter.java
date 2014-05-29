/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UAV.graph.google ;

/**
 *
 * @author Mustansir
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.codehaus.jackson.map.ObjectMapper;
        
        
        
        
public class AddressConverter {
 /*
  * Geocode request URL. Here see we are passing "json" it means we will get
  * the output in JSON format. You can also pass "xml" instead of "json" for
  * XML output. For XML output URL will be
  * "http://maps.googleapis.com/maps/api/geocode/xml";
  */

 private static final String URL = "http://maps.googleapis.com/maps/api/geocode/json";

 /*
  * Here the fullAddress String is in format like
  * "address,city,state,zipcode". Here address means "street number + route"
  * .
  */
 public GoogleResponse convertToLatLong(String fullAddress) throws IOException {

  /*
   * Create an java.net.URL object by passing the request URL in
   * constructor. Here you can see I am converting the fullAddress String
   * in UTF-8 format. You will get Exception if you don't convert your
   * address in UTF-8 format. Perhaps google loves UTF-8 format. :) In
   * parameter we also need to pass "sensor" parameter. sensor (required
   * parameter) — Indicates whether or not the geocoding request comes
   * from a device with a location sensor. This value must be either true
   * or false.
   */
  
  URL url = new URL(URL + "?address="
    + URLEncoder.encode(fullAddress, "UTF-8") + "&sensor=false");
  // Open the Connection
  URLConnection conn = url.openConnection();

  InputStream in = conn.getInputStream() ;
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response;
  

 }
 
 public GoogleResponse convertFromLatLong(String latlongString) throws IOException {

  /*
   * Create an java.net.URL object by passing the request URL in
   * constructor. Here you can see I am converting the fullAddress String
   * in UTF-8 format. You will get Exception if you don't convert your
   * address in UTF-8 format. Perhaps google loves UTF-8 format. :) In
   * parameter we also need to pass "sensor" parameter. sensor (required
   * parameter) — Indicates whether or not the geocoding request comes
   * from a device with a location sensor. This value must be either true
   * or false.
   */
  URL url = new URL(URL + "?latlng="
    + URLEncoder.encode(latlongString, "UTF-8") + "&sensor=false");
  // Open the Connection
  URLConnection conn = url.openConnection();

  InputStream in = conn.getInputStream() ;
  ObjectMapper mapper = new ObjectMapper();
  GoogleResponse response = (GoogleResponse)mapper.readValue(in,GoogleResponse.class);
  in.close();
  return response;
  

 }

 
 public  String calculatelatitude(String address){
  String latitude = new String();
    
   try{
  GoogleResponse res = new AddressConverter().convertToLatLong(address);
  if(res.getStatus().equals("OK"))
  {
   for(Result result : res.getResults())
   {
    latitude =result.getGeometry().getLocation().getLat();
    return latitude;  
     
     
     
    
   }
  }
   else
  {
   System.out.println(res.getStatus());
  }
   
   }catch ( IOException e){}   
   return latitude;
      
  }
 
 public String calculateLongitude(String address){
     
  String longitude = new String();
  try
  {
   
  GoogleResponse res = new AddressConverter().convertToLatLong(address);
  if(res.getStatus().equals("OK"))
  {
   for(Result result : res.getResults())
   {
    
    
    longitude = result.getGeometry().getLocation().getLng();
    return longitude;   
 
    
   }
  }
   else
  {
   System.out.println(res.getStatus());
  }
  }catch(IOException e){}
   
  return longitude;
 }
    
     

 }
 
 


