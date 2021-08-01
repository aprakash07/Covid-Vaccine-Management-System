package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			File file = new File("../CovidVaccineManagementSystem/src/application/info.txt");
			
			if(file.exists()){	
				
				BufferedReader br= new BufferedReader(new FileReader("../CovidVaccineManagementSystem/src/application/info.txt"));
	    		LoginController.userid=(Integer.parseInt(br.readLine()));
	    		System.out.println((char)br.read());
	    		br.close();
				Parent root= FXMLLoader.load(getClass().getResource("/FXML/Home.fxml"));
				Scene scene = new Scene(root);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.setMaximized(true);
				primaryStage.show();
			}
			else {	
			Parent root= FXMLLoader.load(getClass().getResource("/FXML/LoginMain.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
