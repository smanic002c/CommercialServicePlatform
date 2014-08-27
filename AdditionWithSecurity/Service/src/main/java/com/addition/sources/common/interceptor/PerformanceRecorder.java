package com.addition.sources.common.interceptor;

import org.apache.camel.Exchange;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.MDC;

import com.addition.sources.common.constants.Constants;
import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class PerformanceRecorder {

	public boolean performanceflag;

	public boolean isPerformanceflag() {
		return performanceflag;
	}

	public void setPerformanceflag(boolean performanceflag) {
		this.performanceflag = performanceflag;
	}

	private static final Log LOG = LogFactory.getLog(PerformanceRecorder.class);

	public void startMonitor(String operationname, Exchange exchange) {
		Monitor monitor = null;
		monitor = MonitorFactory.startPrimary(operationname);
		exchange.setProperty("monitor", monitor);
	}

	public void stopMonitor(Exchange exchange) {
		String userId = (String) exchange.getProperty(Constants.WS_USER_ID);
		String sourceSerId = (String) exchange.getProperty(Constants.SOURCE_SERVER_ID);
		String trackingId = (String) exchange.getProperty(Constants.TRACKING_ID);
		String serviceVersion = (String) exchange.getProperty(Constants.SERVICE_VERSION);

		if (userId != null) {
			MDC.put(Constants.WS_USER_ID, exchange.getProperty(Constants.WS_USER_ID));
		}
		if (sourceSerId != null) {
			MDC.put(Constants.SOURCE_SERVER_ID, exchange.getProperty(Constants.SOURCE_SERVER_ID));
		}
		if (trackingId != null) {
			MDC.put(Constants.TRACKING_ID, exchange.getProperty(Constants.TRACKING_ID));
		}
		if (serviceVersion != null) {
			MDC.put(Constants.SERVICE_VERSION, exchange.getProperty(Constants.SERVICE_VERSION));
		}

		Monitor monitor = (Monitor) exchange.getProperty("monitor");

		if (monitor != null) {
			monitor.stop();
			LOG.info("(Label=" + monitor.getLabel() 
					+ ",LastValue=" + monitor.getLastValue() 
					+ ",Hits=" + monitor.getHits() 
					+ ",Avg=" + monitor.getAvg()
					+ ",Total=" + monitor.getTotal() 
					+ ",Min=" + monitor.getMin() 
					+ ",Max=" + monitor.getMax() 
					+ ",Active=" + monitor.getActive()
					+ ",Avg_Active=" + monitor.getAvgActive() 
					+ ",Max_Active=" + monitor.getMaxActive() 
					+ ",First_Access=" + monitor.getFirstAccess()
					+ ",Last_Access=" + monitor.getLastAccess() + ")");
		} else {
			LOG.warn("monitor is null -cannot log the performance stats");
		}

	}

	public void startChildMonitor(String operationName, String externalsystem, Exchange exchange) {
		if (performanceflag) {
			String label = externalsystem + ":" + operationName;
			Monitor monitor = null;
			monitor = MonitorFactory.startPrimary(label);
			exchange.setProperty("childmonitor", monitor);
		}
	}

	public void stopChildMonitor(Exchange exchange) {
		String userId = (String) exchange.getProperty(Constants.WS_USER_ID);
		String sourceSerId = (String) exchange.getProperty(Constants.SOURCE_SERVER_ID);
		String trackingId = (String) exchange.getProperty(Constants.TRACKING_ID);
		String serviceVersion = (String) exchange.getProperty(Constants.SERVICE_VERSION);

		if (userId != null) {
			MDC.put(Constants.WS_USER_ID, exchange.getProperty(Constants.WS_USER_ID));
		}
		if (sourceSerId != null) {
			MDC.put(Constants.SOURCE_SERVER_ID, exchange.getProperty(Constants.SOURCE_SERVER_ID));
		}
		if (trackingId != null) {
			MDC.put(Constants.TRACKING_ID, exchange.getProperty(Constants.TRACKING_ID));
		}
		if (serviceVersion != null) {
			MDC.put(Constants.SERVICE_VERSION, exchange.getProperty(Constants.SERVICE_VERSION));
		}

		Monitor monitor = (Monitor) exchange.getProperty("childmonitor");
		if (monitor != null) {
			monitor.stop();
			LOG.info("(Label=" + monitor.getLabel() 
					+ ",LastValue=" + monitor.getLastValue() 
					+ ",Hits=" + monitor.getHits() 
					+ ",Avg=" + monitor.getAvg()
					+ ",Total=" + monitor.getTotal() 
					+ ",Min=" + monitor.getMin() 
					+ ",Max=" + monitor.getMax() 
					+ ",Active=" + monitor.getActive()
					+ ",Avg_Active=" + monitor.getAvgActive() 
					+ ",Max_Active=" + monitor.getMaxActive() 
					+ ",First_Access=" + monitor.getFirstAccess()
					+ ",Last_Access=" + monitor.getLastAccess() + ")");

			exchange.removeProperty("childmonitor");
		} else {
			LOG.warn("monitor is null -cannot log the performance stats");
		}
	}

	public static void logPerformanceStats(Monitor monitor) {
		if (monitor != null) {
			monitor.stop();
			LOG.info("(Label=" + monitor.getLabel() 
					+ ",LastValue=" + monitor.getLastValue() 
					+ ",Hits=" + monitor.getHits() 
					+ ",Avg=" + monitor.getAvg()
					+ ",Total=" + monitor.getTotal() 
					+ ",Min=" + monitor.getMin() 
					+ ",Max=" + monitor.getMax() 
					+ ",Active=" + monitor.getActive()
					+ ",Avg_Active=" + monitor.getAvgActive() 
					+ ",Max_Active=" + monitor.getMaxActive() 
					+ ",First_Access=" + monitor.getFirstAccess()
					+ ",Last_Access=" + monitor.getLastAccess() + ")");
		}
	}

}
