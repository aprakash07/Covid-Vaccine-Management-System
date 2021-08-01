package application;

import java.io.File;
import java.io.IOException;

import DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import DBConnection.DBHandler;
import java.sql.*;

public class AccountController {
	
	private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
	@FXML
    private Button btnHome;
	
	  @FXML
	    private Label name;

	    @FXML
	    private Label username;

	    @FXML
	    private Label gender;

	    @FXML
	    private Label address;

	    @FXML
	    private Button btnlogout;
	    
	    @FXML
	    private Button btnview;

	    @FXML
	    void logout(ActionEvent event) throws IOException {
	    	
	    	
	    	File file = new File("../CovidVaccineManagementSystem/src/application/info.txt");
	    	if(file.delete()) {
	    		System.out.println("Deleted");
	    	}
	    	
	    	
	    	btnlogout.getScene().getWindow().hide();
	    	Stage login = new Stage();
	    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			login.setScene(scene);
			
			login.setResizable(false);
			
			login.show();
	    }

	    @FXML
	    void view(ActionEvent event) throws IOException {
	    	btnHome.getScene().getWindow().hide();
	    	Stage acc = new Stage();
	    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/ViewDetail.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			acc.setScene(scene);
			
			acc.setMaximized(true);
			
			acc.show();
	    }

	
	
	@FXML
	private void initialize() throws ClassNotFoundException, SQLException {
		handler=new DBHandler();
    	String qry="SELECT * FROM USERS WHERE USERID="+LoginController.userid;
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(qry);
    	ResultSet resultSet=pst.executeQuery();
    	if(resultSet.next()) {
    	name.setText(resultSet.getString("name"));
    	username.setText(resultSet.getString("username"));
    	gender.setText(resultSet.getString("gender"));
    	address.setText(resultSet.getString("address"));
    	}
	}
	
	
    @FXML
    void Home(ActionEvent event) throws IOException {
    	btnHome.getScene().getWindow().hide();
    	Stage acc = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		acc.setScene(scene);
		
		acc.setMaximized(true);
		
		acc.show();
    }

}
