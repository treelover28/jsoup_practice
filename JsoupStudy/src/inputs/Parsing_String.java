package inputs;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Parsing_String {

	public static void main(String[] args) {
		String html = "<html><head><title>Sample Title</title></head>"
				+ "<body><p>Sample Content</p><p> Content 2 </p></body></html>";
		// Set up document object
		/*
		 * Jsoup.parse(String html) is a static method that parses HTML content into a
		 * Document object The Document object can be used to traverse and get data of
		 * the html dom.
		 */
		Document doc = Jsoup.parse(html);
		System.out.println(doc.title()); // print out content in <title>content</title>

		Elements paragraphs = doc.getElementsByTag("p");
		for (Element p : paragraphs) // Element single not multiple Elements
		{
			System.out.println(p.text()); // convert element object to text
		}

	}

}
