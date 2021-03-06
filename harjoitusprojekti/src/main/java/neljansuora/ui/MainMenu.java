
package neljansuora.ui;


import neljansuora.controller.Usercontrol;
import neljansuora.dao.FileUserDao;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static neljansuora.ui.NeljanSuoraUi.HEIGHT;
import static neljansuora.ui.NeljanSuoraUi.WIDTH;

/**
 * Represents the main menu view.
 */
public class MainMenu {
    
    private Usercontrol userControl;
    private FileUserDao fileUserDao;
    /**
     * Constructor
     * @param   userControl Usercontrol which was created at the start of the game.
     * @param   fileUserDao FileUserDao which was created at the start of the game.
     */
    public MainMenu (Usercontrol userControl, FileUserDao fileUserDao) {
        this.userControl = userControl;
        this.fileUserDao = fileUserDao;
    }
    
    /**
     * Displays the main menu -page.
     * @param   window  Stage shown to user.
     */
    public void display(Stage window) {
        
        // create main layout
        VBox layout = new VBox(20);
        layout.setPrefSize(WIDTH, HEIGHT);
        layout.setStyle("-fx-background-color: white");
        layout.setAlignment(Pos.CENTER);
        
        // ..and its components
        
        Label label = new Label("Neljän suora");
        label.setTextFill(Color.BLACK);
        label.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
        
        Button playButton = new Button("Play");
        playButton.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-font-size: 15pt;");
        
        Button rulesButton = new Button("Rules");
        rulesButton.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-font-size: 15pt;");
        
        Button statsButton = new Button("Statistics");
        statsButton.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-font-size: 15pt;");
        
        Button quitButton = new Button("Quit");
        quitButton.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-font-size: 15pt;");
        
        Button logoutButton = new Button("Logout");
        logoutButton.setStyle("-fx-background-color: white;-fx-text-fill: black;-fx-font-size: 15pt;");
        
        // add components into layout
        layout.getChildren().addAll(label, playButton, rulesButton, statsButton, logoutButton, quitButton);

        Scene menuScene = new Scene(layout);
        
        
        // add functionality to buttons
        playButton.setOnAction(event -> {
            Game game = new Game(this.userControl, this.fileUserDao, menuScene);
            try {
                 game.displayPreGameStage(window);
            } catch (Exception e) {
                
            }
        });
        
        rulesButton.setOnAction(event -> {
            Rules rules = new Rules(this.userControl, this.fileUserDao, menuScene);
            try {
                 rules.display(window);
            } catch (Exception e) {

            }
        });
        
        statsButton.setOnAction(event -> {
            Statistics stats = new Statistics(this.userControl, this.fileUserDao, menuScene);
            try {
                 stats.display(window);
            } catch (Exception e) {

            }
        });
        
        logoutButton.setOnAction(event -> {
        this.userControl.logOut();
        Login login = new Login(this.userControl, this.fileUserDao);
            try {
                 login.display(window);
            } catch (Exception e) {

            }
        });
        
        quitButton.setOnAction(event -> {
            window.close();
        });
        
        // add scene to stage
        
        window.setScene(menuScene);
        window.setTitle("Neljän suora");
        window.show();
    }

}
