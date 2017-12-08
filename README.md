# logToDbExamples
Welcome to the logToDbExamples wiki!

logging to DB Oracle tables. 

* logback
* log4j
* log4j2

Prior to run place ojdbc jar into the project classpath. _(I've used ojdbc7.jar and placed it in /libs directory)_


### logback
Logback uses logback.xml configuration file. 
Change connectionSource url, usr and password accordingly to your env connection configuration. 

Logback requires that logging tables are created prior to run. Oracle sql script is found in /files/oracle.sql

Run DummyJava main method to test logback logging to DB.

### log4j 

log4j uses log4j.properties_orig configuration file. Change DB.URL, DB.user, DB.password. 

Log is written to msg_log table. So create it before a run. Script is below. 

`CREATE TABLE msg_log(`
   		 `user_id         VARCHAR2(255)`
   		`,obj			 VARCHAR2(2000)`
  		`,msg             VARCHAR2(2000)`
  		`,msg_type        VARCHAR2(10)`
  		`,msg_level       VARCHAR2(10)  	`
  		`,creation_date   DATE DEFAULT SYSDATE`
 		`,log_date        VARCHAR2(255)`
		`); `

Run DummyJava2 main method to test log4j2 logging to DB.

### log4j2

log4j2 uses log4j2.xml_orig configuration file. DummyJava3ConnFak class get the DB connection. 

Please change DummyJava3ConnFak final strings USR, PWD and DB_CONN_STR accordingly to your env connection configuration.

Log is written to msg_log table. So create it before a run. Script is below. 

`CREATE TABLE msg_log(`
   		 `user_id         VARCHAR2(255)`
   		`,obj			 VARCHAR2(2000)`
  		`,msg             VARCHAR2(2000)`
  		`,msg_type        VARCHAR2(10)`
  		`,msg_level       VARCHAR2(10)  	`
  		`,creation_date   DATE DEFAULT SYSDATE`
 		`,log_date        VARCHAR2(255)`
		`); `

Run DummyJava3 main method to test log4j2 logging to DB.


