package com.api.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApiPlatformImpl implements ApiPlatform {
	
	protected ApiPlatformImpl() {	}
	
	@Override
	public String getQuery(String[] params) {
		String qS = "&";
		for(int i = 0; i<params.length; i++) {
			String[] parsed = params[i].split(":");
			if(i == params.length-1) qS += parsed[0] + "=" + parsed[1];
			else qS += parsed[0] + "=" + parsed[1] + "&";
		}
		return qS;
	}

}
