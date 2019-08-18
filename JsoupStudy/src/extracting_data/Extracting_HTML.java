package extracting_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;

public class Extracting_HTML {

	public static void main(String[] args) 
	{
		/*
		 * Element object represents a DOM element and
		 * provide multiple method to get the HTML of a DOM element
		 * 
		 */
		
		String html = "<html><head><title>Lamelo Ball gets drafted 1st to Lakers</title></head>"
				+ "<body>"
				+ "<p> Lamelo, who has proven his skill averaging 30/12/10 for the Austrialian Hawk"
				+ "has been selected 1st overall </p>"
				+ "<div id= 'sampleDiv'><a href= 'www.google.com'>Google</a>"
				+ "<h3><a>Liangelo makes another big steal, gets jailed in North Korea</a></h3>"
				+ "</div>"
				+ "</body></html>";
		Document doc = Jsoup.parse(html);
		
		// a with href
		Element link = doc.selectFirst("a");
		
		// outerHtml() returns the complete HTML of the matched element
		System.out.println("Outer HTML: " + link.outerHtml());
		
		// html() returns the element's inner html, aka. the text content
		System.out.println("Inner HTML: " + link.html());

	}

}
