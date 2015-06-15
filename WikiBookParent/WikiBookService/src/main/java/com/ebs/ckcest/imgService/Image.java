package com.ebs.ckcest.imgService;

 /**
 * @ClassName: Image
 * @Description: 
 * @author VictoryLee
 * @date 2014-11-9 下午11:59:49
 * 
 */
public class Image {
	
	private String url;
	private String page;
	
	/**
	* <p>Title: </p>
	* <p>Description: </p>
	* @param url
	* @param page
	*/
	public Image(String url, String page) {
		this.url = url;
		this.page = page;
	}
	/**
	 * @return url
	 */
	
	public String getUrl() {
		return url;
	}
	/**
	 * @param url  url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return page
	 */
	
	public String getPage() {
		return page;
	}
	/**
	 * @param page  page
	 */
	public void setPage(String page) {
		this.page = page;
	}
	/* (non Javadoc)
	* <p>Title: toString</p>
	* <p>Description: </p>
	* @return
	* @see java.lang.Object#toString()
	*/
	@Override
	public String toString() {
		return " { url=" + url + ",page=" + page + "}";
	}
	
}
