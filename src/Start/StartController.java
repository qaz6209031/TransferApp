package Start;

import java.io.IOException;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class StartController {
	
	private boolean music_on = true;

	@FXML
	private Button btStart;
	
	
	@FXML
    private MaterialDesignIconView speaker;
	
	@FXML
	public void start() {
		try{    
			Stage stage =(Stage)this.btStart.getScene().getWindow();
			stage.close();
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/MainPage/Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();

			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	/*
	@FXML
    void Play_Pause(MouseEvent event) {
		//Play the music
		if(music_on) {
			Start.mediaplayer.pause();
			//speaker = new MaterialDesignIconView(MaterialDesignIcon.VOLUME_OFF);
		    this.music_on = false;
		}
		//Pause the music
		else {
			Start.mediaplayer.play();
			//speaker = new MaterialDesignIconView(MaterialDesignIcon.VOLUME_HIGH);
	        this.music_on = true;
        }
	}
	*/
}
