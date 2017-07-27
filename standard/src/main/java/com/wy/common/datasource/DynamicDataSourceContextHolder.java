package com.wy.common.datasource;

import java.util.ArrayList;
import java.util.List;

/**
 * DynamicDataSourceContextHolder
 * 
 */
public class DynamicDataSourceContextHolder {

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

	public static List<String> dataSourceIds = new ArrayList<String>();

	public static String getThreadDataSource() {
		return (String) contextHolder.get();
	}

	public static void setDataSourceType(String dataSourceType) {
		contextHolder.set(dataSourceType);
	}

	public static String getDataSourceType() {
		return contextHolder.get();
	}

	public static void clearDataSourceType() {
		contextHolder.remove();
	}

	/**
	 * 功能描述：判断指定DataSrouce当前是否存在
	 */
	public static boolean containsDataSource(String dataSourceId) {
		return dataSourceIds.contains(dataSourceId);
	}
}
