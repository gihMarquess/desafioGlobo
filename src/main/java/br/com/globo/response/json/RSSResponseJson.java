package br.com.globo.response.json;

import java.util.ArrayList;
import java.util.List;

public class RSSResponseJson {
	private List<Feed> feed = new ArrayList<>();
	
	public List<Feed> getFeed() {
		return feed;
	}

	public void setFeed(List<Feed> feed) {
		this.feed = feed;
	}

}
