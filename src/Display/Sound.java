/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author User
 */
public class Sound { 
 public static void play(){   
    try{

        InputStream in = new FileInputStream(new File("vof.wav"));
        AudioStream audioStream = new AudioStream(in);
         AudioPlayer.player.start(audioStream);
    }catch(Exception error){
          System.out.println("File Not Found");
          System.out.println(error);
}
 }
 public static void stop(){   
    try{

        InputStream in = new FileInputStream(new File("vof.wav"));
        AudioStream audioStream = new AudioStream(in);
         AudioPlayer.player.stop(audioStream);
    }catch(Exception error){
          System.out.println("File Not Found");
          System.out.println(error);

}
 }
}
