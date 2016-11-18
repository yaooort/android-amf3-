package com.weedong.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertyDescriptorHelper {

	public static List<PropertyDescriptor> getPropertyDescriptors(Class<?> type) {
		List<PropertyDescriptor> lsDescriptor = new ArrayList<PropertyDescriptor>();
		Method[] aryMethod = type.getMethods();
		Map<String, Method> dicMethod = new HashMap<String, Method>();  
		for (Method method : aryMethod) {     
			if(method.getName().startsWith("set") && method.getParameterTypes() != null && method.getParameterTypes().length == 1) {
				dicMethod.put(method.getName(),method);  
			}
		}
		
        for(Method method : aryMethod) {
        	if (method.getName().startsWith("get") && method.getParameterTypes().length == 0) {
				String name = Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4, method.getName().length());
				
				PropertyDescriptor desc = new PropertyDescriptor();
				desc.setDisplayName(name);
				desc.setName(name);
				desc.setReadMethod(method);
				String setMethodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1, name.length());
				if(dicMethod.containsKey(setMethodName)){
					desc.setWriteMethod(dicMethod.get(setMethodName));
				}
				lsDescriptor.add(desc);
			} else if (method.getName().startsWith("is") && method.getParameterTypes().length == 0) {
				String name = Character.toLowerCase(method.getName().charAt(2)) + method.getName().substring(3, method.getName().length());
				PropertyDescriptor desc = new PropertyDescriptor();
				desc.setDisplayName(name);
				desc.setName(name);
				desc.setReadMethod(method);
				String setMethodName = "set" + name.substring(0,1).toUpperCase() + name.substring(1, name.length());
				if(dicMethod.containsKey(setMethodName)){
					desc.setWriteMethod(dicMethod.get(setMethodName));
				}
				lsDescriptor.add(desc);
			}
        }
        
        return lsDescriptor;
	}
	
	public static List<PropertyDescriptor> getPropertyDescriptors(Object bean) {
		return getPropertyDescriptors(bean.getClass());
	}
}
