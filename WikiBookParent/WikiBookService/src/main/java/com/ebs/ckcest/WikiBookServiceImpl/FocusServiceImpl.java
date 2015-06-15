package com.ebs.ckcest.WikiBookServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebs.WikiBookDao.FocusLuceneSearcher;
import com.ebs.WikiBookService.FocusService;
import com.mysql.jdbc.log.Log;

 
/**
 * @ClassName: FocusServiceImpl
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 10:38:18 AM
 * @version V1.0  
 */
@Service("focusService")
public class FocusServiceImpl implements FocusService{
	
	private static Logger log = Logger.getLogger(FocusServiceImpl.class);
	
	/* (非 Javadoc)
	 * <p>Title: getFocuList</p>
	 * <p>Description: </p>
	 * @param topic
	 * @param k
	 * @return
	 * @see com.ebs.WikiBookService.FocusService#getFocuList(java.lang.String, int)
	 */
		
	public List<String> getFocusList(String topic, int k) {
		// TODO Auto-generated method stub
		List<String> res = new ArrayList<String>();
			
		String focusStr = "";
		try {
			focusStr = FocusLuceneSearcher.getFocusByTopic(topic);

			if(focusStr.length() == 0){
				log.info("topic: " + topic + "does have any focus !");
				return res;
			}
			
			JSONArray jsonArray = new JSONArray(focusStr);
			
			int count = 0;
			for(int i = 0; i < jsonArray.length(); i ++){
				if(count >= k)
					break;
				JSONObject jsonOject = jsonArray.getJSONObject(i);
				res.add(jsonOject.getString("focus"));
				count ++;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		return res;
		
	}
	
	
	public static void main(String[] args) throws IOException{
				
		String res = FocusLuceneSearcher.getFocusByTopic("PN结");
		System.out.println(res);
	}


}
