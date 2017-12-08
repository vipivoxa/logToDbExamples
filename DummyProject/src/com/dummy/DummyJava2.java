package com.dummy;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
/*
 * Log4j  1st version 
 * 
 * log4j2.properties.old is loaded dynamically
 * 
 */
public class DummyJava2 {
	static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DummyJava2.class.getName());
	static final String PROPFILE="/log4j.properties_orig";
	
	private void updateLog4jConfiguration(String logFile) { 
	    Properties props = new Properties(); 
	    try { 
	        InputStream configStream = getClass().getResourceAsStream( PROPFILE); 
	        props.load(configStream); 
	        configStream.close(); 
	    } catch (IOException e) { 
	        System.out.println("Error: Cannot laod configuration file "); 
	    } 
	    LogManager.resetConfiguration(); 
	    PropertyConfigurator.configure(props); 
	   // props.setProperty("log4j.appender.FILE.file", logFile); 
	   // PropertyConfigurator.configure(props); 
	 }
	
	public static void main(String[] p)
	{
		System.out.println("start log4j 1");
		DummyJava2 dj = new DummyJava2();
		dj.updateLog4jConfiguration("dumy");
		logger.debug("log4j (1st) debug level msg");
		System.out.println("end log4j 1 ");
	}
}
