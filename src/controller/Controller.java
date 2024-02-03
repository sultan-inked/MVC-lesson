package controller;

import model.Model;

public class Controller {
//	Variables:
	private Model model;
	
//	Constructors:
	public Controller(Model model) {
		this.model = model;
	}
	
//	Methods:
	public boolean checkPin(int pin) {
		return model.getPin() == pin;
	}

}
