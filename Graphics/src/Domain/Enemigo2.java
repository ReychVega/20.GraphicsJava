package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemigo2 extends Enemigo{

	public Enemigo2(double posX, double posY) {
		super(posX, posY);
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/assets/arania2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	} // constructor

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.gray);
		//g.fillOval((int)this.posX, (int)this.posY, 40, 40);
		g.drawImage(this.imagen, (int)this.posX, (int)this.posY, null);
	} // dibujar

	public void mover() {
		this.posY+=0.5*this.direccion;
		if(this.posY<=0)
			this.direccion=1;
		if(this.posY>=560)
			this.direccion=-1;		
	}


} // fin clase