package com.ebs.ckcest.WikiBookAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ebs.WikiBookService.FocusService;
import com.opensymphony.xwork2.ActionSupport;

 
/**
 * @ClassName: FocusObtainAction
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 11:32:27 AM
 * @version V1.0  
 */

@Scope("prototype")
@Component("focusObtainAction")
public class FocusObtainAction extends ActionSupport{
	
	
	/**
	 * @Fields serialVersionUID : TODO
	 */
		
	private static final long serialVersionUID = 2813446200617442634L;
	private static Logger log = Logger.getLogger(FocusObtainAction.class);
	
	private String topic = "PN结";
	private int k = 10;
	private String result;
	
	@Autowired
	private FocusService focusService;
	
	
	
	/**
	 * @Function: getFocus
	 * @Description: 给定topic和k，返回k个focus
	 * @param @return
	 * @param @throws JSONException    
	 * @return String    
	 * @date Jun 11, 2015 2:50:35 PM
	 * @throws
	 */
		
	public String getFocus() throws JSONException{
		
		List<String> resList = focusService.getFocusList(topic, k);
		JSONArray jsonArray = new JSONArray();
		
		for(int i = 0; i < resList.size(); i ++){
			JSONObject jsonObject = new JSONObject();
			
			String value =  topic + resList.get(i);
			jsonObject.put("focus", value);
			
			log.info(jsonObject.toString());
			
			jsonArray.put(jsonObject);
		}
		
		result = jsonArray.toString();
		
		log.info("Topic: " + topic + " K: " + k);
		log.info("result: " + result);
		return SUCCESS;
	}


	/**
	 * @return topic
	 */
	
	public String getTopic() {
		return topic;
	}


	/**
	 * @param topic 要设置的 topic
	 */
	
	public void setTopic(String topic) {
		this.topic = topic;
	}


	/**
	 * @return k
	 */
	
	public int getK() {
		return k;
	}


	/**
	 * @param k 要设置的 k
	 */
	
	public void setK(int k) {
		this.k = k;
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
