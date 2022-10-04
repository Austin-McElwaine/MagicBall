import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import java.util.Random;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import javafx.scene.control.TextField;

public class MagicBall extends Application
{
	private Image img;
	private TextField Question;
	private ImageView view;
	private Button button;
	private Group ball;
	private Label Answer;
	private ArrayList<String> AwnserA = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws IOException
	{
	  img = new Image("File:8Ball.JPG");
	  view = new ImageView(img);
	  button = new Button();
	  Answer = new Label();
	  button.setOnAction(new ButtonClickHandler());
	  ball = new Group(button);
	  Question = new TextField("Enter your question here");
	  Question.setMinWidth(100);
	  Question.setMaxWidth(300);
	  Question.setMinHeight(100);
	  Question.setMaxHeight(200);
      view.setFitHeight(300);
      view.setPreserveRatio(true);
      button.setPrefSize(80, 80);
      button.setGraphic(view);
	  VBox vbox = new VBox(10, ball, Question, Answer);
	  vbox.setAlignment(Pos.CENTER);
      Scene scene = new Scene(vbox, 720, 720);
      primaryStage.setTitle("8Ball");
      primaryStage.setScene(scene);
      primaryStage.show();
	  File file = new File("answers.txt");
	  Scanner inputFile1 = new Scanner(file);
	  String Awnser = "";
	  while(inputFile1.hasNext())
		{
			Awnser = inputFile1.nextLine();
			AwnserA.add(Awnser);
		}
		int num = rng(16);
		inputFile1.close();
	}
	
	public static int rng(int num)
	{
		Random rand = new Random();
		int number = rand.nextInt(num);
		return number;
	}
	
	class ButtonClickHandler implements EventHandler<ActionEvent> 
	{
		@Override
		public void handle(ActionEvent event) 
		{
			int num = rng(16);
			Answer.setText(AwnserA.get(num));
		}
	}
}
