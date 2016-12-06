package com.zeyu.iofilter;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.core.write.WriteRequest;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component("myLoggingFilter")
public class MyLoggingFilter extends IoFilterAdapter {

	/** The myLoggingFilter name */
    private final String name;

    /** The myLoggingFilter */
    private final Logger myLoggingFilter;

    /** The log level for the exceptionCaught event. Default to WARN. */
    private LogLevel exceptionCaughtLevel = LogLevel.WARN;

    /** The log level for the messageSent event. Default to INFO. */
    private LogLevel messageSentLevel = LogLevel.INFO;

    /** The log level for the messageReceived event. Default to INFO. */
    private LogLevel messageReceivedLevel = LogLevel.INFO;

    /** The log level for the sessionCreated event. Default to INFO. */
    private LogLevel sessionCreatedLevel = LogLevel.INFO;

    /** The log level for the sessionOpened event. Default to INFO. */
    private LogLevel sessionOpenedLevel = LogLevel.INFO;

    /** The log level for the sessionIdle event. Default to INFO. */
    private LogLevel sessionIdleLevel = LogLevel.INFO;

    /** The log level for the sessionClosed event. Default to INFO. */
    private LogLevel sessionClosedLevel = LogLevel.INFO;

    /**
     * Default Constructor.
     */
    public MyLoggingFilter() {
        this(MyLoggingFilter.class.getName());
    }

    /**
     * Create a new NoopFilter using a class name
     * 
     * @param clazz the cass which name will be used to create the myLoggingFilter
     */
    public MyLoggingFilter(Class<?> clazz) {
        this(clazz.getName());
    }

    /**
     * Create a new NoopFilter using a name
     * 
     * @param name the name used to create the myLoggingFilter. If null, will default to "NoopFilter"
     */
    public MyLoggingFilter(String name) {
        if (name == null) {
            this.name = LoggingFilter.class.getName();
        } else {
            this.name = name;
        }

        myLoggingFilter = LoggerFactory.getLogger(this.name);
    }

    /**
     * @return The myLoggingFilter's name
     */
    public String getName() {
        return name;
    }

    /**
     * Log if the myLoggingFilter and the current event log level are compatible. We log
     * a message and an exception.
     * 
     * @param eventLevel the event log level as requested by the user
     * @param message the message to log
     * @param cause the exception cause to log
     */
    private void log(LogLevel eventLevel, String message, Throwable cause) {
        switch (eventLevel) {
        case TRACE:
            myLoggingFilter.trace(message, cause);
            return;
        case DEBUG:
            myLoggingFilter.debug(message, cause);
            return;
        case INFO:
            myLoggingFilter.info(message, cause);
            return;
        case WARN:
            myLoggingFilter.warn(message, cause);
            return;
        case ERROR:
            myLoggingFilter.error(message, cause);
            return;
        default:
            return;
        }
    }

    /**
     * Log if the myLoggingFilter and the current event log level are compatible. We log
     * a formated message and its parameters. 
     * 
     * @param eventLevel the event log level as requested by the user
     * @param message the formated message to log
     * @param param the parameter injected into the message
     */
    private void log(LogLevel eventLevel, String message, Object param) {
        switch (eventLevel) {
        case TRACE:
            myLoggingFilter.trace(message, param);
            return;
        case DEBUG:
            myLoggingFilter.debug(message, param);
            return;
        case INFO:
            myLoggingFilter.info(message, param);
            return;
        case WARN:
            myLoggingFilter.warn(message, param);
            return;
        case ERROR:
            myLoggingFilter.error(message, param);
            return;
        default:
            return;
        }
    }

    /**
     * Log if the myLoggingFilter and the current event log level are compatible. We log
     * a simple message. 
     * 
     * @param eventLevel the event log level as requested by the user
     * @param message the message to log
     */
    private void log(LogLevel eventLevel, String message) {
        switch (eventLevel) {
        case TRACE:
            myLoggingFilter.trace(message);
            return;
        case DEBUG:
            myLoggingFilter.debug(message);
            return;
        case INFO:
            myLoggingFilter.info(message);
            return;
        case WARN:
            myLoggingFilter.warn(message);
            return;
        case ERROR:
            myLoggingFilter.error(message);
            return;
        default:
            return;
        }
    }
    
    private void log(LogLevel eventLevel, String message,IoSession session) {
        switch (eventLevel) {
        case TRACE:
            myLoggingFilter.trace("SESSIONID={} {}",session.getId(),message);
            return;
        case DEBUG:
            myLoggingFilter.debug("SESSIONID={} {}",session.getId(),message);
            return;
        case INFO:
            myLoggingFilter.info("SESSIONID={} {}",session.getId(),message);
            return;
        case WARN:
            myLoggingFilter.warn("SESSIONID={} {}",session.getId(),message);
            return;
        case ERROR:
            myLoggingFilter.error("SESSIONID={} {}",session.getId(),message);
            return;
        default:
            return;
        }
    }

    @Override
    public void exceptionCaught(NextFilter nextFilter, IoSession session, Throwable cause) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("SESSIONID=");
        sb.append(session.getId());
        sb.append(" EXCEPTION :");
        
    	log(exceptionCaughtLevel, sb.toString(), cause);
        nextFilter.exceptionCaught(session, cause);
    }

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
    	StringBuilder sb = new StringBuilder();
        sb.append("SESSIONID=");
        sb.append(session.getId());
        sb.append(" RECEIVED : {}");
        
    	log(messageReceivedLevel, sb.toString(), message);
    	//System.out.println("message :   =====" + message.toString());
    	IoBuffer ibBuffer = (IoBuffer)message;
    	byte []bts=ibBuffer.array();
    	
    	sb = new StringBuilder();
		for(int i=0;i<ibBuffer.limit();i++)
		{
			if(i%16==0 && sb.length()>0)
			{
				log(messageReceivedLevel,sb.toString().toUpperCase());
				sb=new StringBuilder();
			}
			
			sb.append(Integer.toHexString((bts[i]&0xF0)>>4));
			sb.append(Integer.toHexString(bts[i]&0x0F));
			
			sb.append(" ");
			
		}
		if(sb.length()>0)
			log(messageReceivedLevel,sb.toString().toUpperCase());
		
		
        nextFilter.messageReceived(session, message);
    }

    @Override
    public void messageSent(NextFilter nextFilter, IoSession session, WriteRequest writeRequest) throws Exception {
        nextFilter.messageSent(session, writeRequest);
        
    	StringBuilder sb = new StringBuilder();
        sb.append("SESSIONID=");
        sb.append(session.getId());
        sb.append(" SENT : {}");
    	
    	log(messageSentLevel, sb.toString(), writeRequest.getMessage());
    	IoBuffer ibBuffer = (IoBuffer)writeRequest.getMessage();
    	byte []bts=ibBuffer.array();
    	
    	sb = new StringBuilder();
		for(int i=0;i<ibBuffer.limit();i++)
		{
			if(i%16==0 && sb.length()>0)
			{
				log(messageReceivedLevel,sb.toString());
				sb=new StringBuilder();
			}
			
			sb.append(Integer.toHexString((bts[i]&0xF0)>>4));
			sb.append(Integer.toHexString(bts[i]&0x0F));
			
			sb.append(" ");
			
		}
		if(sb.length()>0)
			log(messageReceivedLevel,sb.toString());
		

    }

    @Override
    public void sessionCreated(NextFilter nextFilter, IoSession session) throws Exception {
    	StringBuilder sb = new StringBuilder();
        sb.append("SESSIONID=");
        sb.append(session.getId());
        sb.append(" addr=");
        sb.append(session.getRemoteAddress().toString());
        
    	log(sessionCreatedLevel, sb.toString());
        nextFilter.sessionCreated(session);
    }

    @Override
    public void sessionOpened(NextFilter nextFilter, IoSession session) throws Exception {
        log(sessionOpenedLevel, "OPENED",session);
        nextFilter.sessionOpened(session);
    }

    @Override
    public void sessionIdle(NextFilter nextFilter, IoSession session, IdleStatus status) throws Exception {
        log(sessionIdleLevel, "IDLE",session);
        nextFilter.sessionIdle(session, status);
    }

    @Override
    public void sessionClosed(NextFilter nextFilter, IoSession session) throws Exception {
        log(sessionClosedLevel, "CLOSED",session);
        nextFilter.sessionClosed(session);
    }

    /**
     * Set the LogLevel for the ExceptionCaught event.
     * 
     * @param level The LogLevel to set
     */
    public void setExceptionCaughtLogLevel(LogLevel level) {
        exceptionCaughtLevel = level;
    }

    /**
     * Get the LogLevel for the ExceptionCaught event.
     * 
     * @return The LogLevel for the ExceptionCaught eventType
     */
    public LogLevel getExceptionCaughtLogLevel() {
        return exceptionCaughtLevel;
    }

    /**
     * Set the LogLevel for the MessageReceived event.
     * 
     * @param level The LogLevel to set
     */
    public void setMessageReceivedLogLevel(LogLevel level) {
        messageReceivedLevel = level;
    }

    /**
     * Get the LogLevel for the MessageReceived event.
     * 
     * @return The LogLevel for the MessageReceived eventType
     */
    public LogLevel getMessageReceivedLogLevel() {
        return messageReceivedLevel;
    }

    /**
     * Set the LogLevel for the MessageSent event.
     * 
     * @param level The LogLevel to set
     */
    public void setMessageSentLogLevel(LogLevel level) {
        messageSentLevel = level;
    }

    /**
     * Get the LogLevel for the MessageSent event.
     * 
     * @return The LogLevel for the MessageSent eventType
     */
    public LogLevel getMessageSentLogLevel() {
        return messageSentLevel;
    }

    /**
     * Set the LogLevel for the SessionCreated event.
     * 
     * @param level The LogLevel to set
     */
    public void setSessionCreatedLogLevel(LogLevel level) {
        sessionCreatedLevel = level;
    }

    /**
     * Get the LogLevel for the SessionCreated event.
     * 
     * @return The LogLevel for the SessionCreated eventType
     */
    public LogLevel getSessionCreatedLogLevel() {
        return sessionCreatedLevel;
    }

    /**
     * Set the LogLevel for the SessionOpened event.
     * 
     * @param level The LogLevel to set
     */
    public void setSessionOpenedLogLevel(LogLevel level) {
        sessionOpenedLevel = level;
    }

    /**
     * Get the LogLevel for the SessionOpened event.
     * 
     * @return The LogLevel for the SessionOpened eventType
     */
    public LogLevel getSessionOpenedLogLevel() {
        return sessionOpenedLevel;
    }

    /**
     * Set the LogLevel for the SessionIdle event.
     * 
     * @param level The LogLevel to set
     */
    public void setSessionIdleLogLevel(LogLevel level) {
        sessionIdleLevel = level;
    }

    /**
     * Get the LogLevel for the SessionIdle event.
     * 
     * @return The LogLevel for the SessionIdle eventType
     */
    public LogLevel getSessionIdleLogLevel() {
        return sessionIdleLevel;
    }

    /**
     * Set the LogLevel for the SessionClosed event.
     * 
     * @param level The LogLevel to set
     */
    public void setSessionClosedLogLevel(LogLevel level) {
        sessionClosedLevel = level;
    }

    /**
     * Get the LogLevel for the SessionClosed event.
     * 
     * @return The LogLevel for the SessionClosed eventType
     */
    public LogLevel getSessionClosedLogLevel() {
        return sessionClosedLevel;
    }
}
