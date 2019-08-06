package extracting_data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Using_DOM_Methods {

	public static void main(String[] args) 
	{
		String url = "https://www.basketball-reference.com/leagues/NBA_2019_ratings.html";
		try 
		{
			Document nbaRef = Jsoup.connect(url).get();			
			// get elements of attribute-key "data-stat" with value "team_name"
			Elements team = nbaRef.getElementsByAttributeValue("data-stat", "team_name");
			// get elements of attribute-key "data-stat" with value "off_rtg"
			Elements off = nbaRef.getElementsByAttributeValue("data-stat" , "off_rtg");
			Elements def = nbaRef.getElementsByAttributeValue("data-stat" , "def_rtg");
			// Elements is actually just a class implementing java.util.List interface
			// like ArrayList
			for (int i = 0; i < team.size(); i++) // uses for-loop to traverse List<Element>
			{
				System.out.println(team.get(i).text() + 
						"\t\t" + off.get(i).text() +
						"\t\t" + def.get(i).text());			
			}

		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
