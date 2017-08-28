package br.com.globo.response.json;

import java.util.ArrayList;
import java.util.List;

import br.com.globo.entidades.Description;

public class Item {
	
	private String title;
	private String link;
	private List<Description> description;
	
	public Item(){
		this.description = new ArrayList<Description>();
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}

	public List<Description> getDescription() {
		return description;
	}

	public void setDescription(List<Description> description) {
		this.description = description;
	}
}
