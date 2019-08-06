package inputs;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Loading_URL 
{
	public static void main(String[] args) throws IOException
	{
		String url = "https://www.basketball-reference.com/leagues/NBA_2019_ratings.html";
		// Jsoup.connect(String uri) establishes a connect (via Connection object)
		// .get() parses it into a Document object for traversal 

		Document doc = Jsoup.connect(url).get();
		Elements para = doc.getElementsByTag("tr");
		
		for (Element p : para)
		{
			System.out.println(p);
		}
	}

}
