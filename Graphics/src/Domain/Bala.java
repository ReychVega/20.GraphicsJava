package Domain;

import java.awt.Color;
import java.awt.Graphics;

public class Bala {

	private double posX;
	private double posY;
	
	public Bala() {
		this.posX=0;
		this.posY=0;
	} // constructor
	
	
	public Bala(double posX, double posY) {
		this.posX=posX;
		this.posY=posY;
	} // constructor
	
	public void dibujar(Graphics g) {
		g.setColor(Color.yellow);
		g.fillOval((int)this.posX, (int)this.posY, 10, 10);
	}
	
	public boolean colision(Enemigo enemigo) {
		if((this.posX<enemigo.getPosX()+40 && this.posX>enemigo.getPosX())
				&&(this.posY<enemigo.getPosY()+40 && this.posY>enemigo.getPosY()))
			return true;
		return false;
	} // colision	
	
	public void desplazar() {
		this.posX+=2;
	}


	public double getPosX() {
		return posX;
	}


	public void setPosX(double posX) {
		this.posX = posX;
	}


	public double getPosY() {
		return posY;
	}


	public void setPosY(double posY) {
		this.posY = posY;
	}
	
	
	
} // fin clase
