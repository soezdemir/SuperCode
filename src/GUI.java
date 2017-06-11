
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.geometry.*;
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
        Button starten = new Button();
        HBox hbStarten = new HBox(10);
        hbStarten.setAlignment(Pos.CENTER);
        hbStarten.getChildren().add(starten);
        starten.setText("Starte Spiel");
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

        GridPane wurzel = new GridPane();
        wurzel.setAlignment(Pos.CENTER);
        wurzel.setPadding(new Insets(25));
        primaerStage.setScene(new Scene(wurzel,1280,720));
        wurzel.add(hbStarten,0,0);
        wurzel.add(hbBeenden, 0,1);
        primaerStage.show();
    }
    public void zeichneSpielbrett()
    {
        Stage aktuelleStage = new Stage();
        Image imageRot = new Image(getClass().getResourceAsStream("rot.jpg"));
        Button rot = new Button();
        rot.setGraphic(new ImageView((imageRot)));
        HBox hbRot = new HBox(10);
        hbRot.setAlignment(Pos.BOTTOM_LEFT);
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
        aktuelleStage.setScene((new Scene(grid, 1280, 720)));
        grid.add(hbRot, 0, 10);
        aktuelleStage.show();
    }
}