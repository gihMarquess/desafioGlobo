//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-520 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.08.27 at 02:31:14 AM BRT 
//


package br.com.globo.entidades;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }
    public Rss.Channel createRssChannel() {
        return new Rss.Channel();
    }

    public Rss.Channel.Image createRssChannelImage() {
        return new Rss.Channel.Image();
    }
    public Rss.Channel.Item createRssChannelItem() {
        return new Rss.Channel.Item();
    }
    public Rss createRss() {
        return new Rss();
    }

}