package extracting_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Scanner;
import java.lang.IllegalArgumentException;


public class Working_With_URLs {

	public static void main(String[] args) 
	{
		// Methods to provide relative as well as 
		// absolute URLs present in the html page.
		
		Scanner keyboard = new Scanner(System.in);
		
		while (true)
		{
			
			try 
			{
				System.out.println("Input url: ");
				String html = keyboard.nextLine();
				if (html.equalsIgnoreCase("quit"))
				{
					System.exit(0);
				}
						
				Document doc = Jsoup.connect(html).get();
				System.out.println("Loading...");
				Element link = doc.selectFirst("a[href]");
				
				// link.attr("href") provides the value of href present in the anchor tag. 
				// it may be relative or absolute
				System.out.println("Relative link: " + link.attr("href"));
				// both of these methods provide the absolute URL after resolving against the document's base URI
				System.out.println("Absolute link: " + link.attr("abs:href"));
				System.out.println("Absolute link: " + link.absUrl("href"));
			}
			catch (IOException e)
			{
				System.out.println("Link is invalid. Please try again");
				continue;
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("Link is invalid. Please try again");
				continue;
			}
		}
		
		
	}

}
