package application;
import java.util.*;

import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;

public class SentenceLoader {
	
	static ArrayList<String> tokens= new ArrayList<String>();
	static ArrayList<String> edges= new ArrayList<String>();
	static ArrayList<String> fromDependency= new ArrayList<String>();
	static ArrayList<String> dependencies= new ArrayList<String>();
	
	static void ClearArrayList(){
		tokens.clear();
		edges.clear();
		fromDependency.clear();
		dependencies.clear();
	}
	
	static void GetSentenceToArrayList(TextArea inputTextArea2){
		String input = inputTextArea2.getText();
		String[] splited = input.split("\\s+");
		ClearArrayList();
		
		for (int i=0; i<splited.length;i+=4)
			tokens.add(splited[i]);		
		for(int i=1; i<splited.length;i+=4)
			edges.add(splited[i]);
		for(int i=2; i<splited.length;i+=4)
			fromDependency.add(splited[i]);
		for(int i=3; i<splited.length;i+=4)
			dependencies.add(splited[i]);
		
	}

	static void LoadSentence(TextArea inputTextArea2, GridPane gridPane,AnchorPane Pane) {
		GetSentenceToArrayList(inputTextArea2);
		gridPane.getChildren().clear();
		Label[] labelTokens = new Label[tokens.size()];
		Label[] labelEdges= new Label [edges.size()];
		
		for (int i = 0; i <= tokens.size()-1; i++) {
			 labelTokens[i] = new Label();
			 labelEdges[i] = new Label();
			 labelTokens[i].setText(tokens.get(i));
			 labelEdges[i].setText(edges.get(i));
			}
		gridPane.addRow(1, labelTokens);
		gridPane.addRow(2, labelEdges);

		//Cant reach coordinates of children of gridPane, or labels
		Bounds boundsInScene = gridPane.getChildren().get(1).localToScene(gridPane.getChildren().get(1).getBoundsInLocal());
		System.out.println(boundsInScene);
		System.out.println(gridPane.getChildren());
		System.out.println(gridPane.localToScene(labelTokens[1].getLayoutX(), labelTokens[1].getLayoutY()));	
		System.out.println(gridPane.getLayoutX());	
		System.out.println(gridPane.getLayoutY());	
		System.out.println(gridPane.getChildren().get(1).getLayoutX());
		System.out.println(gridPane.getChildren().get(1).getLayoutY());
		
//		int i=0;
//		 	//labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutX();
//			// (-10) should be level dependent!
//		
//			line.setStartX(labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutX());
//			line.setStartY(labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutY());
//			line.setEndX(labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutX());
//			line.setEndY((labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutY())-10);
//			
//			line2.setStartX(labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutX());
//			line2.setStartY((labelTokens[Integer.parseInt((fromDependency.get(i)))].getLayoutY())-10);
//			line2.setEndX(labelTokens[i].getLayoutX());
//			line2.setEndY((labelTokens[i].getLayoutY())-10);
//			
//			line3.setStartX(labelTokens[i].getLayoutX());
//			line3.setStartY(labelTokens[i].getLayoutY());
//			line3.setEndX(labelTokens[i].getLayoutX());
//			line3.setEndY((labelTokens[i].getLayoutY())-10);
		
		
	}

		

}
