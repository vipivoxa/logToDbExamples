package com.dummy;


import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/*
 * Log4j2 
 * 
 * log4j2.xml_orig for properties
 * 
 * DummyJava3ConnFak is creating connection 
 * DATASOURCE pool must be used instead
 */
public class DummyJava3 {

	
	// set log4j 2 configuration
	static {
	        	System.setProperty("log4j.configurationFile", "log4j2.xml_orig");
	    	}
	 
	static Logger logger = LogManager.getLogger(DummyJava3.class);
	
	public static void main(String[] args)
	{		
		System.out.println("start");
		
		logger.debug("log4j2 debug test");
		logger.info ("log4j2 info  test");
		
		System.out.println("end");
	}
	
	}


