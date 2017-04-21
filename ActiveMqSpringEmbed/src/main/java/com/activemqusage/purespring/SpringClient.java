package com.activemqusage.purespring;

import org.apache.activemq.broker.BrokerService;
import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;


public class SpringClient {

	public static void main(String[] args) throws Exception {
		BrokerService broker = new BrokerService();
		broker.addConnector("tcp://localhost:61616");
		broker.setPersistent(false);
		broker.start();
		
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("src/main/resources/spring-client.xml");
		SpringPublisher publisher = (SpringPublisher)context.getBean("stockPublisher");
		publisher.start();
	}

}
