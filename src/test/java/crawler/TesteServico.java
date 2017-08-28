package crawler;

import org.junit.Assert;
import org.junit.Test;

import br.com.globo.controller.CrawlerController;

public class TesteServico {

	@Test
	public void test() {
		
		String result = CrawlerController.crawlerJson();
		Assert.assertNotNull(result);
		Assert.assertTrue(!result.isEmpty());
	}

}
