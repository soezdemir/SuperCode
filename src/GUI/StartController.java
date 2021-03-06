/**
 * Created by cpatzek & soezdemir 17/05/2017.
 *@author Christian Patzek und Sadri Oezdemir
 */

package GUI;

import MasterMind.*;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class StartController
{
    private static MasterMind masterMind;
    private static GUI gui = new GUI();
    private static Stage currentStage = new Stage();
    private static Stage startStage = new Stage();
    private static Scene mastermindSetzen;
    private static Scene versuchscene;
    private static Scene zwischenVersuchScene;
    private static Scene signalScene;
    private static Scene siegScene;
    private static int zug;
    private static String farbe;
    private static String[] posFarbe = new String[5];
    private static String[] posSignal = new String[5];

    @FXML private Button startButton;
    @FXML private Button signal0;
    @FXML private Button signal1;
    @FXML private Button signal2;
    @FXML private Button signal3;
    @FXML private Button signal4;
    @FXML private Button posMaster0;
    @FXML private Button posMaster1;
    @FXML private Button posMaster2;
    @FXML private Button posMaster3;
    @FXML private Button posMaster4;

    public static String getBACKGROUND() {
        return BACKGROUND;
    }
    private static final String BACKGROUND = "-fx-background-";
    private static final String HINTERGRUNDPFAD = "image: url(/graphics/background/";
    private static final String SPIELFIGURPFAD = BACKGROUND+"image: url(/graphics/spielfiguren/";
    private static final String SPIELFIGURGROESSE = BACKGROUND+"size: 60px 60px;";
    public static String getNOREPEAT() {
        return NOREPEAT;
    }
    private static final String NOREPEAT = BACKGROUND+"repeat: no-repeat;";
    public static String getBACKGROUNDIMAGEPOSITION() {
        return BACKGROUNDIMAGEPOSITION;
    }
    private static final String BACKGROUNDIMAGEPOSITION = BACKGROUND+"position: center;";
    private static final String BILDDATEIENDUNG =".png);";
    private static final String MASTER = "#master";
    private static final String VERSUCH = "#versuch";
    private static final String SIGNAL = "#signal";
    private static final String SIEGMASTERMIND = BACKGROUND+HINTERGRUNDPFAD+"bg-mastermind-win"+BILDDATEIENDUNG;
    private static final String SIGNALBACKGROUND = BACKGROUND+HINTERGRUNDPFAD+"bg-signal-slot"+BILDDATEIENDUNG;
    /**
    *bei anklicken des Startbuttons fragt der Controller bei der GUI die notwendigen Scenen an. Anschliessend wird die scene mastermindSetzen geladen
    */
    @FXML protected void handleStartButtonAction(ActionEvent event)throws Exception
    {
        zug = 1;
    	masterMind = new MasterMind();
        startStage = (Stage) startButton.getScene().getWindow();
        mastermindSetzen = gui.ladeMastermindSetzen();
        versuchscene = gui.ladeVersuchStage();
        zwischenVersuchScene = gui.ladeZwischenVersuchStage();
        signalScene = gui.ladeMastermindSignal();
        siegScene = gui.ladeSiegStage();
        currentStage.setScene(mastermindSetzen);
        startStage.close();
        currentStage.show();
        currentStage.setFullScreen(true);
        currentStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        Thread engine = new Thread(masterMind);
        engine.start();
    }

    @FXML protected void handleQuitButtonAction(ActionEvent event)
    {
        System.exit(0);
    }
    /**
    *setzt die angegeben Farbe in der Engine und teilt der engine mit das ein Farb-Button gedrueckt wurde
    */
    @FXML protected void handleSchwarzAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.SCHWARZ);
    	farbe = "schwarz";
    	masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleWeissAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.WEISS);
    	farbe = "weiss";
    	masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleRotAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.ROT);
        farbe = "rot";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleBlauAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.BLAU);
        farbe = "blau";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleGelbAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.GELB);
        farbe = "gelb";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handlePinkAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.PINK);
        farbe = "pink";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleOrangeAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.ORANGE);
        farbe = "orange";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleLilaAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.LILA);
        farbe = "lila";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleHellgruenAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.HELLGRUEN);
        farbe = "hellgruen";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */
    @FXML protected void handleGruenAction(ActionEvent event)
    {
        masterMind.setFarbe(Spielfigur.GRUEN);
        farbe = "gruen";
        masterMind.setFarbeGedrueckt(true);
    }
    /**
    *@see #handleSchwarzAction(ActionEvent event)
    */  
    @FXML protected void handleGrauAction(ActionEvent event)
    {
    	masterMind.setFarbe(Spielfigur.GRAU);
    	farbe = "grau";
    	masterMind.setFarbeGedrueckt(true);
    }
    /**
    *Wurde eine Position gedrueckt so wird gefragt ob eine Farbe gedrueckt wurde. Falls ja wird die Position neu gezeichnet.
    *Anschliessend wird die Position als gedrueckt fuer die Engine gekennzeichnet.
    */
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
            else if(source == posMaster0)
            {
                zeichneNeuMaster(source, masterMind.getPosition());
            }
        	else
        		zeichneNeu(source, masterMind.getPosition());
            masterMind.setPositionGedrueckt(true);
        }
    }
    /**
    *@see #handlePos0Action(ActionEvent event)
    */  
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
            else if(source == posMaster1)
            {
                zeichneNeuMaster(source, masterMind.getPosition());
            }
        	else
        		zeichneNeu(source, masterMind.getPosition());
            masterMind.setPositionGedrueckt(true);
        }
    }
    /**
    *@see #handlePos0Action(ActionEvent event)
    */  
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
            else if(source == posMaster2)
            {
                zeichneNeuMaster(source, masterMind.getPosition());
            }
        	else
        		zeichneNeu(source, masterMind.getPosition());
            masterMind.setPositionGedrueckt(true);
        }
    }
    /**
    *@see #handlePos0Action(ActionEvent event)
    */  
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
            else if(source == posMaster3)
            {
                zeichneNeuMaster(source, masterMind.getPosition());
            }
        	else
        		zeichneNeu(source, masterMind.getPosition());
            masterMind.setPositionGedrueckt(true);
        }
    }
    /**
    *@see #handlePos0Action(ActionEvent event)
    */  
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
            else if(source == posMaster4)
            {
                zeichneNeuMaster(source, masterMind.getPosition());
            }
        	else
        		zeichneNeu(source, masterMind.getPosition());
            masterMind.setPositionGedrueckt(true);
        }
    }
    /**
    *wird der MasterMind setzen Zug beendet, so wird das Mastermind Feld in die signalScene eingetragen.
    *Anschliessend wird die versuchscene als neue Scene geladen
    */
    @FXML protected void handleZugBeendenInitialAction(ActionEvent event)throws Exception
    {
    	if(masterMind.isFeldStatus())
    	{
    		masterMind.setZugBeenden(true);
        	for(int i = 0; i < 5; i++)
        		signalScene.lookup(MASTER+i).setStyle(SPIELFIGURPFAD+posFarbe[i]+"_mm"+BILDDATEIENDUNG
        				+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
        	currentStage.setScene(versuchscene);
        	currentStage.setFullScreen(true);
    	}
    }
    /**
    *Beendet der Mastermind seinen Zug in der signalScene, so werden die neuen Boxen fuer die naechste Runde in versuchscene aktiviert bzw. deaktiviert
    *Die Signalstifte werden in der versuchscene gesetzt und am Ende wird die versuchscene angezeigt
    */
    @FXML protected void handleZugBeendenMasterAction(ActionEvent event)throws Exception
    {
        if(masterMind.isFeldStatus())
        {
            int i = 0;
        	masterMind.setZugBeenden(true);
            versuchscene.lookup(VERSUCH+Integer.toString(zug)).setDisable(false);
            versuchscene.lookup(VERSUCH+Integer.toString(zug-1)).setDisable(true);

            while(i < 5 && posSignal[i] != "")
            {
            	versuchscene.lookup(SIGNAL+i+Integer.toString(zug-1)).setStyle(SPIELFIGURPFAD+posSignal[i]+BILDDATEIENDUNG
            			+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
            	posSignal[i] = "";
            	i++;
            }
            currentStage.setScene(versuchscene);
            currentStage.setFullScreen(true);
        }
     }
    /**
    *Beendet der Versuchspieler seine Runde so wird auf Sieg geprueft. Sieg: zeige Siegstage an
    *Wenn SIegbedingung nicht erfuellt ist wird die zwischenVersuchScene angezeigt
    */
    @FXML protected void handleZugBeendenVersuchAction(ActionEvent event)throws Exception
    {
    	if(masterMind.isFeldStatus())
        {
            masterMind.setZugBeenden(true);
            Thread.sleep(2);
            if(masterMind.isSiegBedingung())
            {
            	for(int i = 0; i < 5; i++)
                {
                    siegScene.lookup(MASTER + i).setStyle(SPIELFIGURPFAD + posFarbe[i] + "_mm" + BILDDATEIENDUNG
                            + SPIELFIGURGROESSE + NOREPEAT + BACKGROUNDIMAGEPOSITION);
                }

                currentStage.setScene(siegScene);
            }
            else if(zug == 12)
            {
                for(int j = 0; j < 5; j++)
                {
                    siegScene.lookup(MASTER + j).setStyle(SPIELFIGURPFAD + posFarbe[j] + "_mm" + BILDDATEIENDUNG
                            + SPIELFIGURGROESSE + NOREPEAT + BACKGROUNDIMAGEPOSITION);
                }
            	    siegScene.lookup("#hauptpane").setStyle(SIEGMASTERMIND+NOREPEAT+BACKGROUNDIMAGEPOSITION+
                    BACKGROUND+"size: "+Double.toString(GUI.BACKGROUNDBREITE)+"px "+Double.toString(GUI.BACKGROUNDHOEHE)+"px");

                currentStage.setScene(siegScene);
            }
            else
            	currentStage.setScene(zwischenVersuchScene);
            zug++;
            currentStage.setFullScreen(true);
        }
    }
    /**
    *Schreibe den Versuch des Spielers in die signalScene, zeige signalScene an
    */
    @FXML protected void handleWeiterVersuchAction(ActionEvent event)throws Exception
    {
    	for(int i = 0; i < 5; i++)
    	{
    		signalScene.lookup(VERSUCH+i).setStyle(SPIELFIGURPFAD+posFarbe[i]+BILDDATEIENDUNG+SPIELFIGURGROESSE+
    				NOREPEAT+BACKGROUNDIMAGEPOSITION);
    		signalScene.lookup(SIGNAL+i).setStyle(SIGNALBACKGROUND+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    	}
    	currentStage.setScene(signalScene);
        currentStage.setFullScreen(true);
    }

    /**
     * Zeichnet den Button der zuletzt ausgewaehlt wurde mit der entsprechenden Farbe neu
     * @param source Der zu zeichnende Button
     * @param position Index fuer den Array um die passende Farbe zu bestimmen
     */
    private void zeichneNeu(Button source, int position)
    {
        posFarbe[position] = farbe;
        source.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    }

    /**
     * @see #zeichneNeu(Button, int)
     */
    private void zeichneNeuMaster(Button source, int position)
    {
        posFarbe[position] = farbe;
        source.setStyle(SPIELFIGURPFAD+farbe+"_mm"+BILDDATEIENDUNG+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    }
    /**
     * @see #zeichneNeu(Button, int)
     */
    private void zeichneNeuSignal(Button source, int position)
    {
    	posSignal[position] = farbe;
    	source.setStyle(SPIELFIGURPFAD+farbe+BILDDATEIENDUNG+SPIELFIGURGROESSE+NOREPEAT+BACKGROUNDIMAGEPOSITION);
    }
}
