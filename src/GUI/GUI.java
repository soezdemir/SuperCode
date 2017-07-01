/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */

package GUI;

import com.sun.javafx.cursor.CursorType;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;

public class GUI extends Application
{
    public static final double BACKGROUNDBREITE = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final double BACKGROUNDHOEHE = Toolkit.getDefaultToolkit().getScreenSize().height;
    private static final double DISPLAYBREITE = 1024;
    private static final double VERSUCHHOEHE = 790;
    private static final double DISPLAYHOEHE = 768;
    private static final double QUOTIENTBREITE = BACKGROUNDBREITE/DISPLAYBREITE;
    private static final double QUOTIENTHOEHE = BACKGROUNDHOEHE/DISPLAYHOEHE;
    private static final String BACKGROUNDDIMENSION = StartController.getBACKGROUND()+"size: "+Double.toString(BACKGROUNDBREITE)+"px "+
            Double.toString(BACKGROUNDHOEHE)+"px;";
    private static final String HINTERGRUNDPFAD = "image: url(/graphics/background/";
    private static final String HINTERGRUND = StartController.getBACKGROUND()+HINTERGRUNDPFAD+"background.png);";
    private static final String HINTERGRUNDMASTER = StartController.getBACKGROUND()+HINTERGRUNDPFAD+"bg-mastermind-set-screen.png);";
    private static final String HINTERGRUNDCONTINUE = StartController.getBACKGROUND()+HINTERGRUNDPFAD+"bg-master-continue-screen.png);";
    private static final String SIEGSPIELER = StartController.getBACKGROUND()+HINTERGRUNDPFAD+"bg-player-win.png);";
    private static final String HAUPTPANE = "#hauptpane";
    private static final String START ="#start";
    private static final String QUIT ="#quit";
    private static final String ZUGBEENDEN ="#zugBeenden";
    private static final String MASTERTEXT ="#masterTextField";
    private static final String LOESCHEN ="#loeschen";
    private static final String SETZFELD ="#setzFeld";
    private static final String FARBFELD ="#farbFeld";
    private static final String MASTERFELD ="#masterFeld";
    private static final String MASTERPADLOCKS = "#masterPadlocks";
    private static final String VERSUCHFELD ="#versuchFeld";
    private static final String PLAYPANE ="#playPane";
    private static final String SIGNALPANE="#signalPane";




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
        scene.setCursor(Cursor.OPEN_HAND);
        scene.getCursor();
        stage.setResizable(false);
        stage.show();
    }



    public Scene ladeMastermindSetzen()throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/mastermindSetzen.fxml"));
        Scene scene = new Scene(root);
        mastermindSetzenAufloesung(scene);
        scene.setCursor(Cursor.OPEN_HAND);
        scene.getCursor();
        return scene;
    }

    public Scene ladeZwischenVersuchStage()throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/zwischenVersuch.fxml"));
        Scene scene = new Scene(root);
        zwischenVersuchAufloesung(scene);
        scene.setCursor(Cursor.OPEN_HAND);
        scene.getCursor();
        return scene;
    }

    public Scene ladeMastermindSignal()throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/masterSignal.fxml"));
        Scene scene = new Scene(root);
        signalSceneAufloesung(scene);
        scene.setCursor(Cursor.OPEN_HAND);
        scene.getCursor();

        return scene;
    }

    public Scene ladeVersuchStage()throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stages/versuch.fxml"));
        Scene scene = new Scene(root);
        versuchsceneAufloesung(scene);
        scene.setCursor(Cursor.OPEN_HAND);
        scene.getCursor();
        return scene;
    }
    
    public Scene ladeSiegStage()throws Exception
    {
    	Parent root = FXMLLoader.load(getClass().getResource("stages/sieg.fxml"));
        Scene scene = new Scene(root);
        siegAufloesung(scene);
        return scene;
    }

    private void mastermindSetzenAufloesung(Scene scene)
    {
        scene.lookup(HAUPTPANE).setStyle(HINTERGRUNDMASTER+StartController.getNOREPEAT()+StartController.getBACKGROUNDIMAGEPOSITION()
                +BACKGROUNDDIMENSION);
        scene.lookup(ZUGBEENDEN).setLayoutX((793/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(ZUGBEENDEN).setLayoutY((32/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(SETZFELD).setLayoutX((448/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(SETZFELD).setLayoutY((272/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(FARBFELD).setLayoutX((388/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(FARBFELD).setLayoutY((371/DISPLAYHOEHE)*BACKGROUNDHOEHE);
    }


    private void versuchsceneAufloesung(Scene scene)
    {
        scene.lookup(HAUPTPANE).setStyle(HINTERGRUND+StartController.getNOREPEAT()+StartController.getBACKGROUNDIMAGEPOSITION()
                +BACKGROUNDDIMENSION);
        scene.lookup(PLAYPANE).prefWidth(QUOTIENTBREITE*507);
        scene.lookup(PLAYPANE).prefHeight(QUOTIENTHOEHE*790);
        scene.lookup(PLAYPANE).setLayoutX((14/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(PLAYPANE).setLayoutY((1/VERSUCHHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(SIGNALPANE).prefWidth(QUOTIENTBREITE*507);
        scene.lookup(SIGNALPANE).prefHeight(QUOTIENTHOEHE*790);
        scene.lookup(SIGNALPANE).setLayoutX((532/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(SIGNALPANE).setLayoutY((1/VERSUCHHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(ZUGBEENDEN).setLayoutX((793/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(ZUGBEENDEN).setLayoutY((32/VERSUCHHOEHE)*BACKGROUNDHOEHE);
    }

    private void signalSceneAufloesung(Scene scene)
    {
        scene.lookup(HAUPTPANE).setStyle(HINTERGRUND+StartController.getNOREPEAT()+StartController.getBACKGROUNDIMAGEPOSITION()
                +BACKGROUNDDIMENSION);
        scene.lookup(SETZFELD).setLayoutX((385/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(SETZFELD).setLayoutY((337/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(FARBFELD).setLayoutX((425/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(FARBFELD).setLayoutY((415/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(MASTERPADLOCKS).setLayoutX((385/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(MASTERPADLOCKS).setLayoutY((67/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(MASTERFELD).setLayoutX((385/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(MASTERFELD).setLayoutY((87/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(VERSUCHFELD).setLayoutX((385/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(VERSUCHFELD).setLayoutY((147/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(MASTERTEXT).setLayoutX((245/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(MASTERTEXT).setLayoutY((125/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(LOESCHEN).setLayoutX((706/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(LOESCHEN).setLayoutY((437/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(ZUGBEENDEN).setLayoutX((793/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(ZUGBEENDEN).setLayoutY((32/DISPLAYHOEHE)*BACKGROUNDHOEHE);
    }

    private void zwischenVersuchAufloesung(Scene scene)
    {
        scene.lookup(HAUPTPANE).setStyle(HINTERGRUNDCONTINUE+StartController.getNOREPEAT()+StartController.getBACKGROUNDIMAGEPOSITION()
                +BACKGROUNDDIMENSION);
        scene.lookup(ZUGBEENDEN).setLayoutX((412/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(ZUGBEENDEN).setLayoutY((334/DISPLAYHOEHE)*BACKGROUNDHOEHE);
    }

    private void siegAufloesung(Scene scene)
    {
        scene.lookup(HAUPTPANE).setStyle(SIEGSPIELER+StartController.getNOREPEAT()+StartController.getBACKGROUNDIMAGEPOSITION()
                +BACKGROUNDDIMENSION);

        scene.lookup(MASTERFELD).setLayoutX((450/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(MASTERFELD).setLayoutY((485/DISPLAYHOEHE)*BACKGROUNDHOEHE);

        scene.lookup(START).setLayoutX((214/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(START).setLayoutY((348/DISPLAYHOEHE)*BACKGROUNDHOEHE);
        scene.lookup(QUIT).setLayoutX((684/DISPLAYBREITE)*BACKGROUNDBREITE);
        scene.lookup(QUIT).setLayoutY((348/DISPLAYHOEHE)*BACKGROUNDHOEHE);
    }
    @Override public void stop()
    {
        System.exit(0);
    }
}