package Module;

import java.io.IOException;
import java.sql.*;

import javafx.beans.property.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Reg {
	private IntegerProperty id;
	private StringProperty name, gender, type;
	private StringProperty dob, dose1, dose2, dose1taken, dose2taken;
	
	public int getId() {
		return id.get();
	}
	
	public String getName() {
		return name.get();
	}
	
	public String getGender() {
		return gender.get();
	}
	
	public String getType() {
		return type.get();
	}
	
	public String getDob() {
		return dob.get();
	}
	
	public String getDose1() {
		return dose1.get();
	}
	
	public String getDose2() {
		return dose2.get();
	}
	
	public String getDose1taken() {
		return dose1taken.get();
	}
	
	public String getDose2taken() {
		return dose2taken.get();
	}
	
	
	public void setId(int id) {
		this.id=new SimpleIntegerProperty(id);
	}
	
	public void setName(String name) {
		this.name=new SimpleStringProperty(name);
	}
	
	public void setGender(String gender) {
		this.gender=new SimpleStringProperty(gender);
	}
	
	public void setType(String type) {
		this.type=new SimpleStringProperty(type);
	}
	
	public void setDob(String dob) {
		this.dob=new SimpleStringProperty(dob);
	}
	
	public void setDose1(String dose1) {
		this.dose1=new SimpleStringProperty(dose1);
	}
	
	public void setDose2(String dose2) {
		this.dose2=new SimpleStringProperty(dose2);
	}
	
	public void setDose1taken(String dose1taken) {
		this.dose1taken=new SimpleStringProperty(dose1taken);
	}
	
	public void setDose2taken(String dose2taken) {
		this.dose2taken=new SimpleStringProperty(dose2taken);
	}
	
	public Reg(int id, String name, String gender, String type, String dose1, String dose2, String dob, String dose1taken, String dose2taken){
		this.id=new SimpleIntegerProperty(id);
		this.name=new SimpleStringProperty(name);
		this.gender=new SimpleStringProperty(gender);
		this.type=new SimpleStringProperty(type);
		this.dose1=new SimpleStringProperty(dose1);
		this.dose2=new SimpleStringProperty(dose2);
		this.dob=new SimpleStringProperty(dob);
		this.dose1taken= new SimpleStringProperty(dose1taken);
		this.dose2taken= new SimpleStringProperty(dose2taken);
		
		
		
	}
	
	        
		
}
