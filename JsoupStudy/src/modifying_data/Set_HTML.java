package modifying_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Set_HTML 
{
	
	public static void main(String[] args) 
	{
		/*
		 * showcases use of methods to set, prepend, or append 
		 * html to a DOM element after parsing an HTML String 
		 * into a Document object
		 */
		
		String html = "<html><head><title>Sample title</title></head>"
				+ "<body>"
				+ "<div id='sampleDiv'><a id='googleA' href='www.google.com'>Google</a></div>"
				+ "</body></html>";
		
		Document doc = Jsoup.parse(html);
		
		Element div = doc.selectFirst("#sampleDiv");
		System.out.println("Outer HTML before replacing the inner HTML completely: " + div.outerHtml());
		// <element>.html(String newHTML) sets the element's inner HTML to newHTML. 
		// Clears the existing inner HTML first
		div.html("<p> this is sample content </p>"); 
		System.out.println("Outer HTML after replacing the inner HTML completely: " + div.outerHtml());
		System.out.println("---");
		// <element>.prepend(String htmlContents) add htmlContents before the existing inner HTML
		div.prepend("<p>Initial Text</p>");
		System.out.println("After prepend: " + div.outerHtml());
		System.out.println("---");
		// <element>.append(String htmlContents) add htmlContents after the existing inner HTML
		div.append("<p>Ending text</p>");
		System.out.println("After append: " + div.outerHtml());
		

	}

}
