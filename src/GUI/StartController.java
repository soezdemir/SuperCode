/**
 * Created by Noctis on 20.06.2017.
 */
package GUI;

import MasterMind.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class StartController
{
    private static MasterMind masterMind;
    private static GUI gui = new GUI();

    @FXML private Button startButton;
    @FXML private Button pos0;
    @FXML private Button pos1;
    @FXML private Button pos2;
    @FXML private Button pos3;
    @FXML private Button pos4;

    private static final String SPIELFIGURPFAD = "-fx-background-image: url(/graphics/spielfiguren/";
    private static final String BILDDATEIENDUNG =".png);";

    private String farbe;
    private static Stage currentstage;

    @FXML protected void handleStartButtonAction(ActionEvent event)throws Exception
    {
        masterMind = new MasterMind();
        currentstage = (Stage) startButton.getScene().getWindow();
        currentstage = gui.ladeMastermindSetzen(currentstage);
        Thread engine = new Thread(masterMind);
        engine.start();
        //masterMind.spielen(currentstage, this);
    }

    @FXML protected void handleQuitButtonAction(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML protected void handleRotAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.ROT);
        farbe = "rot";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleBlauAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.BLAU);
        farbe = "blau";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleGelbAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.GELB);
        farbe = "gelb";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handlePinkAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.PINK);
        farbe = "pink";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleOrangeAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.ORANGE);
        farbe = "orange";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleLilaAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.LILA);
        farbe = "lila";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleHellgruenAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.HELLGRUEN);
        farbe = "hellgruen";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handleGruenAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.GRUEN);
        farbe = "gruen";
        masterMind.setFarbeGedrueckt(true);
    }

    @FXML protected void handlePos0Action(ActionEvent event)
    {
        masterMind.setPosition(0);
        if(masterMind.isFarbeGedrueckt())
            zeichneNeu();
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos1Action(ActionEvent event)
    {
        masterMind.setPosition(1);
        if(masterMind.isFarbeGedrueckt())
            zeichneNeu();
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos2Action(ActionEvent event)
    {
        masterMind.setPosition(2);
        if(masterMind.isFarbeGedrueckt())
            zeichneNeu();
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos3Action(ActionEvent event)
    {
        masterMind.setPosition(3);
        if(masterMind.isFarbeGedrueckt())
            zeichneNeu();
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos4Action(ActionEvent event)
    {
        masterMind.setPosition(4);
        if(masterMind.isFarbeGedrueckt())
            zeichneNeu();
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handleZugBeendenAction(ActionEvent event)throws Exception
    {
        masterMind.setZugBeenden(!masterMind.isZugBeenden());
        if(masterMind.isZugBeenden() && masterMind.isFeldStatus())
            currentstage = gui.ladeZwischenStage(currentstage);
    }

    private void zeichneNeu()
    {
        switch(masterMind.getPosition())
        {
            case 0:
                pos0.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG);
                break;
            case 1:
                pos1.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG);
                break;
            case 2:
                pos2.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG);
                break;
            case 3:
                pos3.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG);
                break;
            case 4:
                pos4.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG);
                break;
        }
    }
}
