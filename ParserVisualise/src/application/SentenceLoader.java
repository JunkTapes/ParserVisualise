package application;
import java.util.*;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class SentenceLoader {

	static void LoadSentence(TextArea inputTextArea2, GridPane gridPane) {
		//нужна отдельная функция по записи текста в arrayListы
		String input = inputTextArea2.getText();
		String[] splited = input.split("\\s+");
		ArrayList<String> tokens= new ArrayList<String>();
		ArrayList<String> edges= new ArrayList<String>();
		ArrayList<String> fromDependency= new ArrayList<String>();
		ArrayList<String> dependencies= new ArrayList<String>();
		
		for (int i=0; i<splited.length;i+=4)
			tokens.add(splited[i]);		
		for(int i=1; i<splited.length;i+=4)
			edges.add(splited[i]);
		for(int i=2; i<splited.length;i+=4)
			fromDependency.add(splited[i]);
		for(int i=3; i<splited.length;i+=4)
			dependencies.add(splited[i]);
			
		//нужно уничтожать все уже нарисованное в случае повторного нажатия клавиши
		
		Label[] labelTokens = new Label[tokens.size()];
		Label[] labelEdges= new Label [edges.size()];
		Label[] labelFromDependency = new Label [fromDependency.size()];
		Label[] labeldependencies = new Label [dependencies.size()];
		for (int i = 0; i <= tokens.size()-1; i++) {
			 labelTokens[i] = new Label();
			 labelEdges[i] = new Label();
			 labelFromDependency[i]= new Label();
			 labeldependencies[i]= new Label();
			 labelTokens[i].setText(tokens.get(i));
			 labelEdges[i].setText(edges.get(i));
			 labelFromDependency[i].setText(fromDependency.get(i));
			 labeldependencies[i].setText(dependencies.get(i));
			}
		
		gridPane.addRow(1, labelTokens);
		gridPane.addRow(2, labelEdges);
		gridPane.addRow(3,labelFromDependency);
		gridPane.addRow(4,labeldependencies);

		for(int i=0;i<tokens.size();i++)
		{	
			System.out.println(tokens.get(i));
		}
				
	}


}
