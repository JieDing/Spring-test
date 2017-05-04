package test.SpringMVC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import test.pojo.PC;

@Controller
@RequestMapping("/pc")
public class MyController {


	
	 @RequestMapping(value="/action",method=RequestMethod.POST)
	    public @ResponseBody String launchVM(PC p,HttpServletRequest request,HttpServletResponse response) throws Exception {
		 	
		/* 
		 */
		/* response.setStatus(100000);
		 response.setContentType("application/json;charset=utf-8"); 
		
		 
		 try(PrintWriter out = response.getWriter();){  
			 out.print( "{\"id\":1,\"firstName\":\"Liam\",\"age\":22,\"lastName\":\"Marco\"}");
		 }*/
		 //System.out.println("fdsafdsafs");
		 
		 String targetURL = "http://localhost:8080/Spring-test/v2/"+p.getTenant_id()+"/servers/"+p.getServer_id()+"/action";
		 String output=null; 
		 try {

              URL targetUrl = new URL(targetURL);
              System.out.println(targetURL);
              HttpURLConnection httpConnection = (HttpURLConnection) targetUrl.openConnection();
              httpConnection.setDoOutput(true);
              httpConnection.setRequestMethod("POST");
              httpConnection.setRequestProperty("Content-Type", "application/json");

              String input  = "{\"os-start\":null}";

              OutputStream outputStream = httpConnection.getOutputStream();
              outputStream.write(input.getBytes());
              outputStream.flush();
              
              if (httpConnection.getResponseCode() != 200) {
                     throw new RuntimeException("Failed : HTTP error code : "
                            + httpConnection.getResponseCode());
              }

              BufferedReader responseBuffer = new BufferedReader(new InputStreamReader(
                            (httpConnection.getInputStream())));

             
              
              if ((output =(String) responseBuffer.readLine()) != null) {
                     System.out.println(output);
              }

              httpConnection.disconnect();

         } catch (MalformedURLException e) {

              e.printStackTrace();

         } catch (IOException e) {

              e.printStackTrace();

        }
		 return output;
	    // return "forward:/v2/"+p.getTenant_id()+"/servers/"+p.getServer_id()+"/action";
	        
	        
	        
	 }
	 
	
}