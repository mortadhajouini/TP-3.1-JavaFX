package application;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;



public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group ();
		
		Scene scene = new Scene (root, 300, 300, Color.WHITE);
		
		ObservableList<Node> liste = root.getChildren();
		
		
		/*
		Rectangle rec = new Rectangle (0,0,100,102);
		
		Line lin = new Line (12,0,12,12);
		
		Circle cer = new Circle (150,120,120);
		
		liste.add(cer);*/
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(50));
		Text scenetitle = new Text ("Welcome");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		TextField userTextField = new TextField();
		grid.add(userTextField, 1, 1);
		Label pw =  new Label ("Password : ");
		grid.add(pw, 0, 2);
		PasswordField pwBox = new PasswordField ();
		grid.add(pwBox, 1, 2);
		
		Button btn = new Button("Sign in");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btn);
		grid.add(hbBtn, 1, 4);
		
		Text actiontarget = new Text("");
		grid.add(actiontarget, 1, 6);
		
		btn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				if (!pwBox.getText().equals("123")) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Password invalid ! ");
				}
				else {
					actiontarget.setFill(Color.GREEN);
					actiontarget.setText("Password Correct ! ");
				}
				
			}
		});
		
		Button btne = new Button("Exit");
		btne.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent e) {
				Platform.exit();
			}
		});
		
		hbBtn.getChildren().add(btne);
		
		root.getChildren().add(grid);
		
		
		primaryStage.setTitle("JavaFX Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
