package com.sample.spring.tv3;

public class BeanContainer {
	public Object getBean(String id) {
		if(id.equals("lg")) return new Lgtv();
		if(id.equals("samsung")) return new SamsungTv();
		return null;
	}
}
