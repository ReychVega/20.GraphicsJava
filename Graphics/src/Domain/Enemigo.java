package Domain;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Enemigo {

	protected double posX;
	protected double posY;
	protected int direccion;
	protected BufferedImage imagen;
	
	public Enemigo(double posX, double posY) {
		this.posX=posX;
		this.posY=posY;
		this.direccion=1;
	} // constructor
	
	public abstract void dibujar(Graphics g);
	
	public void mover() {
		this.posX+=0.5*this.direccion;
		if(this.posX>=760)
			this.direccion=-1;
		if(this.posX<=0)
			this.direccion=1;
	}

	public void colision(Personaje personaje) {
		if((this.posX<personaje.getPosX()+40 && this.posX>personaje.getPosX())
				&&(this.posY<personaje.getPosY()+40 && this.posY>personaje.getPosY()))
			personaje.setVida(personaje.getVida()-10);
	} // colision
	
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