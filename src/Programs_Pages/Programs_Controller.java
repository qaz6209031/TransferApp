package Programs_Pages;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Programs_Controller {
	private Desktop d = Desktop.getDesktop();
	 @FXML
	 private void Back_Programs_Main(ActionEvent event) {
		 
         Node node = (Node) event.getSource();
		 Stage stage = (Stage) node.getScene().getWindow();
		 stage.close();
		 try {
			  Stage userstage = new Stage();
	          Parent root = FXMLLoader.load(getClass().getResource("/Programs_Main/Programs_Main.fxml"));
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
	 
	 @FXML 
	 private void apply_Dual(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/EnrollmentDevelopment/Admissions/HS-Concurrent-Program/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Scholars(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/Scholars/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_STEM(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/AcademicPrograms/Counseling/STEM/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Adelante(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/studentservices/latinocenter/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_StudyAbroad(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/EnrollmentDevelopment/IEC/StudyAbroad/Pages/default.aspx"));
	 }

	 @FXML
	 private void apply_Mentor(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/AcademicPrograms/Art/Pages/Mentor-Program-in-the-Arts.aspx"));
	 }
	 
	 @FXML
	 private void apply_Black(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/BlackCollegians/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_EOPS(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/EOPS/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Veterans(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/VeteransResourceCenter/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Global(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/GlobalCitizenship/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_FirstYear(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/WelcomeCenter/Pages/First-Year-Experience.aspx"));
	 }
	 
	 @FXML
	 private void apply_Disable(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/DisabilityResources/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_CMD(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/AboutSMC/CMD/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Intern(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/StudentServices/CareerServicesCenter/internship/Pages/default.aspx"));
	 }
	 
	 @FXML
	 private void apply_Promo(ActionEvent event) throws Exception {
		 d.browse(new URI("http://www.smc.edu/AcademicAffairs/Workforce/Pages/Promo-Pathway.aspx"));
	 }
}
