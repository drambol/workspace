package jFrame;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import static jFrame.SwingConsole.*;

public class Button1 extends JFrame{
	private JButton
		b1 = new JButton("Button 1"),
		b2 = new JButton("Button 2");
	
	private JTextField txt = new JTextField(10);
	private ActionListener bl = new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	};
		
	public Button1(){
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}
	
	public static void main(String[] args){
		run(new Button1(), 200, 100);
	}
}
