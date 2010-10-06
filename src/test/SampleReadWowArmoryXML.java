package test;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class SampleReadWowArmoryXML {

	public static void main ( String[] args ){
	
		String guildQuery = "http://www.wowarmory.com/guild-info.xml?r=Quel'Thalas&gn=Paragon";
		
		try{
			
			// or if you prefer DOM:
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			
			URL queryWow = new URL(guildQuery);
			HttpURLConnection conn = ( HttpURLConnection ) queryWow.openConnection();
			conn.setRequestProperty("user-agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.8.1.4) Gecko/20070515 Firefox/2.0.0.4"); 
			
			/*
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
			     System.out.println(line);
			}
			*/
			
			Document doc = db.parse(conn.getInputStream());
			//System.out.println(doc.getElementsByTagName());
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
