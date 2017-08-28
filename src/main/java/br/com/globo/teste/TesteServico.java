package br.com.globo.teste;

import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import br.com.globo.entidades.Rss;

public class TesteServico {

	public static void main(String[] args) {

		try {
			URL url = new URL("http://revistaautoesporte.globo.com/rss/ultimas/feed.xml");
			JAXBContext content = JAXBContext.newInstance("br.com.globo.entidades");
			Unmarshaller unmarshaller = content.createUnmarshaller();
			Rss rss = (Rss) unmarshaller.unmarshal(url.openStream());
			System.out.println(rss.getChannel().getItem().get(0).getDescription());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
