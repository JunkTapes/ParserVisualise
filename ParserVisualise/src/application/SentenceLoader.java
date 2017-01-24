package application;
import java.util.*;

import javafx.geometry.Bounds;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
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

	static void LoadSentence(TextArea inputTextArea2, GridPane gridPane) {
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
		
		for (int j = 0; j < tokens.size(); j++) {
		    ColumnConstraints cc = new ColumnConstraints();
		    cc.setHgrow(Priority.ALWAYS);
		    gridPane.getColumnConstraints().add(cc);
		}
	}

		

}
