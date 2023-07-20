package Domain;

import java.awt.Color;
import java.awt.Graphics;

public class Personaje extends Thread{

	private double posX;
	private double posY;
	private int vida;
	private int direccionX;
	private int direccionY;
	
	private int color[];
	private int cantidaBalas;
	
	public Personaje() {
		this.posX=0;
		this.posY=0;
		this.vida=100;
		this.cantidaBalas=10;
		this.direccionX=0;
		this.direccionY=0;
	} // constructor
	
	public Personaje(double posX, double posY, int r, int g, int b) {
		this.posX=posX;
		this.posY=posY;
		this.vida=100;
		this.cantidaBalas=10;
		this.direccionX=0;
		this.direccionY=0;
		this.color=new int[3];
		this.color[0]=r;
		this.color[1]=g;
		this.color[2]=b;
	} // constructor	
	
	public Bala disparar() {
		if(this.cantidaBalas>0) {
			this.cantidaBalas=this.cantidaBalas-1;
			return new Bala(this.posX+40, this.posY+15);
		}
		return null;
	} // disparar

	public void dibujar(Graphics g) {
		g.setColor(new Color(this.color[0], this.color[1], this.color[2]));
		g.fillOval((int)this.posX, (int)this.posY, 40, 40);
		g.setColor(Color.white);
		g.drawString(this.vida+"", (int)this.posX+10, (int)this.posY+25);
	} // dibujar
	
	public void atacar() {}
	
	public void moverDerecha() {
		this.direccionX=1;
	}
	
	public void detenerMovimientoX() {
		this.direccionX=0;
	}
	
	public void detenerMovimientoY() {
		this.direccionY=0;
	}	
	
	public void moverIzquierda() {
		this.direccionX=-1;
	}
	
	public void moverArriba() {
		this.direccionY=-1;
	}
	
	public void moverAbajo() {
		this.direccionY=1;
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

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void run() {
		while(true) {
			this.posX+=1*this.direccionX;
			this.posY+=1*this.direccionY;
			try {
				Thread.sleep(16);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} //
	
	
} // fin clase