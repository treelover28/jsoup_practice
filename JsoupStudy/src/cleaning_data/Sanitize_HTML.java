package cleaning_data;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

public class Sanitize_HTML {

	public static void main(String[] args) 
	{
		String html ="<p><a href='http://example.com'"
				+ " onclick='checkData()'>Link</a></p>";
		
		System.out.println("Initial HTML: " + html);
		String safeHtml = Jsoup.clean(html, Whitelist.basic());
		// Whitelist defines what elements and attribute of HTML to be allowed.
		// all other inappropriate elements are removed through the cleaner
		// Whitelist.basic() is a whitelist that allows basic tags 
		// like a, b, blockquote, br, cite, code,... see list for more detail
		// .basic() only allows links pointing to http, https, mailto, ftp 
		// and have an enforced rel=nofollow attribute
		// rel=nofollow tells the engines and bots NOT to crawl to the specific link
		
		System.out.println("Clean HTML: " + safeHtml);
		// the original HTML forces to check data on click
		// the safeHtml has a rel=nofollow to prevent automatic redirecting to dangerous sites
		// all inappropriate tags are removed as well.
	}

}
