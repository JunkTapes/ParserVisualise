package application;
import javafx.fxml.FXML;
import application.MyApp;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import application.SentenceLoader;

public class EventHandler {
	private MyApp Interface;
	
	public EventHandler(){}
	
	//@FXML
	//private HBox hbox;
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
		HBox hbox = addHBox();
		Pane.getChildren().add(hbox);
		LoadSentence(InputTextArea,hbox);
		
		/*if((words[0].getLayoutX()+words[1].getLayoutX())<70){
			Pane.setPrefWidth((Pane.getWidth()+((70-(words[0].getLayoutX()+words[1].getLayoutX()))*NumberOfWords)));
		}*/
		
	}
	
	public HBox addHBox() {
	    HBox hbox = new HBox(10);
	    
	    hbox.setLayoutX(10);
		hbox.setLayoutY(100);
	    hbox.setSpacing(10);
	    //hbox.setStyle("-fx-background-color: #336699;");
	    hbox.setPrefWidth(Pane.getWidth());
	    hbox.setPrefHeight(Pane.getHeight());
	    return hbox;
	}
	
	private void LoadSentence(TextArea inputTextArea2, HBox hbox) {
		String input = inputTextArea2.getText();
		String[] splited = input.split("\\s+");
		String[] justwords= new String[(splited.length/3 )+ 1];
		String[] justedges= new String[(splited.length/3 )+ 1];
		String[] justedges2= new String[(splited.length/3 )+ 1];
		int j=0;
		for (int i = 0; i<splited.length; i+=3)
		{
			justwords[j]=splited[i];
			j++;
		}	
		j=0;
		for(int i=1;i<splited.length;i+=3)
		{
			justedges[j]=splited[i];
			j++;
		}
		j=0;
		for(int i=1;i<splited.length;i+=3)
		{
			justedges2[j]=splited[i];
			j++;
		}
				
		Label[] words = new Label[justwords.length];
		Label[] edges= new Label [justedges.length];
		for (int i = 0; i <= justwords.length-1; i++) {
			 words[i] = new Label();
			 edges[i] = new Label();
			
			 words[i].setText(justwords[i]);

			 edges[i].setText(justedges[i]);
			}
		
		//hbox.getChildren().addAll(words);
		
		for(int i=0;i<justwords.length;i++)
		{	
			hbox.getChildren().add(words[i]);
			//hbox.getChildren().add
			System.out.println(justwords[i]);
		}
				
	}

	public void setMainApp(MyApp Interface) {

		this.Interface = Interface;
	}
	

}
