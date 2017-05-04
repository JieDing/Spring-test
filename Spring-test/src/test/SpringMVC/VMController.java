package test.SpringMVC;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/v2")
public class VMController {
	//   
	@RequestMapping(value="/{tenant_id}/servers/{server_id}/action",method=RequestMethod.POST)
    public @ResponseBody String setProducts(@PathVariable String tenant_id,@PathVariable String server_id,HttpServletRequest request,HttpServletResponse response) throws Exception {
		/*response.setStatus(1000000);
		System.out.println(response.getStatus());
        request.setAttribute("tenant_id", tenant_id);
        request.setAttribute("server_id", server_id);*/
       /* request.setAttribute("json", o.get("os-start"));*/
        
        return "202";
            
 }
	
	
	
}
