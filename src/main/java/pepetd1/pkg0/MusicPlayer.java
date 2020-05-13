/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pepetd1.pkg0;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JOptionPane;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Andras
 */
public class MusicPlayer {
	
	AudioStream audio;
	
    MusicPlayer(){
        
    }
    
    public void playMusic(String filePath){
        InputStream music;
        
        try{
            music = new FileInputStream(new File(filePath));
            audio = new AudioStream(music);
            AudioPlayer.player.start(audio);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }
    
    @SuppressWarnings("deprecation")
	public void stopMusic() {
    	AudioPlayer.player.stop(audio);
    }
    
}
