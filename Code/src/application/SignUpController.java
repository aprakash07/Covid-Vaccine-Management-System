package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import DBConnection.DBHandler;
public class SignUpController {
	ObservableList<String> roleList= FXCollections.observableArrayList("Regular Login","Admin");
	
	@FXML
    private Button login;
	
	@FXML
    private Button signUp;

    @FXML
    private TextField name;

    @FXML
    private TextField uname;

    @FXML
    private TextField pass;

    @FXML
    private TextField address;

    @FXML
    private RadioButton chmale;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton chfemale;

    @FXML
    private ChoiceBox<String> role;
    
    @FXML
    private void initialize(){
    	role.setItems(roleList);
    	role.setValue("Regular Login");
    }

    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
    
    @FXML
    void loginAction(ActionEvent event) throws IOException {
    	signUp.getScene().getWindow().hide();
    	Stage login = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		login.setScene(scene);
		login.setResizable(false);
		login.show();
    }

    @FXML
    void signUpAction(ActionEvent event) throws ClassNotFoundException, SQLException, IOException {
    	handler=new DBHandler();
    	String insert="INSERT INTO USERS(NAME,USERNAME,PASSWORD,GENDER, ADDRESS, ROLE)"+ "VALUES(?,?,?,?,?,?)";
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(insert);
    	pst.setString(1, name.getText());
    	pst.setString(2, uname.getText());
    	pst.setString(3, pass.getText());
    	
    	if(chmale.isSelected())
    		pst.setString(4, "Male");
    	else if(chfemale.isSelected())
    		pst.setString(4, "Female");
    	else
    		pst.setString(4, "Null");
    	
    	pst.setString(5, address.getText());
    	
    	String rl=""+(String)role.getValue();
		pst.setString(6, rl);
		
    	pst.executeUpdate();
    	
    	signUp.getScene().getWindow().hide();
    	Stage login = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
		Scene scene = new Scene(root);
		Alert a1= new Alert(Alert.AlertType.INFORMATION);
		a1.setContentText("New User Registratered Successfully");
		a1.setHeaderText(null);
		
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		login.setScene(scene);
		login.setResizable(false);
		login.show();
		a1.showAndWait();
    	
    			
    }
}
