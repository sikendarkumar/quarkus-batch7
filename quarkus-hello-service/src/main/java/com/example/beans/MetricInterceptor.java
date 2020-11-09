package com.example.beans;

import java.util.HashMap;
import java.util.Map;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Counted
@Interceptor
public class MetricInterceptor {

	Map<String, Integer> metrics = new HashMap<String, Integer>();

	@AroundInvoke
	public Object after(InvocationContext context) {
		try {
			return context.proceed(); // invoke original method..
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			String methodName = context.getMethod().getName();
			if (metrics.containsKey(methodName)) {
				metrics.put(methodName, metrics.get(methodName) + 1);
			} else {
				metrics.put(methodName, 1);
			}

			System.out.println(metrics);

		}
		return null;
	}

}
