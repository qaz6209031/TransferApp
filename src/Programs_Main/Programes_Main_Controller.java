package Programs_Main;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Programes_Main_Controller {
	  @FXML
	  private JFXButton bt_EOPS;

	  @FXML
	  private void Programs_to_Main(MouseEvent event) {
		  close_Stage();
		  try {
			   Stage userstage = new Stage();
	           Parent root = FXMLLoader.load(getClass().getResource("/MainPage/Main.fxml"));
	           Scene scene = new Scene(root);
	           userstage.setScene(scene);
	           userstage.setTitle("Main Page");
	           userstage.setResizable(false);
	           userstage.show();
		  }
		  catch(IOException ex){
			  ex.printStackTrace();
		  }                
	  }
	  
	    @FXML
	    private void goto_ADElANTE(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Adelante.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("STEM Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_BLACK(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Black_Collegians.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Black Collegians");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_CMD(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/CMD.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Center for media and design");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_DISABLE(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Disable.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Disable");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_DUAL_ENROLLMENT(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Dual_Enrollment.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Dual Enrollment");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_EOPS(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/EOPS.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("EOPS");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_FirstYear(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/FirstYear.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("First Year Experience");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_GLOBAL(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Global.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Global");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_INTERN(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Intern.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Internship Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_MENTOR(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Mentor.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Mentor Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}
	    }

	    @FXML
	    private void goto_PROMO(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Promo.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Promo Pathway Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_SCHOLAR(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Scholars.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Scholars Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }

	    @FXML
	    private void goto_STEM(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/STEM.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("STEM Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}
	    }

	    @FXML
	    private void goto_STUDY(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/StudyAbroad.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Study Abroad");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}
	    }

	    @FXML
	    private void goto_VETERAN(ActionEvent event) {
	    	close_Stage();
	    	try {
	    		Stage userstage = new Stage();
	    		Parent root = FXMLLoader.load(getClass().getResource("/Programs_Pages/Veterans.fxml"));
		        Scene scene = new Scene(root);
		        userstage.setScene(scene);
		        userstage.setTitle("Veterans Program");
		        userstage.setResizable(false);
		        userstage.show();
	    	}
	    	catch(IOException ex) {
	    		ex.printStackTrace();
	    	}

	    }
	    
	    private void close_Stage() {
	    	Stage stage = (Stage)this.bt_EOPS.getScene().getWindow();
	    	stage.close();
	    }
}
