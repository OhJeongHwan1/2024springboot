package com.sample.spring.tv2;

public class TVUser {

	public static void main(String[] args) {
//		Lgtv tv = new Lgtv();
		Tv tv = new Lgtv();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();
	}
}
