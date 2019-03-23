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
	private BufferedImage backgroundImage;
	public URL resource = getClass().getResource("run0.png");

	// circle's position
	public int x = 20;
	public int y = 360;

	// animation states
	public int state = 0;

	Monster monster1;
	Monster monster2;

	public Draw(){
		
		//monster1 = new Monster(200, 200);
		//monster2 = new Monster(300, 200);

		try{
			image = ImageIO.read(resource);
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

	public void attackAnimation(){
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

	public void jump(){
		attackAnimation();
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

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		g.setColor(Color.YELLOW);

		g.drawImage(backgroundImage, 0,0,1280,640, this);

		g.drawImage(image, x,y,200,200, this);

		//g.drawImage(monster1.image, monster1.xPos, monster1.yPos, this);
		//g.drawImage(monster2.image, monster2.xPos, monster2.yPos, this);
	}
}