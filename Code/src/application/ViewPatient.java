package application;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ViewPatient {
	@FXML
    private Label txtname;

    @FXML
    private Label txtgender;

    @FXML
    private Label txtdob;

    @FXML
    private Label txtaadhar;

    @FXML
    private Label txtregslot;

    @FXML
    private Label txttype;

    @FXML
    private CheckBox first;

    @FXML
    private CheckBox second;

    @FXML
    private Button btnupdate;

    @FXML
    private Label txt2nddose;

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
    	handler=new DBHandler();
    	connection = handler.getConnection();
    	String qry1="update slotbooking set 1stdose='Taken' where bookid="+SlotRegController.id;
    	String qry2="update slotbooking set 2nddose='Taken' where bookid="+SlotRegController.id;
    	System.out.println(SlotRegController.vaccine);
    	if(SlotRegController.vaccine.equals("Covaxine")) {
    		System.out.println("1st");
    	String qry ="Select * from stock where type='Covaxine'";
    	pst=connection.prepareStatement(qry);
    	ResultSet resultSet=pst.executeQuery();
    	if(resultSet.next()) {
    		
    		if(first.isSelected()) {
    			
    			if(resultSet.getInt("1stdoseavailable")>1) {
    	    		int avail= resultSet.getInt("1stdoseavailable")-1;
    	    		int used=resultSet.getInt("1stdoseused")+1;
    	    		qry="Update stock set 1stdoseavailable="+avail+", 1stdoseused="+used+" where type='Covaxine'";
    	    		pst=connection.prepareStatement(qry);
    	    		pst.executeUpdate();
    	    		System.out.println("1st");
    	    		pst=connection.prepareStatement(qry1);
    	    		pst.executeUpdate();
    	    		
    	    		Alert a1= new Alert(Alert.AlertType.INFORMATION);
    	    		a1.setContentText("Dose Given Successfully");
    	    		a1.setHeaderText(null);
    	    		a1.showAndWait();
    	    		btnupdate.getScene().getWindow().hide();
    			}
    			else {
    				Alert a1= new Alert(Alert.AlertType.INFORMATION);
    				a1.setContentText("Dose Not Available");
    				a1.setHeaderText(null);
    				a1.showAndWait();
    				btnupdate.getScene().getWindow().hide();
    			}
    		}
    		if(second.isSelected()) {
    			if(resultSet.getInt("2nddoseavailable")>1) {
    	    		int avail= resultSet.getInt("2nddoseavailable")-1;
    	    		int used=resultSet.getInt("2nddoseused")+1;
    	    		qry="Update stock set 2nddoseavailable="+avail+", 2nddoseused="+used+" where type='Covaxine'";
    	    		pst=connection.prepareStatement(qry);
    	    		pst.executeUpdate();
    	    		pst=connection.prepareStatement(qry2);
    	    		pst.executeUpdate();
    	    		
    	    		Alert a1= new Alert(Alert.AlertType.INFORMATION);
    	    		a1.setContentText("Dose Given Successfully");
    	    		a1.setHeaderText(null);
    	    		a1.showAndWait();
    	    		btnupdate.getScene().getWindow().hide();
    			}
    			else {
    				Alert a1= new Alert(Alert.AlertType.INFORMATION);
    				a1.setContentText("Dose Not Available");
    				a1.setHeaderText(null);
    				a1.showAndWait();
    				btnupdate.getScene().getWindow().hide();
    			}
    			
    		}
    	}
    	
    	}
    	
    	
    	if(SlotRegController.vaccine=="Covishield") {
        	String qry ="Select * from stock where type='Covishield'";
        	pst=connection.prepareStatement(qry);
        	ResultSet resultSet=pst.executeQuery();
        	if(resultSet.next()) {
        		
        		if(first.isSelected()) {
        			
        			if(resultSet.getInt("1stdoseavailable")>1) {
        	    		int avail= resultSet.getInt("1stdoseavailable")-1;
        	    		int used=resultSet.getInt("1stdoseused")+1;
        	    		qry="Update stock set 1stdoseavailable="+avail+", 1stdoseused="+used+" where type='Covishield'";
        	    		pst=connection.prepareStatement(qry);
        	    		pst.executeUpdate();
        	    		pst=connection.prepareStatement(qry1);
        	    		pst.executeUpdate();
        	    		
        	    		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        	    		a1.setContentText("Dose Given Successfully");
        	    		a1.setHeaderText(null);
        	    		a1.showAndWait();
        	    		btnupdate.getScene().getWindow().hide();
        			}
        			else {
        				Alert a1= new Alert(Alert.AlertType.INFORMATION);
        				a1.setContentText("Dose Not Available");
        				a1.setHeaderText(null);
        				a1.showAndWait();
        				btnupdate.getScene().getWindow().hide();
        			}
        		}
        		if(second.isSelected()) {
        			if(resultSet.getInt("2nddoseavailable")>1) {
        	    		int avail= resultSet.getInt("2nddoseavailable")-1;
        	    		int used=resultSet.getInt("2nddoseused")+1;
        	    		qry="Update stock set 2nddoseavailable="+avail+", 2nddoseused="+used+" where type='Covishield'";
        	    		pst=connection.prepareStatement(qry);
        	    		pst.executeUpdate();
        	    		pst=connection.prepareStatement(qry2);
        	    		pst.executeUpdate();
        	    		
        	    		Alert a1= new Alert(Alert.AlertType.INFORMATION);
        	    		a1.setContentText("Dose Given Successfully");
        	    		a1.setHeaderText(null);
        	    		a1.showAndWait();
        	    		btnupdate.getScene().getWindow().hide();
        			}
        			else {
        				Alert a1= new Alert(Alert.AlertType.INFORMATION);
        				a1.setContentText("Dose Not Available");
        				a1.setHeaderText(null);
        				a1.showAndWait();
        				btnupdate.getScene().getWindow().hide();
        			}
        			
        		}
        	}
        	
        	}
    	
    	btnupdate.getScene().getWindow().hide();
    	Stage RS = new Stage();
    	Parent root= FXMLLoader.load(getClass().getResource("/FXML/RegisteredSlot.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		RS.setScene(scene);
		
		RS.setMaximized(true);
		
		RS.show();
    	
    }
    
    
    private Connection connection;
    private DBHandler handler;
    private PreparedStatement pst;
    
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
    	handler=new DBHandler();
    	String qry="SELECT * FROM SLOTBOOKING WHERE BOOKID="+SlotRegController.id;
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(qry);
    	ResultSet resultSet=pst.executeQuery();
    	if(resultSet.next()) {
    	txtname.setText(resultSet.getString("name"));
    	txtgender.setText(resultSet.getString("gender"));
    	txtdob.setText(resultSet.getString("dob"));
    	txtaadhar.setText(resultSet.getString("aadhar"));
    	txtregslot.setText(resultSet.getString("1stSlotDate"));
    	txttype.setText(resultSet.getString("vaccine"));
    	txt2nddose.setText(resultSet.getString("2ndDoseDate"));
    	if(resultSet.getString("2ndDoseDate")==null)
    		txt2nddose.setText("Not taken Yet");
    	if(resultSet.getString("1stdose").equals("Taken"))
    		first.setSelected(true);
    	if(resultSet.getString("2nddose").equals("Taken"))
    		second.setSelected(true);
    		
    	}
    	
    	
    	
    	
    	
    }
    
}
