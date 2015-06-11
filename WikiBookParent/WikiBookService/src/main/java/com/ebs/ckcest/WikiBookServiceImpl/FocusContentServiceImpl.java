package com.ebs.ckcest.WikiBookServiceImpl;

import java.io.IOException;

import com.ebs.WikiBookService.FocusContentService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.springframework.stereotype.Service;



 
/**
 * @ClassName: FocusContentServiceImpl
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 6:00:26 PM
 * @version V1.0  
 */

@Service("focusContentService")
public class FocusContentServiceImpl implements FocusContentService{

	
	/* (非 Javadoc)
	 * <p>Title: getContentForFocus</p>
	 * <p>Description:  根据focus得到图书中对应的一章</p>
	 * @param focus
	 * @return
	 * @see com.ebs.WikiBookService.FocusContentService#getContentForFocus(java.lang.String)
	 */
		
	public String getContentForFocus(String focus) throws ResourceException, IOException, JSONException {
		// TODO Auto-generated method stub
		
		String str = "";
		ClientResource client = new ClientResource("http://www.ckcest.zju.edu.cn/EngineeringWS/Catalog/" + focus);
		String result = client.get().getText();
		client.release();
		JSONArray jso = new JSONObject(result).getJSONObject("data").getJSONArray("rows");
					
		for(int i = 0; i < jso.length(); i ++) {
			JSONObject item = jso.getJSONObject(i);
			
			String content = item.getString("Content");
			if(content.length() == 0) {
				continue;
			}
			else{
				str = content;
				str = str.replaceAll("\r\n", "");
				//System.out.println(str);			
				break;
			}
		}
		
		
		return str;
		
	}

}
