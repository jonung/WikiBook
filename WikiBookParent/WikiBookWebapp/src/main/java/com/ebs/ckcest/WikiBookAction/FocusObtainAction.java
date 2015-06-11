package com.ebs.ckcest.WikiBookAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
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
	
	private String topic = "传感器";
	private int k = 10;
	@Autowired
	private FocusService focusService;
	
	
	public String getFocus(){
		log.info("Hello Anonation");
		List<String> resList = focusService.getFocusList(topic, k);
		for(int i = 0; i < resList.size(); i ++)
			log.info(resList.get(i));
		
		
		return SUCCESS;
	}
	
}
