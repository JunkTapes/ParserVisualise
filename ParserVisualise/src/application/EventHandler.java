package application;
import javafx.fxml.FXML;
import application.MyApp;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;
import application.SentenceLoader;

public class EventHandler {
	private MyApp Interface;
	public EventHandler(){}
	@FXML
	private Button StartButton;
	@FXML
	private TextArea InputTextArea;
	@FXML
	private AnchorPane Pane;
	@FXML
	private GridPane gridPane;
	@FXML
	public void OnButtonPress()
	{	
		InputTextArea.setPrefHeight(50);
		InputTextArea.setPrefWidth(Pane.getWidth()-150);
		InputTextArea.setLayoutX(120);
		StartButton.setLayoutX(10); 
		StartButton.setLayoutY(10);
		gridPane.setHgap(10);
	    gridPane.setVgap(10);
	    gridPane.setLayoutY(120);
	    gridPane.setLayoutX(10);
		SentenceLoader.LoadSentence(InputTextArea,gridPane,Pane);
	}
	
	public void setMainApp(MyApp Interface) {

		this.Interface = Interface;
	}
	

}
