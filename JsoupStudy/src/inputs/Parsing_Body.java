package inputs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parsing_Body {
	public static void main(String[] args) {
		/*
		 * parseBodyFragment(String html) method parses the input HTML into a new
		 * Document. We can use this document object to traverse the HTML body and get
		 * its details
		 */
		String html = "<div><p> body stuff </p>"
				+ "<p> body 2</";
		Document doc = Jsoup.parseBodyFragment(html);
		Element body = doc.body(); // same as doc.getElemtnsbyTag("body")
		Elements paragraphs = body.getElementsByTag("p");
		for (Element p : paragraphs)
		{
			System.out.println(p.text());
		}
		// This version is equivalent to one above 
		
//		String html2 = "<body><div><p> Body with tag</p><p> body 2 </p></div></body>";
//		Document d = Jsoup.parse(html2);
//		Elements b = d.getElementsByTag("p");
//		for (Element p : b)
//		{
//			System.out.println(p.text());
//		}

	}
}
