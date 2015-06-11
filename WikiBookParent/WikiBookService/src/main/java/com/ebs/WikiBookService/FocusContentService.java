package com.ebs.WikiBookService;

import java.io.IOException;

import org.json.JSONException;
import org.restlet.resource.ResourceException;

 
/**
 * @ClassName: FocusContentService
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 5:58:15 PM
 * @version V1.0  
 */

public interface FocusContentService {
	//get the chapter content for each focus
	public String getContentForFocus(String focus) throws ResourceException, IOException, JSONException;
}
