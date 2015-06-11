package com.ebs.ckcest.WikiBookAction;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.restlet.resource.ResourceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ebs.WikiBookService.FocusContentService;
import com.ebs.WikiBookService.FocusService;
import com.opensymphony.xwork2.ActionSupport;

 
/**
 * @ClassName: FocusContentAction
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 5:52:39 PM
 * @version V1.0  
 */
@Scope("prototype")
@Component("focusContentAction")
public class FocusContentAction extends ActionSupport{

	
	/**
	 * @Fields serialVersionUID : TODO
	 */
		
	private static final long serialVersionUID = 3212521381391726009L;	
	private static Logger log = Logger.getLogger(FocusContentAction.class);
	
	private String keyword;
	private String result;
	
	@Autowired
	private FocusService focusService;
	@Autowired
	private FocusContentService focusContentService;
	
	
	
	/**
	 * @Function: getFocusContent
	 * @Description: TODO
	 * @param @return
	 * @param @throws ResourceException
	 * @param @throws IOException
	 * @param @throws JSONException    
	 * @return String    
	 * @date Jun 11, 2015 6:58:29 PM
	 * @throws
	 */
		
	public String getFocusContent() throws ResourceException, IOException, JSONException{
		result = focusContentService.getContentForFocus(keyword);
				
		return SUCCESS;
	}



	/**
	 * @return keyword
	 */
	
	public String getKeyword() {
		return keyword;
	}



	/**
	 * @param keyword 要设置的 keyword
	 */
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}



	/**
	 * @return result
	 */
	
	public String getResult() {
		return result;
	}



	/**
	 * @param result 要设置的 result
	 */
	
	public void setResult(String result) {
		this.result = result;
	}
	
	
	
	
}
