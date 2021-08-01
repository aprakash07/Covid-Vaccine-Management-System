package application;
import java.sql.*;

import DBConnection.DBHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AvailabilityController {
	
	@FXML
    private Label cova1st;

    @FXML
    private Label covi1st;

    @FXML
    private Label cova2nd;

    @FXML
    private Label covi2nd;
    
    private Connection connection;
	 private DBHandler handler;
	 private PreparedStatement pst,pst2;
    
    @FXML
    private void initialize() throws ClassNotFoundException, SQLException {
    	handler=new DBHandler();
    	String qry="SELECT * FROM STOCK WHERE TYPE='Covaxine'";
    	String qry2="SELECT * FROM STOCK WHERE TYPE='Covishield'";
    	connection = handler.getConnection();
    	pst=connection.prepareStatement(qry);
    	pst2=connection.prepareStatement(qry2);
    	ResultSet resultSet=pst.executeQuery();
    	if(resultSet.next()) {
    	cova1st.setText(resultSet.getString("1stdoseavailable"));
    	cova2nd.setText(resultSet.getString("2nddoseavailable"));
    }
    	resultSet=pst2.executeQuery();
    	if(resultSet.next()) {
        	covi1st.setText(resultSet.getString("1stdoseavailable"));
        	covi2nd.setText(resultSet.getString("2nddoseavailable"));
        }
    	
    }
    

}
