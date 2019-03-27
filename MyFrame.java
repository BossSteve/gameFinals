import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class MyFrame extends JFrame implements KeyListener{

	Draw drawing;

	public MyFrame(){
		this.drawing = new Draw();
	}

	public void keyPressed(KeyEvent e){

		if(e.getKeyCode() == KeyEvent.VK_W){
			drawing.jump();
			System.out.println("jump");
		}

		else if(e.getKeyCode() == KeyEvent.VK_D){
			drawing.moveRight();
			System.out.println("pos: " + drawing.x + ", " + drawing.y);
		}

		else if(e.getKeyCode() == KeyEvent.VK_S){
			drawing.hurt();
			System.out.println("jump");
		}

		else if(e.getKeyCode() == KeyEvent.VK_A){
			drawing.moveLeft();
			System.out.println("pos:" + drawing.x + ", " + drawing.y);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			drawing.moveRight2();
			System.out.println("pos" + drawing.a + ", " + drawing.b);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			drawing.moveleft2();
			System.out.println("pos:" + drawing.a + ", " + drawing.b);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			drawing.fall();
			System.out.println("Player 2 fall");
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN){
			drawing.slide();
			System.out.println("Player 2 slides");
		}
	

	
	}

	public void keyTyped(KeyEvent event){

	}

	public void keyReleased(KeyEvent event){

	}

	public static void main(String args[]){
		MyFrame gameFrame = new MyFrame();
		gameFrame.setSize(1280,640);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setVisible(true);

		gameFrame.getContentPane().add(gameFrame.drawing);
		gameFrame.addKeyListener(gameFrame);
		System.out.println("JavaGame");

		String filepath = "bgmusic.wav";
		Sound musicObject = new Sound();
		musicObject.playBack(filepath);

	}
} 