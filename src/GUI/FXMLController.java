/**
 * Created by Noctis on 20.06.2017.
 */
package GUI;

import MasterMind.MasterMind;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class FXMLController
{
    private MasterMind masterMind;
    @FXML private javafx.scene.control.Button startButton;

    @FXML protected void handleStartButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) startButton.getScene().getWindow();
        masterMind = new MasterMind();
        masterMind.spielen();
        stage.close();
    }

    @FXML protected void handleQuitButtonAction(ActionEvent event)
    {
        System.exit(0);
    }
}
