package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import Domain.Bala;
import Domain.Enemigo;
import Domain.Enemigo1;
import Domain.Enemigo2;
import Domain.Enemigo3;
import Domain.JuegoSingleton;
import Domain.Personaje;

public class MyPanel extends JPanel implements KeyListener, MouseListener, Runnable{

	// atributos
	private JuegoSingleton juego;
	
	private Graphics2D graphics2d;
	private BufferedImage buffer;
	private int FPS=60;
	private long time=1000/FPS;
	private Thread thread;
	private long espera;
	
	public MyPanel() {
		this.setPreferredSize(new Dimension(800, 600));
		this.setFocusable(true);
		this.setRequestFocusEnabled(true);
		this.addKeyListener(this);
		this.addMouseListener(this);
		this.juego=JuegoSingleton.getInstance();
	} // constructor
		
	private void init() {
		this.buffer=new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
		this.graphics2d=(Graphics2D)this.buffer.getGraphics();
	} // init
	
	public void addNotify() {
		super.addNotify();
		if(this.thread==null) {
			this.thread=new Thread(this);
			this.thread.start();
		}
	} // addNotify
	
	private void update() {
		this.juego.actualizar();
	}
	
	private void draw() {
		this.graphics2d.setColor(new Color(39, 177, 30));
		this.graphics2d.fillRect(0, 0, 800, 600);
		this.juego.dibujar(this.graphics2d);
	} // draw
	
	private void drawToScreen() {
		Graphics g=this.getGraphics();
		g.drawImage(this.buffer, 0, 0, 800, 600, null);
		g.dispose();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			this.juego.moverDerecha();
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			this.juego.getPersonaje1().moverIzquierda();
		if(e.getKeyCode()==KeyEvent.VK_UP)
			this.juego.getPersonaje1().moverArriba();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			this.juego.getPersonaje1().moverAbajo();
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
			this.juego.personaje1Disparar();	
		
		
		if(e.getKeyCode()==KeyEvent.VK_D)
			this.juego.getPersonaje2().moverDerecha();
		if(e.getKeyCode()==KeyEvent.VK_A)
			this.juego.getPersonaje2().moverIzquierda();
		if(e.getKeyCode()==KeyEvent.VK_W)
			this.juego.getPersonaje2().moverArriba();
		if(e.getKeyCode()==KeyEvent.VK_S)
			this.juego.getPersonaje2().moverAbajo();
		if(e.getKeyCode()==KeyEvent.VK_E)
			this.juego.personaje2Disparar();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
			this.juego.getPersonaje1().detenerMovimientoX();
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
			this.juego.getPersonaje1().detenerMovimientoX();		
		if(e.getKeyCode()==KeyEvent.VK_UP)
			this.juego.getPersonaje1().detenerMovimientoY();
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
			this.juego.getPersonaje1().detenerMovimientoY();
		
		
		if(e.getKeyCode()==KeyEvent.VK_D)
			this.juego.getPersonaje2().detenerMovimientoX();
		if(e.getKeyCode()==KeyEvent.VK_A)
			this.juego.getPersonaje2().detenerMovimientoX();		
		if(e.getKeyCode()==KeyEvent.VK_W)
			this.juego.getPersonaje2().detenerMovimientoY();
		if(e.getKeyCode()==KeyEvent.VK_S)
			this.juego.getPersonaje2().detenerMovimientoY();		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void run() {
		init();
		long start;
		long elapse;
		while(true) {
			start=System.nanoTime();
			//operaciones
			update();
			draw();
			drawToScreen();
			elapse=System.nanoTime()-start;
			this.espera=this.time-elapse/1000000; 
			if(this.espera<0) this.espera=5;
			try {
				Thread.sleep(this.espera); 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} // while
	} // run
	
} // fin clase