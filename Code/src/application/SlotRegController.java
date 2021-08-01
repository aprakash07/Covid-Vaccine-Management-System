package application;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import DBConnection.DBHandler;
import Module.Reg;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

public class SlotRegController {
	 @FXML
	    private Button btnHome;
	 @FXML
	    private Button btnAccount;

	 
	 @FXML
	    private Button btnupdate;
	 
	 @FXML
	    private Button btnlogout;

	 
	  @FXML
	    private TableView<Reg> regtable;
	 
	  @FXML
	    private TableColumn<Reg, SimpleIntegerProperty> colbookid;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> colname;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> colgender;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> coldob;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> coltype;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> col1st;

	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> col2nd;
	    
	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> col1stdose;
	    
	    @FXML
	    private TableColumn<Reg, SimpleStringProperty> col2nddose;

	    

	    final ObservableList<Reg> regdetail = FXCollections.observableArrayList();
	 
	    private Connection connection;
	    private DBHandler handler;
	    private PreparedStatement pst;
	    
	    
	    @FXML
	    public void initialize() throws ClassNotFoundException, SQLException {
	    	
	    	regtable.setEditable(true);
	    	regdetail.clear();
	    	handler=new DBHandler();
	    	String qry="SELECT * FROM SLOTBOOKING";
	    	connection = handler.getConnection();
	    	pst=connection.prepareStatement(qry);
	    	ResultSet resultSet= pst.executeQuery();
	    	
	    	colbookid.setCellValueFactory(new PropertyValueFactory<Reg, SimpleIntegerProperty>("id"));
	    	colname.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("name"));
	    	colgender.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("gender"));
	    	coldob.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("dob"));
	    	coltype.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("type"));
	    	col1st.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("dose1"));
	    	col2nd.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("dose2"));
	    	col1stdose.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("dose1taken"));
	    	col2nddose.setCellValueFactory(new PropertyValueFactory<Reg,SimpleStringProperty>("dose2taken"));
	    	
	    	
	    	
	    	
	    	 SimpleDateFormat sdfr = new SimpleDateFormat("yyyy-mm-dd");
	    	
	    	 
	    	 while (resultSet.next()) {
	    	    
	    		 if(resultSet.getDate("2nddosedate")==null) {
	    			 regdetail.add(new Reg(
	 	    				resultSet.getInt("bookid"),
	 	    				resultSet.getString("name"),
	 	    				resultSet.getString("gender"),
	 	    				resultSet.getString("vaccine"),
	 	    				sdfr.format(resultSet.getDate("1stslotdate")),
	 	    				"Not registered",
	 	    				sdfr.format(resultSet.getDate("dob")),
	 	    				resultSet.getString("1stdose"),
	 	    				resultSet.getString("2nddose")
	 	    				));
	    		 }
	    		 else {
	    		regdetail.add(new Reg(
	    				resultSet.getInt("bookid"),
	    				resultSet.getString("name"),
	    				resultSet.getString("gender"),
	    				resultSet.getString("vaccine"),
	    				sdfr.format(resultSet.getDate("1stslotdate")),
	    				sdfr.format(resultSet.getDate("2nddosedate")),
	    				sdfr.format(resultSet.getDate("dob")),
	    				resultSet.getString("1stdose"),
 	    				resultSet.getString("2nddose")
	    				));
	    		 }
	    	
	    	}
	    	
	    	
	    	
	    	regtable.setItems(regdetail);
	    	
	    }
	 
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
	    
	    static String id, vaccine;
	    @FXML
	    void update(ActionEvent event) throws IOException {
	    	Reg detail= regtable.getSelectionModel().getSelectedItem();
	    	id= String.valueOf(detail.getId());
	    	vaccine= detail.getType();
	    	Stage acc = new Stage();
	    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/ViewPatient.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			acc.setScene(scene);
			
			acc.setResizable(false);
			
			acc.show();
	    }
	    
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
	    
}
