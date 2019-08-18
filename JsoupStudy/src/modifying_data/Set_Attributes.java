package modifying_data;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Set_Attributes 
{

	public static void main(String[] args) 
	{
		String html = "<html><head><title> Sample Title </title></head>"
				+ "<body>"
				+ "<p> Sample Content </p>"
				+ "<div id='sampleDiv'><a id='googleA' href='www.google.com'>Google</a></div>"
				+ "<div class ='comments'><a href='www.sample1.com'>Sample1</a>"
				+ "<a href='www.sample2.com'>Sample2</a>"
				+ "<a href='www.sample3.com'>Sample3</a>"
				+ "<div></div>"
				+ "<div id='imageDiv' class='header'>"
				+ "<img name='Google' src ='google.png' />"
				+ "<img name='Yahoo' src='yahoo.jpg' />"
				+ "</div>"
				+ "</body></html>";
		
		Document doc = Jsoup.parse(html);
		
		//Example: set attribute
		Element link = doc.getElementById("googleA");
		System.out.println("Outer HTML before modification :" + link.outerHtml());
		// attr(attribute, value) method sets the element attribute to the corresponding value
		link.attr("href", "www.yahoo.com");
		System.out.println("Outer HTML after modification :" + link.outerHtml());
		System.out.println("---");
		
		//Example: add class
		// <doc>.addClass(class) method add the class under class attribute
		Element div = doc.getElementById("sampleDiv");
		System.out.println("Outer HTML before modification: " + div.outerHtml());
		link.addClass("Header");
		System.out.println("Outer HTML after modification: " + div.outerHtml());
		System.out.println("---");
		
		//Example: remove class
		Element div1 = doc.selectFirst("#imageDiv"); // #id is CSS selector for id
		// #imageDiv == doc.getElementById("imageDiv")
		// similarly, we can amend code block before into doc.selectFirst("#sampleDiv");
		
		/* Some common CSS selectors
		 * [attribute] select all elements with that attribute 
		 * [attribute = value] select all elements with target attribute = value
		 * [attribute ~= value] like [title~=flower] select all element with attribute "title" whose values CONTAIN the word "flower"
		 * [attribute |=value] like [sports|=stat] select all elements whose "sports" attribute has value starting with "stats"
		 * [attribute$=value] like a[href$=".pdf"] selects every <a> element whose href value ends in ".pdf"
		 * element, element like <doc>.select(p,div) selects all <div> and all <p> elements
		 */
		
		System.out.println("Outer HTML before removing class: " + div1.outerHtml());
		/// <doc>.removeClass(String className) removes a class name from this element's class attribute
		div1.removeClass("header");
		System.out.println("Outer HTML after removing class: " + div1.outerHtml());
		System.out.println("---");
		
		//Example: bulk update
		Elements links = doc.select("div.comments a"); // select all elements <a> inside div class "comments"
		System.out.println("Outer HTML before bulk update: " + links.outerHtml());
		links.attr("rel", "nofollow"); // if no such attribute exist, add to the element
		System.out.println("Outer HTML after bulk update: " + links.outerHtml());
	}

}
