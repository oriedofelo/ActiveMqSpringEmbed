package com.activemqusage.purespring;

import org.apache.xbean.spring.context.FileSystemXmlApplicationContext;

public class ActiveMqPureSpring {
	public static void main(String[] args) throws Exception {
    	
    	String config = "/src/main/resources/pure-spring.xml";
    	System.out.println("Starting broker with the following configuration: " + config);
		System.setProperty("activemq.base", System.getProperty("user.dir"));
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(config);
		
		Publisher publisher = new Publisher();
		for (int i = 0; i < 100; i++) {
			publisher.sendMessage(new String[]{"JAVA", "IONA"});
		}
		
	}
}
