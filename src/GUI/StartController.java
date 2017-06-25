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
    private static Stage mastermindSetzen = new Stage();
    private static Stage versuchstage = new Stage();
    //private static Stage zwischenMasterStage;
    private static Stage zwischenVersuchStage = new Stage();
    private static Stage signalstage = new Stage();
    private static Stage siegStage = new Stage();
    private static int zug;
    //private static String zugS = Integer.toString(zug);
    private static String farbe;
    private static String[] posFarbe = new String[5];
    private static String[] posSignal = new String[5];

    @FXML private Button startButton;
    @FXML private Button signal0;
    @FXML private Button signal1;
    @FXML private Button signal2;
    @FXML private Button signal3;
    @FXML private Button signal4;

    private static final String BACKGROUND = "-fx-background-";
    private static final String SPIELFIGURPFAD = BACKGROUND+"image: url(/graphics/spielfiguren/";
    private static final String SPIELFIGURGROESSE = BACKGROUND+"size: 40px 40px;";
    private static final String NOREPEAT = BACKGROUND+"repeat: no-repeat;";
    private static final String BACKGROUNDIMAGEPOSITION = BACKGROUND+"position: center;";
    private static final String BILDDATEIENDUNG =".png);";
    private static final String MASTER = "#master";
    private static final String VERSUCH = "#versuch";
    private static final String SIGNAL = "#signal";

    @FXML protected void handleStartButtonAction(ActionEvent event)throws Exception
    {
        zug = 1;
    	masterMind = new MasterMind();
        Stage stage = (Stage) startButton.getScene().getWindow();
        mastermindSetzen = gui.ladeMastermindSetzen(mastermindSetzen);
        versuchstage = gui.ladeVersuchStage(versuchstage);
        zwischenVersuchStage = gui.ladeZwischenVersuchStage(zwischenVersuchStage);
        signalstage = gui.ladeMastermindSignal(signalstage);
        siegStage = gui.ladeSiegStage(siegStage);
        siegStage.hide();
        mastermindSetzen.show();
        stage.close();
        Thread engine = new Thread(masterMind);
        engine.start();
        //masterMind.spielen(currentstage, this);
    }

    @FXML protected void handleQuitButtonAction(ActionEvent event)
    {
        System.exit(0);
    }

    @FXML protected void handleSchwarzAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.SCHWARZ);
    	farbe = "schwarz";
    	masterMind.setFarbeGedrueckt(true);
    }
    
    @FXML protected void handleWeissAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.WEISS);
    	farbe = "weiss";
    	masterMind.setFarbeGedrueckt(true);
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
    
    @FXML protected void handleGrauAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.GRAU);
    	farbe = "grau";
    	masterMind.setFarbeGedrueckt(true);
    }
    
    @FXML protected void handlePos0Action(ActionEvent event)
    {
        masterMind.setPosition(0);
        if(masterMind.isFarbeGedrueckt())
        {
        	Button source = (Button) event.getSource();
        	if(source == signal0)
        	{
        		zeichneNeuSignal(source, masterMind.getPosition());
        	}
        	else
        		zeichneNeu(source, masterMind.getPosition());
        }
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos1Action(ActionEvent event)
    {
        masterMind.setPosition(1);
        if(masterMind.isFarbeGedrueckt())
        {
        	Button source = (Button) event.getSource();
        	if(source == signal1)
        	{
        		zeichneNeuSignal(source, masterMind.getPosition());
        	}
        	else
        		zeichneNeu(source, masterMind.getPosition());
        }
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos2Action(ActionEvent event)
    {
        masterMind.setPosition(2);
        if(masterMind.isFarbeGedrueckt())
        {
        	Button source = (Button) event.getSource();
        	if(source == signal2)
        	{
        		zeichneNeuSignal(source, masterMind.getPosition());
        	}
        	else
        		zeichneNeu(source, masterMind.getPosition());
        }
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos3Action(ActionEvent event)
    {
        masterMind.setPosition(3);
        if(masterMind.isFarbeGedrueckt())
        {
        	Button source = (Button) event.getSource();
        	if(source == signal3)
        	{
        		zeichneNeuSignal(source, masterMind.getPosition());
        	}
        	else
        		zeichneNeu(source, masterMind.getPosition());
        }
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handlePos4Action(ActionEvent event)
    {
        masterMind.setPosition(4);
        if(masterMind.isFarbeGedrueckt())
        {
        	Button source = (Button) event.getSource();
        	if(source == signal4)
        	{
        		zeichneNeuSignal(source, masterMind.getPosition());
        	}
        	else
        		zeichneNeu(source, masterMind.getPosition());
        }
        masterMind.setPositionGedrueckt(true);
    }

    @FXML protected void handleZugBeendenInitialAction(ActionEvent event)throws Exception
    {
    	if(masterMind.isFeldStatus())
    	{
    		masterMind.setZugBeenden(true);
    		//signalstage = gui.ladeMastermindSignal(signalstage);
        	for(int i = 0; i < 5; i++)
        		signalstage.getScene().lookup(MASTER+i).setStyle(SPIELFIGURPFAD+posFarbe[i]+BILDDATEIENDUNG
        				+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
        	versuchstage.show();
        	mastermindSetzen.close();
    	}
    }
    
    @FXML protected void handleZugBeendenMasterAction(ActionEvent event)throws Exception
    {
        if(masterMind.isFeldStatus())
        {
            int i = 0;
        	masterMind.setZugBeenden(true);
            versuchstage.getScene().lookup(VERSUCH+Integer.toString(zug)).setVisible(true);
            versuchstage.getScene().lookup(VERSUCH+Integer.toString(zug-1)).setDisable(true);
            while(i < 5 && posSignal[i] != "")
            {
            	versuchstage.getScene().lookup(SIGNAL+i+Integer.toString(zug-1)).setStyle(SPIELFIGURPFAD+posSignal[i]+BILDDATEIENDUNG
            			+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
            	posSignal[i] = "";
            	i++;
            }
            versuchstage.show();
            signalstage.hide();
        }
     }

    @FXML protected void handleZugBeendenVersuchAction(ActionEvent event)throws Exception
    {
    	if(masterMind.isFeldStatus())
        {
            masterMind.setZugBeenden(true);
            Thread.sleep(2);
            if(masterMind.isSiegBedingung())
            {
            	siegStage.show();
            }
            //TODO verlierstage einrichten
            else if(zug == 12)
            {
            	siegStage.getScene().lookup("#hauptpane").setStyle("eigenschaften des backgrounds(verlierbackground)");
            	siegStage.show();
            }
            else
            	zwischenVersuchStage.show();
            versuchstage.hide();
            zug++;
            //zugS = Integer.toString(zug);
        }
    }

    @FXML protected void handleWeiterVersuchAction(ActionEvent event)throws Exception
    {
    	for(int i = 0; i < 5; i++)
    	{
    		signalstage.getScene().lookup(VERSUCH+i).setStyle(SPIELFIGURPFAD+posFarbe[i]+BILDDATEIENDUNG+SPIELFIGURGROESSE+
    				NOREPEAT+BACKGROUNDIMAGEPOSITION);
    		signalstage.getScene().lookup(SIGNAL+i).setStyle(BACKGROUND+"image: url();");
    	}
    	signalstage.show();
    	zwischenVersuchStage.hide();
    }

    private void zeichneNeu(Button source, int position)
    {
        posFarbe[position] = farbe;
        source.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    }
    
    private void zeichneNeuSignal(Button source, int position)
    {
    	posSignal[position] = farbe;
    	source.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    }
}
