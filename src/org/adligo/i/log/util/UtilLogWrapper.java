package org.adligo.i.log.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.adligo.i.log.client.I_LogDelegate;
import org.adligo.i.log.client.SimpleLog;


public class UtilLogWrapper implements I_LogDelegate  {
	private boolean enabled = true;
	private Logger logger;
	
	public UtilLogWrapper(String logName) {
		logger = Logger.getLogger(logName);
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	@Override
	public boolean isErrorEnabled() {
		if (enabled) {
			return logger.isLoggable(Level.WARNING);
		}
		return false;
	}

	@Override
	public boolean isFatalEnabled() {
		if (enabled) {
			return logger.isLoggable(Level.SEVERE);
		}
		return false;
	}

	@Override
	public boolean isWarnEnabled() {
		if (enabled) {
			return logger.isLoggable(Level.INFO);
		}
		return false;
	}

    /**
     * @Override
     */
    public boolean isDebugEnabled() {
    	if (enabled) {
    		return logger.isLoggable(Level.FINER);
    	}
    	return false;
    }


    /**
     * @Override
     */
    public boolean isInfoEnabled() {
    	if (enabled) {
    		return logger.isLoggable(Level.FINE);
    	}
    	return false;
    }


    /**
     * @Override
     */
    public boolean isTraceEnabled() {
    	if (enabled) {
    		return logger.isLoggable(Level.FINEST);
    	}
    	return false;
    }
    
	@Override
	public void setEnabled(boolean p) {
		enabled = p;
	}

	@Override
	public void log(short type, Object message, Throwable t) {
		if (enabled) {
			switch (type) {
				case SimpleLog.LOG_LEVEL_TRACE:
						if (message != null) {
							if (t != null) {
								trace(message, t);
							} else {
								trace(message);
							}
						}
					break;
				case SimpleLog.LOG_LEVEL_DEBUG:
					if (message != null) {
						if (t != null) {
							debug(message, t);
						} else {
							debug(message);
						}
					}
					break;
				case SimpleLog.LOG_LEVEL_INFO:
					if (message != null) {
						if (t != null) {
							info(message, t);
						} else {
							info(message);
						}
					}
					break;
				case SimpleLog.LOG_LEVEL_WARN:
					if (message != null) {
						if (t != null) {
							warn(message, t);
						} else {
							warn(message);
						}
					}
					break;
				case SimpleLog.LOG_LEVEL_ERROR:
					if (message != null) {
						if (t != null) {
							error(message, t);
						} else {
							error(message);
						}
					}
					break;
				case SimpleLog.LOG_LEVEL_FATAL:
					if (message != null) {
						if (t != null) {
							fatal(message, t);
						} else {
							fatal(message);
						}
					}
					break;
			}
		}
	}

	/**
	 * note a class cast exception here
	 * is the problem of the log user (programmer)
	 * and not of i_log4util 
	 * 
	 */
	@Override
	public void debug(Object message) {
		logger.finer((String) message);
	}

	/**
	 * note a class cast exception here
	 * is the problem of the log user (programmer)
	 * and not of i_log4util 
	 * 
	 */
	@Override
	public void debug(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.finer(sb.toString());
	}

	/**
	 * note a class cast exception here
	 * is the problem of the log user (programmer)
	 * and not of i_log4util 
	 */
	@Override
	public void error(Object message) {
		logger.warning((String) message);
	}

	/**
	 * note a class cast exception here
	 * is the problem of the log user (programmer)
	 * and not of i_log4util 
	 */
	@Override
	public void error(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.warning(sb.toString());
	}

	@Override
	public void fatal(Object message) {
		logger.severe((String) message);
	}

	@Override
	public void fatal(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.severe(sb.toString());
	}

	@Override
	public void info(Object message) {
		logger.fine((String) message);
	}

	@Override
	public void info(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.fine(sb.toString());
	}

	@Override
	public void trace(Object message) {
		logger.finest((String) message);
	}

	@Override
	public void trace(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.finest((String) sb.toString());
	}

	@Override
	public void warn(Object message) {
		logger.info((String) message);
	}

	@Override
	public void warn(Object message, Throwable t) {
		StringBuffer sb = new StringBuffer();
		SimpleLog.createLogMessage(message, t, sb);
		logger.info((String) sb.toString());		
	}
	
}
