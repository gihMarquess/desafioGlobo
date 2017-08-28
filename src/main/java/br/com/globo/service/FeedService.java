package br.com.globo.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.globo.controller.CrawlerController;

@RestController
public class FeedService {
	
	@RequestMapping("/crawler")
	public String globoAutoSportFeed() {
		
		return CrawlerController.crawlerJson();
	}
}
