package com.ebs.WikiBookDao;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import com.ebs.ckcest.common.DaoProperties;

 
/**
 * @ClassName: FocusLuceneSearcher
 * @Description: 
 * @author GongJun
 * @date Jun 11, 2015 9:54:20 AM
 * @version V1.0  
 */

public class FocusLuceneSearcher {
	
	private static Logger log = Logger.getLogger(FocusLuceneSearcher.class);
	
	private static Version LUCENE_VERSION = Version.LUCENE_36;
	private static String filePath = DaoProperties.getDaoProperties().getProperty("Index_Lucene_Topic2Focus");
	private static IndexReader indexReader = null;
	private static IndexSearcher indexSearcher = null;
	
	static {
		try {
			indexReader = IndexReader.open(FSDirectory.open(new File(filePath)));
			indexSearcher = new IndexSearcher(indexReader);
			
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	/**
	 * @Function: getFocusByTopic
	 * @Description: 给定topic，得到所有的focus
	 * @param @param topic
	 * @param @return
	 * @param @throws IOException    
	 * @return String    json字符串 
	 * @date Jun 11, 2015 10:15:12 AM
	 * @throws
	 */
		
	public static String getFocusByTopic(String topic) throws IOException{
		
		String focusStr = "";
		
		Term term = new Term("Topic",topic);
		Query query = new TermQuery(term);
		TopDocs topDocs = indexSearcher.search(query, 1000);
		ScoreDoc[] hits = topDocs.scoreDocs; 
		
		if(hits.length > 0){
			Document doc = indexSearcher.doc(hits[0].doc);
			focusStr = doc.get("Focus");
			
		}
		
		log.debug("Focus json str: " + focusStr);
		return focusStr;
	}
	
	
}
