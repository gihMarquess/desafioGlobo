package br.com.globo.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import com.google.gson.Gson;

import br.com.globo.entidades.Description;
import br.com.globo.entidades.Rss;
import br.com.globo.response.json.Feed;
import br.com.globo.response.json.RSSResponseJson;

public class CrawlerController {
	
	
	public static List<Description> contentFilter(Document document){
		List<Description> descriptionList = new ArrayList<Description>();
		document.getAllElements().forEach(element->{
			Description descriptionElement = new Description(); 
			switch(element.tagName()){
				case "img":
					descriptionElement.setType("image");
					descriptionElement.setContent(element.attr("src"));
					break;
				case "p":
					if(!element.text().trim().replaceAll("(^\\h*)|(\\h*$)","").isEmpty()){
						descriptionElement.setType("text");
						descriptionElement.setContent(element.text());
					}else{
						descriptionElement = null;
					}
					break;
				case "ul":
					List<String> links = new ArrayList<String>();
					for(Element elementUl : element.getAllElements()){
						if(elementUl.tagName().equalsIgnoreCase("a"))
							links.add(elementUl.attr("href"));
					}
					
					if(!links.isEmpty()){
						descriptionElement.setType("links");
						descriptionElement.setContent(links);
					}else{
						descriptionElement = null;
					}
					break;
				default:
					descriptionElement = null;
			}
			
			if(descriptionElement != null){
				descriptionList.add(descriptionElement);
			}
		});
		
		return descriptionList;
	}
	
	
	
	public static Rss getInternetGloboRss() throws JAXBException, IOException{
		URL url = new URL("http://revistaautoesporte.globo.com/rss/ultimas/feed.xml");
		JAXBContext content = JAXBContext.newInstance("br.com.globo.entidades");
		Unmarshaller unmarshaller = content.createUnmarshaller();
		return (Rss) unmarshaller.unmarshal(url.openStream());
	}
	
	
	public static String crawlerJson() {
	
		String json = null;
		
	try {
		RSSResponseJson response = new RSSResponseJson();
		CrawlerController.getInternetGloboRss().getChannel().getItem().forEach(
			item->{
				Feed feed = new Feed();
				CrawlerController.contentFilter(Jsoup.parse(item.getDescription())).forEach(description->{
					feed.getItem().getDescription().add(new Description(description.getType(), description.getContent()));
					feed.getItem().setLink(item.getLink());
					feed.getItem().setTitle(item.getTitle());
				});
				response.getFeed().add(feed);
			}
		);
		
			Gson gson = new Gson();
			json = gson.toJson(response);
	} catch (JAXBException | IOException e) {
		e.printStackTrace();
	}
	
		return json;
 }
	
	
}
