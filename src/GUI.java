
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.layout.BackgroundRepeat;
import javafx.stage.Stage;

public class GUI extends Application
{
    private MasterMind mastermind;

    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage primaerStage)
    {
        primaerStage.setTitle("Master Mind");

        BackgroundImage background = new BackgroundImage(new Image("/graphics/menu/MasterMindStartbild_2.png",
                1280,720,true,true), BackgroundRepeat.valueOf("NO_REPEAT"),
                BackgroundRepeat.valueOf("NO_REPEAT"),BackgroundPosition.CENTER,new BackgroundSize(1280,720,
                false,false,true,false));
        Button starten = new Button();
        HBox hbStarten = new HBox(100);
        hbStarten.setAlignment(Pos.BOTTOM_LEFT);
        hbStarten.getChildren().add(starten);
        starten.setText("Start");
        starten.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                mastermind = new MasterMind();
                primaerStage.close();
            }
        });

        Button beenden = new Button();
        beenden.setText("Beenden");
        HBox hbBeenden = new HBox(10);
        hbBeenden.setAlignment(Pos.CENTER);
        hbBeenden.getChildren().add(beenden);
        beenden.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                System.exit(0);
            }
        });

        Pane wurzel = new Pane();
        wurzel.setPadding(new Insets(25));
        wurzel.setBackground(new Background(background));
        wurzel.getChildren().add(starten);
        wurzel.getChildren().add(beenden);
        starten.setLayoutX(215);beenden.setLayoutX(700);starten.setLayoutY(560);beenden.setLayoutY(560);
        starten.setMinWidth(360);starten.setMinHeight(140);beenden.setMinHeight(140);beenden.setMinWidth(360);
        //TODO hintergrund von Startbutton
        primaerStage.setScene(new Scene(wurzel,1280,720));
        primaerStage.show();
    }
    public void zeichneSpielbrett()
    {
        BackgroundImage background = new BackgroundImage(new Image("../graphics/spielbrett/Spielbrett_1.png",
                1280,720,true,true), BackgroundRepeat.valueOf("NO_REPEAT"),
                BackgroundRepeat.valueOf("NO_REPEAT"),BackgroundPosition.CENTER,new BackgroundSize(1280,720,
                false,false,true,false));
        Stage aktuelleStage = new Stage();
        Image imageRot = new Image("Spielfigur_rot.png",
                10,10,true,true);
        Button rot = new Button();
        rot.setGraphic(new ImageView((imageRot)));
        HBox hbRot = new HBox(10);
        hbRot.setAlignment(Pos.CENTER);
        hbRot.getChildren().add(rot);
        rot.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                mastermind.setFarbe(Spielfigur.ROT);
            }
        });
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(25));
        grid.setBackground(new Background(background));
        aktuelleStage.setScene((new Scene(grid, 1280, 720)));
        grid.add(hbRot, 0, 10);
        aktuelleStage.show();
    }
}