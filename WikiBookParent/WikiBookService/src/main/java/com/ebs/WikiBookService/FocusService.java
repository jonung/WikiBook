package com.ebs.WikiBookService;

import java.util.List;

 
/**
 * @ClassName: FocusService
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 10:35:18 AM
 * @version V1.0  
 */

public interface FocusService {
	//get top k focus list by a topic name
	List<String> getFocusList(String topic, int k);
}
