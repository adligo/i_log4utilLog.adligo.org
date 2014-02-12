package org.adligo.i.util_log;

import org.adligo.i.log.shared.I_LogDelegate;
import org.adligo.i.log.shared.I_LogFactory;
import org.adligo.i.log.shared.ProxyLog;
import org.adligo.i.util.shared.I_Collection;
import org.adligo.i.util.shared.I_ImmutableMap;
import org.adligo.i.util.shared.I_Iterator;

/**
 * Note all i_log delegations to java.util.common have different level names for 
 * INFO and WARN(ING)
 * FINEST=TRACE
 * FINEER=DEBUG
 * FINE=INFO
 * INFO=WARN
 * WARNING=ERROR
 * SEVERE=FATAL
 * 
 * other than that just another delegation
 * 
 * @author scott
 *
 */
public class UtilLogFactory implements I_LogFactory {
	/**
	 * convention for logFactory=org.adligo.i.log.util.UtilLogFactory
	 * setting in adligo_log.properties
	 */
	public static final String LOG_FACTORY_NAME = UtilLogFactory.class.getName();
	
	public UtilLogFactory() {}
	
	@SuppressWarnings("unchecked")
	@Override
	public I_LogDelegate getLog(Class clazz) {
		if (clazz != null) {
			return getLog(clazz.getName());
		}
		return null;
	}

	@Override
	public I_LogDelegate getLog(String name) {
		return new UtilLogWrapper(name);
	}

	@Override
	public boolean isStaticInit() {
		return true;
	}

	@Override
	public void resetLogLevels() {
		throw new RuntimeException("method not yet implemented ");
	}

	@Override
	public void setInitalLogLevels(I_ImmutableMap props, I_LogFactory p) {
		//do nothing 
		//the inital log levels are set the way the standard 
		//java.util.log is set
	}

	@Override
	public void sendPreInitMessages(I_Collection iLogMessages) {
		throw new RuntimeException("method not yet implemented ");
	}

	public void setInitalLogLevels(I_Collection iProxyLogs) {
		I_Iterator it = iProxyLogs.getIterator();
		while (it.hasNext()) {
			ProxyLog proxy =  (ProxyLog) it.next();
			UtilLogWrapper log = new UtilLogWrapper(proxy.getLogName());
			proxy.addDelegate(log);
			proxy.setLevel(log.getLevel());
		}
	}

	@Override
	public String getName() {
		return UtilLogFactory.class.getName();
	}

	
	
}
