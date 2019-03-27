import javax.swing.JComponent;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.net.URL;

public class Draw extends JComponent{

	private BufferedImage image;
	private BufferedImage image2;
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");
	public URL resource2 = getClass().getResource("walk0.png");

	// circle's position
	public int x = 20;
	public int y = 360;
	public int a = 1030;
	public int b = 360;

	// animation states
	public int state = 0;

	Monster monster1;
	Monster monster2;


	public Draw(){
		
		monster1 = new Monster(200, 200);
		//fffff`gv`bgggmonster2 = new Monster(300, 200);

		try{
			image = ImageIO.read(resource);
			image2 = ImageIO.read(resource2);
			backgroundImage = ImageIO.read(getClass().getResource("background.jpg"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	public void reloadImage(){
		
		state++;

		if(state == 0){
			resource = getClass().getResource("run0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("run1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("run2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("run3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("run4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("run5.png");
		}
		else if(state == 6){
			resource = getClass().getResource("run6.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

		public void reloadImage2(){
		
		state++;

		if(state == 0){
			resource2 = getClass().getResource("walk0.png");
		}
		else if(state == 1){
			resource2 = getClass().getResource("walk1.png");
		}
		else if(state == 2){
			resource2 = getClass().getResource("walk2.png");
		}
		else if(state == 3){
			resource2 = getClass().getResource("walk3.png");
		}
		else if(state == 4){
			resource2 = getClass().getResource("walk4.png");
		}
		else if(state == 5){
			resource2 = getClass().getResource("walk5.png");
		}
		else if(state == 6){
			resource2 = getClass().getResource("walk6.png");
		}
		else if(state ==7){
			resource2 = getClass().getResource("walk7.png");
		}
		else if(state ==8){
			resource2 = getClass().getResource("walk8.png");
			state = 0;
		}

		try{
			image2 = ImageIO.read(resource2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void RunLeft(){
		
		state++;

		if(state == 0){
			resource = getClass().getResource("runLeft0.png");
		}
		else if(state == 1){
			resource = getClass().getResource("runLeft1.png");
		}
		else if(state == 2){
			resource = getClass().getResource("runLeft2.png");
		}
		else if(state == 3){
			resource = getClass().getResource("runLeft3.png");
		}
		else if(state == 4){
			resource = getClass().getResource("runLeft4.png");
		}
		else if(state == 5){
			resource = getClass().getResource("runLeft5.png");
		}
		else if(state == 6){
			resource = getClass().getResource("runLeft6.png");
			state = 0;
		}

		try{
			image = ImageIO.read(resource);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}

	public void walkLeft(){
		
		state++;

		if(state == 0){
			resource2 = getClass().getResource("walkleft0.png");
		}
		else if(state == 1){
			resource2 = getClass().getResource("walkleft1.png");
		}
		else if(state == 2){
			resource2 = getClass().getResource("walkleft2.png");
		}
		else if(state == 3){
			resource2 = getClass().getResource("walkleft3.png");
		}
		else if(state == 4){
			resource2= getClass().getResource("walkleft4.png");
		}
		else if(state == 5){
			resource2 = getClass().getResource("walkleft5.png");
		}
		else if(state == 6){
			resource2 = getClass().getResource("walkleft6.png");
		}
		else if(state == 7){
			resource2 = getClass().getResource("walkleft7.png");
		}
		else if(state == 8){
			resource2 = getClass().getResource("walkleft8.png");
		}
		else if(state == 9){
			resource2 = getClass().getResource("walkleft9.png");
			state = 0;
		}
		try{
			image2 = ImageIO.read(resource2);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}


	public void jumpAnimation(){
		Thread thread1 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 7; ctr++){
					try {
						if(ctr==6){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("jump"+ctr+".png");
						}
						
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
	}

	public void hurtAnimation(){
		Thread thread2 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try{
						if(ctr==8){
							resource = getClass().getResource("run0.png");
						}
						else{
							resource = getClass().getResource("hurt"+ctr+".png");
						}
						try{
							image = ImageIO.read(resource);
						}
						catch(IOException e){
							e.printStackTrace();
						}
						repaint();
						Thread.sleep(100);
					
				       	}catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread2.start();
	}

	public void fallAnimation(){
		Thread thread3 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 7; ctr++){
					try {
						if(ctr==6){
							resource2 = getClass().getResource("walk0.png");
						}
						else{
							resource2 = getClass().getResource("fall"+ctr+".png");
						}
						try{
							image2 = ImageIO.read(resource2);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread3.start();
	}

	public void slideAnimation(){
		Thread thread4 = new Thread(new Runnable(){
			public void run(){
				for(int ctr = 0; ctr < 9; ctr++){
					try {
						if(ctr==8){
							resource2 = getClass().getResource("walk0.png");
						}
						else{
							resource2 = getClass().getResource("slide"+ctr+".png");
						}
						try{
							image2 = ImageIO.read(resource2);
						}
						catch(IOException e){
							e.printStackTrace();
						}
				        repaint();
				        Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread4.start();
	}
	public void jump(){
		jumpAnimation();
	}
	public void hurt(){
		hurtAnimation();
	}
	public void fall(){
		fallAnimation();
	}
	public void slide(){
		slideAnimation();
	}

	public void moveUp(){
		y = y - 5;
		reloadImage();
		repaint();
	}

	public void moveDown(){
		y = y + 5;
		reloadImage();
		repaint();
	}

	public void moveLeft(){
		x = x - 10;
		RunLeft();
		repaint();
	}

	public void moveRight(){
		x = x + 10;
		reloadImage();
		repaint();
	}

	public void moveRight2(){
		a = a +10;
		reloadImage2();
		repaint();
	}
	public void moveleft2(){
		a = a - 10;
		walkLeft();
		repaint();
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.YELLOW);

		g.drawImage(backgroundImage, 0,0,1280,640, this);

		g.drawImage(image, x,y,200,200, this);
		g.drawImage(image2, a,b,200,200,this);

		g.drawImage(monster1.image, monster1.xPos +450, monster1.yPos -250, this);
		//g.drawImage(monster2.image, monster2.xPos + 100, monster2.yPos -150,this);
	}
}