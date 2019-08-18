package modifying_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Set_Text_Contents {

	public static void main(String[] args) 
	{
		/*
		 * Showcases use of method to set, prepend, append text
		 * to a DOM element asfter parsing an HTML String into 
		 * a Document object
		 */
		String html = "<html><head><title>Sample title</title></head>"
				+ "<body>"
				+ "<div id='sampleDiv'><a id='googleA' href='www.google.com'>Google</a></div>"
				+ "</body></html>";
		
		Document doc = Jsoup.parse(html);
		Element div = doc.selectFirst("#sampleDiv");
		System.out.println("Outer Html before modification:\n" + div.outerHtml());
		div.text("This is sample content.\n");
		// <element>.text(String text) sets the text of this element. Clears any existing text
		div.prepend("Initial text.\n");
		div.append("Final text");
		System.out.println("Outer Html after modification:\n" + div.outerHtml());
	}

}
