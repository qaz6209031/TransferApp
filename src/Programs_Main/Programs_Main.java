package Programs_Main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Programs_Main extends Application {
	  @Override
	  public void start(Stage primaryStage) {
	      try{ 
	          Parent root = FXMLLoader.load(getClass().getResource("Programs_Main.fxml"));
	          Scene scene = new Scene(root);
	          primaryStage.setScene(scene);
	          primaryStage.show();
	        }
	        catch(IOException e){
	           e.printStackTrace();
	        }
	    }
}
