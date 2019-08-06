package inputs;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Loading_From_File {

	public static void main(String[] args) throws IOException, URISyntaxException 
	{
//		URL path = ClassLoader.getSystemResource("test.htm");
		File in = new File("test.htm");
		Document doc = Jsoup.parse(in, "UTF-8");
		System.out.println(doc.title());
		System.out.println(doc.body().text()); // .text() trim and normalize whitespace
		System.out.println(doc.body().wholeText()); // .wholeText() keeps it unnormalized
	}

}
