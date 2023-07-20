package Main;

import javax.swing.JFrame;

import Domain.JuegoSingleton;
import GUI.MyPanel;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {

		JFrame ventana=new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventana.setSize(800, 600);
		ventana.setResizable(false);
		
		ventana.add(new MyPanel());
		ventana.pack();
		
		ventana.setLocationRelativeTo(null);
		
		ventana.setVisible(true);
		
		
//		JFrame ventana2=new JFrame();
//		ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		//ventana.setSize(800, 600);
//		ventana2.setResizable(false);
//		
//		ventana2.add(new MyPanel());
//		ventana2.pack();
//		
//		ventana2.setLocationRelativeTo(null);
//		
//		ventana2.setVisible(true);		
			
		
	} // main

} // fin clase