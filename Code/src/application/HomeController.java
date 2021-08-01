package application;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private Button btnBookSlot;
    
    @FXML
    private Label welcome;
 

    @FXML
    private Button btnRegSlot;

    @FXML
    private Button btnAvail;

    @FXML
    private Button btnAccount;

    @FXML
    private Button btnLogout;
	
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
	@FXML
    private void initialize() throws ClassNotFoundException, SQLException {
		
		handler=new DBHandler();
    	String qry="SELECT * FROM USERS WHERE USERID="+LoginController.userid;
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(qry);
    	ResultSet resultSet=pst.executeQuery();
    	if(resultSet.next())
    	welcome.setText("Welcome, "+resultSet.getString("name"));
    	System.out.println(LoginController.userid);
    }
    
	@FXML
    void Account(ActionEvent event) throws IOException {
		btnBookSlot.getScene().getWindow().hide();
    	Stage acc = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/Account.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		acc.setScene(scene);
		
		acc.setMaximized(true);
		
		acc.show();
    }

    @FXML
    void BookSlot(ActionEvent event) throws IOException {
    	btnBookSlot.getScene().getWindow().hide();
    	Stage BS = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/BookSlot.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		BS.setScene(scene);
		
		BS.setMaximized(true);
		
		BS.show();
    }

    @FXML
    void RegisteredSlot(ActionEvent event) throws IOException {
    	btnBookSlot.getScene().getWindow().hide();
    	Stage RS = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/RegisteredSlot.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		RS.setScene(scene);
		
		RS.setMaximized(true);
		
		RS.show();
    }

    @FXML
    void VaccineAvailability(ActionEvent event) throws IOException {
    	Stage VA = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/VaccineAvailability.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		VA.setScene(scene);
		VA.setResizable(false);
		
		VA.show();
    }

    @FXML
    void logout(ActionEvent event) throws IOException {
    	File file = new File("../CovidVaccineManagementSystem/src/application/info.txt");
    	if(file.delete()) {
    		System.out.println("Deleted");
    	}
    	else
    		System.out.println("Not Deleted");
    	
    	btnBookSlot.getScene().getWindow().hide();
    	Stage login = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		login.setScene(scene);
		
		login.setResizable(false);
		
		login.show();
    	
    	
    }
}
