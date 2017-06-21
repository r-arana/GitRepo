package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.User;


/**
 * Created by Rene on 6/3/2017.
 */
public class LoggedInJavaFXView{


    public void loggedInJavaFXView(User currentUser) throws Exception {
        Stage createLoggedInStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("LoggedIn.fxml"));
        createLoggedInStage.setTitle("Welcome.");
        createLoggedInStage.setScene(new Scene(root, 700, 500));
        createLoggedInStage.show();

        System.out.print(currentUser.toString());
    }

}
