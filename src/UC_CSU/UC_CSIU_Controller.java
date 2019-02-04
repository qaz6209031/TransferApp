package UC_CSU;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UC_CSIU_Controller {
	  @FXML
	  private JFXButton bt_back;
	  private Desktop d = Desktop.getDesktop();

	    @FXML
	    private void APPLY_CSU(ActionEvent event) throws IOException, URISyntaxException {
			 d.browse(new URI("https://calstate.liaisoncas.com/applicant-ux/#/login"));
	    }

	    @FXML
	    private void APPLY_TAG(ActionEvent event) throws IOException, URISyntaxException {
			d.browse(new URI("https://uctap.universityofcalifornia.edu/students/index.cfm"));
	    }

	    @FXML
	    private void APPLY_UC(ActionEvent event) throws IOException, URISyntaxException {
			d.browse(new URI("https://admissions.universityofcalifornia.edu/applicant/login.htm")); 
	    }

	    @FXML
	    private void UC_CSU_back(ActionEvent event) {
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
			 catch(IOException ex) {
				   ex.printStackTrace();
			 }
	    }
	    
	    private void close_Stage() {
	    	Stage stage = (Stage)this.bt_back.getScene().getWindow();
	    	stage.close();
	    }

}
