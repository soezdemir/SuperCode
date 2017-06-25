package GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;

public class GUI extends Application
{
	public GUI(){}
    public static void main(String[] args)
    {
        launch(args);
    }
    @Override
    public void start(Stage stage)throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("stages/startbild.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public Stage ladeMastermindSetzen(Stage stage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/mastermindSetzen.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }

    public Stage ladeZwischenMasterStage(Stage stage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/zwischenMaster.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }

    public Stage ladeZwischenVersuchStage(Stage stage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/zwischenVersuch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }

    public Stage ladeMastermindSignal(Stage stage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/masterSignal.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }

    public Stage ladeVersuchStage(Stage stage)throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/versuch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }
    
    public Stage ladeSiegStage(Stage stage)throws Exception
    {
    	Parent root = FXMLLoader.load(getClass().getResource("stages/sieg.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        return stage;
    }
        /*BackgroundImage background = new BackgroundImage(new Image("/graphics/menu/MasterMindStartbild_2.png",
                1280,720,true,true), BackgroundRepeat.valueOf("NO_REPEAT"),
                BackgroundRepeat.valueOf("NO_REPEAT"),BackgroundPosition.CENTER,new BackgroundSize(1280,720,
                false,false,true,false));
        BackgroundImage background1 = new BackgroundImage(new Image("/graphics/buttons/MenuStartButton.png",
                180,70,true,true), BackgroundRepeat.valueOf("NO_REPEAT"),
                BackgroundRepeat.valueOf("NO_REPEAT"),BackgroundPosition.CENTER,new BackgroundSize(360,140,
                false,false,true,false));
        Button starten = new Button();
        HBox hbStarten = new HBox(100);
        hbStarten.setAlignment(Pos.BOTTOM_LEFT);
        hbStarten.getChildren().add(starten);
        /*Image imageStart = new Image("/graphics/buttons/MenuStartButton.png",
                360,140,true,true);
        ImageView imageView = new ImageView(imageStart);
        imageView.setFitHeight(140);imageView.setFitWidth(360);
        starten.setBackground(new Background(background1));
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
        starten.setMinWidth(180);starten.setMinHeight(70);beenden.setMinHeight(140);beenden.setMinWidth(360);
        //TODO hintergrund von Startbutton
        primaerStage.setScene(new Scene(wurzel,1280,720));
        primaerStage.show();
    }
    public void zeichneSpielbrett()
    {
        BackgroundImage background = new BackgroundImage(new Image("/graphics/spielbrett/Spielbrett_1.png",
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
    }*/
}