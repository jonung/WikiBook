package com.ebs.ckcest.imgService;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



/**
 * @ClassName: Crawler
 * @Description: a very simple crawler
 * @author VictoryLee
 * @date 2014-11-3 02:12:20
 * 
 */
public class BaseCrawler  {
	private static final long serialVersionUID = 1L;
	protected static final Logger logger = Logger
			.getLogger(BaseCrawler.class.getName());

	
	public Document getPage(String pageUrl) {
		int maxReconnect= 10;
		int count = 0;// reconnect times when exception happens. one question?
						// how about mulithreads
		boolean flag = true;
		Document doc=null;
		//PropertyConfigurator.configure("F:\\MyEclipse\\ImageSearcher\\src\\log4j.properties");
		while (flag && count < maxReconnect) {
			Connection con=null;
			try {
				
				con = Jsoup.connect(pageUrl)
				.userAgent("Mozilla/5.0 (Windows NT 5.1; rv:5.0) Gecko/20100101 Firefox/5.0")
				.header("accept-language", "en-US,en;q=0.8,zh-CN;q=0.6,zh;q=0.4")
				.header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
				.header("pragma", "no-cache")
				.header("cache-control", "no-cache")
//				.ignoreHttpErrors(true) 
				.timeout(3000);//exception only happens here, the next expression will not be executed
//				Map<String,String> cookie=con.execute().cookies();//cookie的引入导致不仅慢而且莫名的错误
//				doc=con.cookies(cookie).get();
				doc=con.get();
				logger.info("crawler"+pageUrl);
				flag = false;
			} 
			catch (MalformedURLException ep){
				logger.error("MalformedURL!!!");
				 }
			catch (HttpStatusException e) {
				logger.error(e);
				return doc;
		    }
			catch (IOException e) {
				count++;
				logger.error(e);
//				if(count>3){
//					VPNReconnect.disconnectVPN("VPN2");
//					VPNReconnect.connectVPN("VPN2", PropertyUtil.readPro("userkey"),
//							PropertyUtil.readPro("uservalue"));
//				}
				try {
					Random rd=new Random();
					int time=rd.nextInt(5000)+5000;
					Thread.sleep(time);
				} catch (InterruptedException e1) {
					logger.error(e.getMessage());
				}
				e.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
//			finally{
//				logger.error("no exception can be captured!");
//			}
		}//end of while loop
		return doc;
	}

	

}
