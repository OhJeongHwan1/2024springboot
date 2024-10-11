package com.sample.spring.tv1;

public class TVUser {

	public static void main(String[] args) {
//		Lgtv tv = new Lgtv();
		SamsungTv tv = new SamsungTv();
		tv.turnOn();
		tv.turnOff();
		tv.soundOn();
		tv.soundOff();
	}
}
