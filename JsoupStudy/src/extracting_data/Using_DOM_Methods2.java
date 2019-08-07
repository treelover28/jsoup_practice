package extracting_data;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
public class Using_DOM_Methods2 {

	public static void main(String[] args) 
	{
		String url = "https://www.teamrankings.com/nba/stat/possessions-per-game";
		try 
		{
			Document nba = Jsoup.connect(url).get();			
			Elements team = nba.getElementsByAttribute("data-sort");
			ArrayList<String> teamName = new ArrayList<>();
			for (int i = 1; i < team.size(); i++)
			{
				if ( i > 0 && (i - 1) % 8 == 0) teamName.add(team.get(i).text());
				if ( i > 1 && (i - 2) % 8 == 0) teamName.add(team.get(i).text());
			}
			for (String t : teamName )
			{
				System.out.println(t);
			}

		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
		

	}

}
