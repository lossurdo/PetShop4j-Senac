package com.jdf.util;

import java.lang.reflect.Method;

/**
 * UtilitÃ¡rio para tratar de reflexÃ£o em classes
 * @author lossurdo
 * @since 15/03/2009
 */
public final class UtilMethod {
	
	/**
	 * Executa a aÃ§Ã£o sem passagem de parÃ¢metros
	 * @param object instÃ¢ncia do objeto que contÃ©m o mÃ©todo a ser executado
	 * @param method mÃ©todo a ser executado
	 */
	
	public static synchronized Object executeMethod(Object object, String method) {
		try {
			Class<?> clazz = object.getClass();
			Method m = clazz.getDeclaredMethod(method, null);
			m.setAccessible(true);
			return m.invoke(object, null);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
