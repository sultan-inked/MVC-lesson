package model;

import java.util.concurrent.TimeUnit;

public class Model {
//	Variables:
	private int pin = 1234;

//	Getters and Setters:
	public int getPin() {
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
//	Methods:
	
}
