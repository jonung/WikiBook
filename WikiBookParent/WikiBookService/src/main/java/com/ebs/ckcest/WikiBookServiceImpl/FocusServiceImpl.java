package com.ebs.ckcest.WikiBookServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ebs.WikiBookDao.FocusLuceneSearcher;
import com.ebs.WikiBookService.FocusService;

 
/**
 * @ClassName: FocusServiceImpl
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 10:38:18 AM
 * @version V1.0  
 */
@Service("focusService")
public class FocusServiceImpl implements FocusService{

	
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
			
		String focusStr;
		try {
			focusStr = FocusLuceneSearcher.getFocusByTopic(topic);
			JSONArray jsonArray = new JSONArray(focusStr);
			
			int count = 0;
			for(int i = 0; i < jsonArray.length(); i ++){
				if(count > k)
					break;
				JSONObject jsonOject = jsonArray.getJSONObject(i);
				res.add(jsonOject.getString("focus"));
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

}
