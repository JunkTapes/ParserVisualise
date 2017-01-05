package application;
import javafx.fxml.FXML;
import application.MyApp;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
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
	public void OnButtonPress()
	{	
		InputTextArea.setDisable(true);
		InputTextArea.setPrefHeight(50);
		InputTextArea.setPrefWidth(Pane.getWidth()-150);
		InputTextArea.setLayoutX(120);
		StartButton.setLayoutX(10); 
		StartButton.setLayoutY(10);
		GridPane gridPane = addGridPane();
		Pane.getChildren().add(gridPane);

		SentenceLoader.LoadSentence(InputTextArea,gridPane);

	}
	
	public GridPane addGridPane() {
	    GridPane grid = new GridPane();
	    grid.setHgap(10);
	    grid.setVgap(10);
	    grid.setLayoutY(100);
	    grid.setLayoutX(10);
	    
	    return grid;
	}
	
	//ƒанные всегда правильные, их провер€ть не нужно
	
	public void setMainApp(MyApp Interface) {

		this.Interface = Interface;
	}
	

}
