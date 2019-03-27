import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound{
	
	  void playBack(String musicLocation)
	{
		try
		{
			File musicPath = new File(musicLocation);

			if(musicPath.exists())
			{
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			else
			{
				System.out.println("Dont have audio");
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}