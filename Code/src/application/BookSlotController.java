package application;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Calendar;

import DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class BookSlotController {
	
	@FXML
    private Button btnHome;

    @FXML
    private Button btnAccount;

    @FXML
    private TextField sname;

    @FXML
    private RadioButton smale;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton sfemale;

    @FXML
    private RadioButton sothers;

    @FXML
    private DatePicker sdob;

    @FXML
    private TextField saadhar;

    @FXML
    private DatePicker spreferredslot;

    @FXML
    private Button register;

    @FXML
    private RadioButton covishield;

    @FXML
    private ToggleGroup vaccine;

    @FXML
    private RadioButton covaxine;

    @FXML
    private RadioButton dose1;

    @FXML
    private ToggleGroup dose;

    @FXML
    private RadioButton dose2;
    
    @FXML
    void Account(ActionEvent event) throws IOException {
    		btnHome.getScene().getWindow().hide();
	    	Stage acc = new Stage();
	    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/Account.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			acc.setScene(scene);
			
			acc.setMaximized(true);
			
			acc.show();
    }

    @FXML
    void Home(ActionEvent event) throws IOException {
    		btnHome.getScene().getWindow().hide();
	    	Stage home = new Stage();
	    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			home.setScene(scene);
			
			home.setMaximized(true);
			
			home.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	File file = new File("../CovidVaccineManagementSystem/src/application/info.txt");
    	if(file.delete()) {
    		System.out.println("Deleted");
    	}
    	btnHome.getScene().getWindow().hide();
    	Stage login = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		login.setScene(scene);
		
		login.setResizable(false);
		
		login.show();
    }
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    

    @FXML
    void register(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    	
    	handler=new DBHandler();
    	connection = handler.getConnection();
    	
    	Calendar now= Calendar.getInstance();
    	int yr=now.get(Calendar.YEAR);
    	int byr=sdob.getValue().getYear();
    	int age=yr-byr;
    	
    	if(dose2.isSelected()) { 			
        	String insert1="UPDATE SLOTBOOKING SET 2NDDOSEDATE =? WHERE AADHAR=? AND VACCINE='Covaxine'";
        	String insert2="UPDATE SLOTBOOKING SET 2NDDOSEDATE =? WHERE AADHAR=? AND VACCINE='Covishield'";
        	if(covaxine.isSelected())
        	{
        	pst=connection.prepareStatement(insert1);
        	pst.setDate(1, java.sql.Date.valueOf(spreferredslot.getValue()));
        	pst.setString(2,saadhar.getText());
        	int affected=pst.executeUpdate();
        	if(affected>0) {
        		pst.executeUpdate();
        		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        		a1.setContentText("2nd Slot Booked Successfully");
        		a1.setHeaderText(null);
        		a1.showAndWait();
        	}
        	else {
        		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        		a1.setContentText("1st Dose not taken! Or Taken with Covishield");
        		a1.setHeaderText(null);
        		a1.showAndWait();
        	}
    	}
        	
        	if(covishield.isSelected())
        	{
        	pst=connection.prepareStatement(insert2);
        	pst.setDate(1, java.sql.Date.valueOf(spreferredslot.getValue()));
        	pst.setString(2,saadhar.getText());
        	int affected=pst.executeUpdate();
        	if(affected>0) {
        		pst.executeUpdate();
        		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        		a1.setContentText("2nd Slot Booked Successfully");
        		a1.setHeaderText(null);
        		a1.showAndWait();
        	}
        	else {
        		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        		a1.setContentText("1st Dose not taken! Or Taken with Covaxin");
        		a1.setHeaderText(null);
        		a1.showAndWait();
        	}
    	}
        	
    	}
    	else{
    	
    	if(age>=18) {    	
    	String insert="INSERT INTO SLOTBOOKING(USERID, NAME, GENDER, DOB, AADHAR, 1STSLOTDATE, VACCINE)"+ "VALUES(?,?,?,?,?,?,?)";
    	pst=connection.prepareStatement(insert);
    	pst.setInt(1,LoginController.userid);
    	pst.setString(2,sname.getText());
    	if(smale.isSelected())
    		pst.setString(3, "Male");
    	else if(sfemale.isSelected())
    		pst.setString(3, "Female");
    	else
    		pst.setString(3, "Others");
    	
    	pst.setDate(4, java.sql.Date.valueOf(sdob.getValue()));
    	
    	
    	
    	
    	pst.setString(5, saadhar.getText());
    	pst.setDate(6, java.sql.Date.valueOf(spreferredslot.getValue()));
    	
    	if(covishield.isSelected())
    		pst.setString(7, "Covishield");
    	else if(covaxine.isSelected())
    		pst.setString(7, "Covaxine");
    	else
    		pst.setString(7, null);
    	
    	pst.executeUpdate();
    	Alert a1= new Alert(Alert.AlertType.INFORMATION);
		a1.setContentText("Slot Booked Successfully");
		a1.setHeaderText(null);
		a1.showAndWait();
    	
    	}
    	
    	else
    	{
    		Alert a1= new Alert(Alert.AlertType.INFORMATION);
    		a1.setContentText("Below age 18 are not allowed!");
    		a1.setHeaderText(null);
    		a1.showAndWait();
    	}
    	
    	
    }
    	
    	btnHome.getScene().getWindow().hide();
    	Stage BS = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/BookSlot.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		BS.setScene(scene);
		
		BS.setMaximized(true);
		
		BS.show();
    
    }


}
