package com.test;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("VIEW")
public class PController{
		@RequestMapping
		public String render(RenderRequest renderRequest){
			if(renderRequest.getAttribute("view")==null)
				return "view";
			else
				return renderRequest.getAttribute("view").toString();
				
		}
			
		@RequestMapping(params={"action=submit"})
		public void submit(){
				/*
				 * SOME STUFF
				 */
		}
		
		@RequestMapping
		public void submit1(@RequestParam String name,ActionRequest actionRequest,ActionResponse actionResponse ){
				actionRequest.setAttribute("view", "view1");
				/*
				 * SOME STUFF
				 */
		}
}
