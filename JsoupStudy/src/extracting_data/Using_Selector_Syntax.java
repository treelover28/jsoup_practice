package extracting_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Using_Selector_Syntax {

	public static void main(String[] args) {
		String html = "<html><head><title> NBA Times </title></head>"
				+ "<body>"
				+ "<p> Lebron hospitalized after sharing Magic Johnson's bathtowel </p>"
				+ "<div id = 'sampleDiv'><a href = 'www.nba.com'>NBA Website</a>"
				+ "<h3><a>Sample h3 and then a </a><h3>"
				+ "<h3><b>Sample h3 and then a </b><h3>"
				+ "<h3><a> Second sample h3 and then a</a></h3>"
				+ "</div>"
				+ "<div id= 'ImageDiv' class = 'header'><img name = 'nba' src ='nba.png' />"
				+ "</div>"
				+ "</body></html>";
		Document doc = Jsoup.parse(html);
		
		// a with href
		/* <Document Object>.select(String cssQuery) parses 
		 * the given CSS selector expression to select 
		 * a HTML DOM element
		 * 
		 * Method is also overridden for Elements and Element class
		 */
		Elements links = doc.select("a[href]"); // 'a' tags with attribute 'href'
		
		for (Element l : links)
		{
			System.out.println("Href: " + l.attr("href")); // attr(String attributeKey) gets an attribute value by its key
			System.out.println("Text: " + l.text());
		}
		// find elements ending in tag 'p'
		Elements p = doc.select("p");
		for (Element e : p)
		{
			System.out.println(p.text());
		}
		
		
		// img with src ending in .png
		Elements pngs = doc.select("img[src$=.png]"); // img tag with src attribute's value ending in .png
		for (Element png : pngs)
		{
			System.out.println("Img name: " + png.attr("name"));
		}
		
		// 'div' tag with id = 'SampleDiv'
		Element sampleDiv = doc.selectFirst("div");
		System.out.println("First header: " + sampleDiv.id());
		
		// 'div' tag  with class = header
		Element headerDiv = doc.select("div.header").first(); // .first() return the first matched element, null if none.
		System.out.println("Id: " + headerDiv.id()); // return the id attribute of this element;
		
		// direct a after h3
		Elements sampleLinks = doc.select("h3 > a"); // select only those that opens with 'h3' tag followed by 'a' tag
		// notice how it skipped the 'h3' tag followed by 'b' tag
		
		for (Element sl: sampleLinks)
		{
			System.out.println("Text: " + sl.text());
		}
		
	}

}
