package com.ebs.ckcest.common;

import java.io.IOException;
import java.util.Properties;

import org.springframework.core.io.support.PropertiesLoaderUtils;

 
/**
 * @ClassName: DaoProperties
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 10:01:00 AM
 * @version V1.0  
 */

public class DaoProperties {
	private static Properties props = null;
	
	public static Properties getDaoProperties(){
		if(props == null){
			try {
				props = PropertiesLoaderUtils.loadAllProperties("dao.properties");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
			
		return props;
	}
}
