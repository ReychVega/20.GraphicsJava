package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class Juego {

	private Personaje personaje;
	private ArrayList<Enemigo> enemigos;
	private ArrayList<Bala> balasDisparadas;
	
	public Juego() {
		this.personaje=new Personaje(300, 300,100,100,100);
		this.enemigos=new ArrayList<>();
		this.balasDisparadas=new ArrayList<>();
		crearEnemigos();
	}

	public void disparar() {
		Bala b=this.personaje.disparar();
		if(b!=null)
			this.balasDisparadas.add(b);
	}
	
	private void crearEnemigos() {
		this.enemigos.add(new Enemigo3(400, 400));
		this.enemigos.add(new Enemigo1(300, 300));
		this.enemigos.add(new Enemigo2(300, 300));
	} // crearEnemigos
	
	public void dibujar(Graphics g) {
		this.personaje.dibujar(g);
		
		for (int i = 0; i < this.enemigos.size(); i++) {
			this.enemigos.get(i).dibujar(g);
		} // for
		
		for (int i = 0; i < this.balasDisparadas.size(); i++) {
			this.balasDisparadas.get(i).dibujar(g);
		} // for
	} // dibujar
	
	public void actualizar() {
		for (int i = 0; i < this.enemigos.size(); i++) {
			this.enemigos.get(i).mover();
			this.enemigos.get(i).colision(this.personaje);
		} // for
		for (int i = 0; i < this.balasDisparadas.size(); i++) {
			this.balasDisparadas.get(i).desplazar();
			for (int j = 0; j < this.enemigos.size(); j++) { 
				if(this.balasDisparadas.get(i).colision(this.enemigos.get(j))) {
					this.enemigos.remove(j);
					this.balasDisparadas.remove(i);
					break; 
				} // if
			} // for enemigos
		} // for balas
	} // actualizar
	
	public void moverDerecha() {
		this.personaje.moverDerecha();
	}

	public Personaje getPersonaje() {
		return personaje;
	}

	public void setPersonaje(Personaje personaje) {
		this.personaje = personaje;
	}

	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Enemigo> enemigos) {
		this.enemigos = enemigos;
	}
	
	
} // fin clase