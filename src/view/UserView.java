package view;

import javax.swing.*;
import java.awt.*;

//import model.Model;
import controller.Controller;


public class UserView extends JFrame {
//	Variables:
	private JTextArea text;
	private JButton sendButton;
	private JLabel info;
	private Controller controller;
	
//	Constructors:
	public UserView(Controller controller) {
		this.controller = controller;
	}
	
//	Methods:
	public void init() {
		setSize(400, 300);
		text = new JTextArea();
		sendButton = new JButton("Send");
		info = new JLabel("Info");
		
		add(text, BorderLayout.CENTER);
		add(sendButton, BorderLayout.SOUTH);
		add(info, BorderLayout.NORTH);
		
		sendButton.addActionListener(e -> {
			int pin;
			String textPin = this.text.getText();
			text.setText(""); // очищает поле ввода
			try {
				pin = Integer.parseInt(textPin);
				info.setText("Got it: " + pin + " Waiting...");
				
				Thread thread = new Thread(() -> {
					sendButton.setEnabled(false); // запрещает лишнее нажатие на кнопку во время выполнения
					boolean result;
					result = controller.checkPin(pin);
					String resultMessage;
					if(result) {
						resultMessage = "Rigth!";
					}else {
						resultMessage = "Wrong, try again:";
					}
					info.setText(resultMessage);
					sendButton.setEnabled(true); // снова разрешает нажатие после выполнения
				});
				thread.start();
			} catch(NumberFormatException e1) { // обработка исключений
				info.setText("Only numbers allowed...");
			}
			
			// pin-code processing:
//			checkPin();
//			Model model = new Model();
//			model.getPin();
		});
		
		
		setVisible(true);
	}

//	private void checkPin() {
//		
//	}
}
