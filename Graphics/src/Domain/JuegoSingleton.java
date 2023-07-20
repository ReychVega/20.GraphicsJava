package Domain;

import java.awt.Graphics;
import java.util.ArrayList;

public class JuegoSingleton {

	private Personaje personaje1;
	private Personaje personaje2;
	private ArrayList<Enemigo> enemigos;
	private ArrayList<Bala> balasDisparadas;
	
	private static JuegoSingleton juegoSingleton;
	
	private JuegoSingleton() {
		this.personaje1=new Personaje(600, 300,255,0,0);
		this.personaje2=new Personaje(300, 300,0,0,255);
		this.enemigos=new ArrayList<>();
		this.balasDisparadas=new ArrayList<>();
		crearEnemigos();
		this.personaje1.start();
		this.personaje2.start();
	}

	public static JuegoSingleton getInstance() {
		if(juegoSingleton==null) 
			juegoSingleton=new JuegoSingleton();
		return juegoSingleton;
	}
	
	public void personaje1Disparar() {
		Bala b=this.personaje1.disparar();
		if(b!=null)
			this.balasDisparadas.add(b);
	}
	
	public void personaje2Disparar() {
		Bala b=this.personaje2.disparar();
		if(b!=null)
			this.balasDisparadas.add(b);
	}	
	
	private void crearEnemigos() {
		this.enemigos.add(new Enemigo3(400, 400));
		this.enemigos.add(new Enemigo1(300, 300));
		this.enemigos.add(new Enemigo2(300, 300));
	} // crearEnemigos
	
	
	private void crearNuevosEnemigos() {
		if(this.enemigos.size()<=1) {
			int tipoEnemigo=(int)(Math.random()*3+1);
			if(tipoEnemigo==1)
				this.enemigos.add(new Enemigo1(200, 200));
			else if(tipoEnemigo==2)
				this.enemigos.add(new Enemigo2(200, 200));
			else if(tipoEnemigo==3)
				this.enemigos.add(new Enemigo3(200, 200));
		}
	} // crearNuevosEnemigos
	
	public void dibujar(Graphics g) {
		this.personaje1.dibujar(g);
		this.personaje2.dibujar(g);
		
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
			this.enemigos.get(i).colision(this.personaje1);
			this.enemigos.get(i).colision(this.personaje2);
		} // for
		for (int i = 0; i < this.balasDisparadas.size(); i++) {
			this.balasDisparadas.get(i).desplazar();
			for (int j = 0; j < this.enemigos.size(); j++) { 
				if(this.balasDisparadas.get(i).colision(this.enemigos.get(j))) {
					this.enemigos.remove(j);
					this.balasDisparadas.remove(i);
					crearNuevosEnemigos();
					break; 
				} // if
			} // for enemigos
		} // for balas
		
	} // actualizar
	
	public void moverDerecha() {
		this.personaje1.moverDerecha();
	}

	public Personaje getPersonaje1() {
		return personaje1;
	}

	public void setPersonaje1(Personaje personaje) {
		this.personaje1 = personaje;
	}

	public Personaje getPersonaje2() {
		return personaje2;
	}

	public void setPersonaje2(Personaje personaje) {
		this.personaje2 = personaje;
	}	
	
	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<Enemigo> enemigos) {
		this.enemigos = enemigos;
	}
	
	
} // fin clase
