package extracting_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.LinkedList;
import java.util.List;

public class Extracting_Attributes {

	/*
	 * The following example show-cases using a method to get attribute of a 
	 * DOM element after parsing an HTML String into a Document object
	 */
	public static void main(String[] args) 
	{
		// Element object represents a DOM element 
		// this class provides lots of methods to get 
		// the attribute of a DOM element.
		String html = "<html><head><title> NBA Times: Issue 2 </title></head>"
				+ "<body>"
				+ "<p> EJ Johnson wants to privately lecture Bronny James on LGBT lives </p>"
				+ "<p> Dwight Howard requests trade into Uranus </p>"
				+ "<p> Zion broke Pelicans' gym's door after gaining 700 lbs from Gumbo </p>"
				+ "<div id = 'sampleDiv' > <a href = 'www.nba.com/ej-johnson-bronny-pedo.htm'>NBA</a>"
				+ "<h3><a> sample h3 followed by a</a></h3>"
				+ "</div>"
				+ "</body>"
				+ "</html>";
		Document doc = Jsoup.parse(html);
		
		// a with href 
		Element link = doc.selectFirst("a[href]");
		System.out.println("Href: " + link.attr("href"));
		
//		Element link = doc.selectFirst("a");
//		System.out.println("Href: " + link.attr("href"));
		
		// eachText() when used with .select(String cssQuery)
		Element body = doc.body();
		List<String> texts = body.select("p").eachText(); // eachText returns a list of each matched element's text content
		for (String s : texts)
		{
			System.out.println(s);
		}
		
		

	}

}
