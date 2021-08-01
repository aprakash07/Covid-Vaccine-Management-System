package application;
import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

import DBConnection.DBHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

	@FXML
    private TextField uname;

    @FXML
    private PasswordField pass;

    @FXML
    private Button login;

    @FXML
    private Button signUp;
    
    @FXML
    private Label error;
    
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    public static String name; public static int userid;

    @FXML
    void loginAction(ActionEvent event) throws IOException, ClassNotFoundException, SQLException {
    	  	   	
    	
    	
    	handler=new DBHandler();
    	String qry="SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(qry);
    	pst.setString(1, uname.getText());
    	pst.setString(2, pass.getText());
    	ResultSet resultSet=pst.executeQuery();
    	
    	if(!resultSet.next()) {
    		error.setVisible(true);
    		
    	}
    	
    	
    	else {
    	name=resultSet.getString("name");
    	userid=resultSet.getInt("userid");
    	 	
    	
    	login.getScene().getWindow().hide();
    	Stage home = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		home.setScene(scene);
		
		home.setMaximized(true);
		
		home.show();
    	   	
     	
    	BufferedWriter w = new BufferedWriter(new FileWriter("../CovidVaccineManagementSystem/src/application/info.txt",true));
    	w.write(String.valueOf(userid));
    	w.close();
    	
    	System.out.println("written Successfully");
    	
    	}
    }

    @FXML
    void signUpAction(ActionEvent event) throws IOException {
    	login.getScene().getWindow().hide();
    	Stage signUp = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/SignUp.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		signUp.setScene(scene);
		signUp.setResizable(false);
		signUp.show();
    }

	
    
	
}
