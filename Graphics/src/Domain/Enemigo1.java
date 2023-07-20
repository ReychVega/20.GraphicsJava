package Domain;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemigo1 extends Enemigo{

	public Enemigo1(double posX, double posY) {
		super(posX, posY);
		try {
			this.imagen=ImageIO.read(getClass().getResourceAsStream("/assets/arania.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // constuctor

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.black);
		//g.fillOval((int)this.posX, (int)this.posY, 40, 40);
		g.drawImage(this.imagen, (int)this.posX, (int)this.posY, null);
	} // dibujar


} // fin clase