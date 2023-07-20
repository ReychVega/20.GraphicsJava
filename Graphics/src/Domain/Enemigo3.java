package Domain;

import java.awt.Color;
import java.awt.Graphics;

public class Enemigo3 extends Enemigo{

	public Enemigo3(double posX, double posY) {
		super(posX, posY);
	} // constructor

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect((int)this.posX, (int)this.posY, 40, 40);
	} // dibujar

	public void mover() {
		super.mover(); // mover de derecha a izq como define el padre
		this.posY+=0.5*this.direccion; // mover de arriba a abajo como indica el hijo
		if(this.posY<=0)
			this.direccion=1;
		if(this.posY>=560)
			this.direccion=-1;		
	}	
	
} // fin clase