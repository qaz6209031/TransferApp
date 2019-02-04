package Start;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author 13354
 */
public class Start extends Application{
	
    public static MediaPlayer mediaplayer;
    public static Media musicFile;
    public static void main(String[] args){
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) {
        try{ 
        	Random_Music();
			mediaplayer = new MediaPlayer(musicFile);
			mediaplayer.setAutoPlay(true);

            Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch(IOException e){
           e.printStackTrace();
        }
    }
    
    public void Random_Music() {
    	Random rand = new Random();
    	int  num = rand.nextInt(3) + 1;
    	String path;
    	
    	try {
    		switch(num) {
        	case 1: 
        		path = new File("src/Start/AnotherRealm.mp3").getAbsolutePath();
        		musicFile = new Media(new File(path).toURI().toString());
        	    System.out.println("Load AnotherRealm.mp3 Successful"); break; 
        	case 2:
        		path = new File("src/Start/ThroughArbor.mp3").getAbsolutePath();
        		musicFile = new Media(new File(path).toURI().toString());
        	    System.out.println("Load ThroughArbor.mp3 Successful"); break; 
        	case 3:
        		path = new File("src/Start/StrawHats.mp3").getAbsolutePath();
                musicFile = new Media(new File(path).toURI().toString());
        	    System.out.println("Load StrawHats.mp3 Successful");
    	    }
    	}
    	catch(Exception e) {
    		System.err.println("Music File Load Error, Please Check the Path in Start package Start Class");
    	}
    	
    }
    	
}

