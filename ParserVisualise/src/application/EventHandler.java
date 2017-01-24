package application;

import javafx.fxml.FXML;
import javafx.geometry.Insets;

import com.sun.javafx.geom.Point2D;

import application.MyApp;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.shape.Line;
import application.SentenceLoader;

public class EventHandler {
	private MyApp Interface;

	public EventHandler() {
	}

	@FXML
	private Button StartButton;
	@FXML
	private Button DependencyButton;
	@FXML
	private TextArea InputTextArea;
	@FXML
	private AnchorPane Pane;
	@FXML
	private GridPane gridPane;

	@FXML
	public void OnButtonPress() {
		InputTextArea.setPrefHeight(50);
		InputTextArea.setPrefWidth(Pane.getWidth() - 150);
		InputTextArea.setLayoutX(120);
		StartButton.setLayoutX(10);
		StartButton.setLayoutY(10);
		gridPane.setHgap(20);
		gridPane.setVgap(20);
		gridPane.setLayoutY(100);
		gridPane.setLayoutX(20);
		gridPane.setPadding(new Insets(25, 25, 25, 25));
		gridPane.setMinWidth(Pane.getWidth()-150);
		SentenceLoader.LoadSentence(InputTextArea, gridPane);

	}

	@FXML
	public void OnDependencyButtonPress() {
		System.out.println(gridPane.getChildren());
		
		for (int i = 0; i < (gridPane.getChildren().size()) / 2; i++) {
			System.out.println(gridPane.getChildren().get(i).localToScene(
					gridPane.getChildren().get(i).getLayoutBounds().getMinX(),
					gridPane.getChildren().get(i).getLayoutBounds().getMinY()));
			double startMinX= gridPane.getChildren().get(i).getLayoutBounds().getMinX();
			double startMinY= gridPane.getChildren().get(i).getLayoutBounds().getMinY();
			double getXofStart = gridPane.getChildren().get(i).localToScene(startMinX,startMinY).getX();
			double getYofStart = gridPane.getChildren().get(i).localToScene(startMinX,startMinY).getY();
			int dependency = Integer.parseInt((SentenceLoader.fromDependency.get(i)));
			double endMinX= gridPane.getChildren().get(dependency).getLayoutBounds().getMinX();
			double endMinY= gridPane.getChildren().get(dependency).getLayoutBounds().getMinY();
			double getXofEnd= gridPane.getChildren().get(dependency).localToScene(endMinX,endMinY).getX();
			double getYofEnd= gridPane.getChildren().get(dependency).localToScene(endMinX,endMinY).getY();
			
			addline(getXofEnd+(7*i), getYofEnd, getXofEnd+(7*i), getYofEnd-10-(10*i), false, Pane);
			addline(getXofEnd+(7*i),getYofEnd-10-(10*i),getXofStart+(7*i),getYofStart-10-(10*i),false,Pane);
			addline(getXofStart+(7*i),getYofStart-10-(10*i),getXofStart+(7*i),getYofStart,true,Pane);
			
		}


	}

	public void addline(double startX, double startY, double endX, double endY, boolean arrow, AnchorPane Pane) {
		Line line = new Line();
		line.setStartX(startX);
		line.setStartY(startY);
		line.setEndX(endX);
		line.setEndY(endY);
		if (arrow == true) {
			Line arrow1 = new Line();
			Line arrow2 = new Line();
			arrow1.setStartX(endX);
			arrow1.setStartY(endY);
			arrow1.setEndX(endX - 5);
			arrow1.setEndY(endY - 5);
			arrow2.setStartX(endX);
			arrow2.setStartY(endY);
			arrow2.setEndX(endX + 5);
			arrow2.setEndY(endY - 5);
			Pane.getChildren().add(arrow2);
			Pane.getChildren().add(arrow1);
		}
		Pane.getChildren().add(line);
	}

	public void setMainApp(MyApp Interface) {

		this.Interface = Interface;
	}

}
