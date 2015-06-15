package com.ebs.ckcest.imgService;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.nodes.Document;




 /**
 * @ClassName: CrawlerImagesAndPages
 * @Description: 
 * @author VictoryLee
 * @date 2014-11-10 下午03:21:31
 * 
 */
public class CrawlerImagesAndPages {
	/**
	 * @throws JSONException 
	* @Title: get
	* @Description: TODO
	* @param url:image search url
	* @param topK: the first k results
	* @return List<Image>    
	* @throws
	*/
	public static String get(String url,int topK) throws JSONException{
		String str = "";
		List<Image> lists=new ArrayList<Image>();
		BaseCrawler bc=new BaseCrawler();
		Document doc=bc.getPage(url);
		//JSONObject json=JSONObject.fromObject(doc.text());
		JSONObject json=new JSONObject(doc.text());
//		System.out.println(url);
//		System.out.println("imagecontent"+json.toString());
//		JSONObject json=JSONObject.fromObject(WebCrawler.getUrlDetail(url, false));
		JSONArray array= json.getJSONArray("data");
		for(int i=0;i<Math.min(array.length(), topK);i++){
			JSONObject jo=array.getJSONObject(i);
			
			if(jo.isNull("objURL"))continue;
			System.out.println(jo.get("objURL"));
			Image im=new Image((String)jo.get("objURL"), (String)jo.get("fromURL"));//
			str = (String)jo.get("objURL");
			lists.add(im);
		}
		return str;
		
	}
	public static List<Image> get(String url) throws JSONException{
		List<Image> lists=new ArrayList<Image>();
		BaseCrawler bc=new BaseCrawler();
		Document doc=bc.getPage(url);
		JSONObject json= new JSONObject(doc.text());
//		JSONObject json=JSONObject.fromObject(WebCrawler.getUrlDetail(url, false));
		JSONArray array=(JSONArray)json.get("data");;
		for(int i=0;i<array.length();i++){
			JSONObject jo=array.getJSONObject(i);
			
			if(jo.isNull("objURL"))continue;
			Image im=new Image((String)jo.get("objURL"), (String)jo.get("fromURL"));//
			lists.add(im);
		}
		return lists;
	}
	public static void main(String args[]) throws JSONException{
		String url="http://image.baidu.com/i?tn=baiduimagejson&ie=utf-8&oe=utf-8&pn=0&word=碳纤维性能";
		System.out.println(get(url,1));
	}
}
