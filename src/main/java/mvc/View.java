package mvc;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.IOUtil;

public class View extends Application{
	
	public static final String APPLICATION_VIEW = "AngleFind.fxml";
	
    public static void main(String[] args)
    {
		Application.launch(args);
    }
	@Override
	public void start(Stage stage) throws Exception {
		URL fileURL = IOUtil.getFileInClassPath(APPLICATION_VIEW);
		Parent root = FXMLLoader.load(fileURL);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();		
	}

}
