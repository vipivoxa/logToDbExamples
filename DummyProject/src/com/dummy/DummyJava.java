package com.dummy;

//import ch.qos.logback.classic.LoggerContext;
//import ch.qos.logback.core.util.StatusPrinter;
/*
 * Logback   
 * 
 * logback.xml 
 * files/oracle.sql must be run prior execution
 * 
 * 
 * tables: logging_event, logging_event_property,logging_event_exception
 * 
 */
public class DummyJava {
	static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(DummyJava.class);
	
	public static void main (String[] params)
	{		
		//LoggerContext lc = (LoggerContext) org.slf4j.LoggerFactory.getILoggerFactory();
		//StatusPrinter.print(lc);		
		System.out.println("start");
		logger.info("logback test info");
		logger.debug("logback test debug");		
		System.out.println("end");
	}

}
