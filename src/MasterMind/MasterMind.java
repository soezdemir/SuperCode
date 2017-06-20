/**
 * Created by Noctis on 24.05.2017.
 */
package MasterMind;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Klasse die den Spielfluss bestimmt
public class MasterMind
{
    private static final int SPIELERMASTER = 1;
    private static final int VERSUCHSSPIELER = 0;
    private static final int ZUGBEENDEN = 2;
    private static final int SPIELBEENDEN = 1;
    private Spielbrett spielbrett;
    private boolean siegBedingung = false;
    private boolean zugBeenden = false;
    private boolean feldStatus = true;
    private int versuche = 0;

    public int getFarbe() {
        return farbe;
    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }

    private int farbe = 0;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position = 0;
    //private GUI gui = new GUI();

    //private MasterMind.MasterMindRegeln regeln;
    public MasterMind()
    {
        try
        {
            spielbrett = new Spielbrett();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //regeln = new MasterMind.MasterMindRegeln();
    }
    //Abfrage ob die Runde oder das Spiel beendet werden soll, je nach Situation
    private void spielBeenden(int fall, int spieler)
    {
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            switch(fall)
            {
                case SPIELBEENDEN:
                    System.out.print("Moechten Sie das Spiel beenden?(y/n) ");
                    if(eingabe.readLine().contains("y"))
                        System.exit(0);
                    siegBedingung = false;
                    versuche = 0;
                    break;
                case ZUGBEENDEN:
                    feldStatus = spielbrett.pruefeVersuchsOderMasterFeld(spieler);
                    if(!feldStatus)
                    {
                        System.out.print("Moechten Sie Ihren Zug beenden?(y/n) ");
                        if(eingabe.readLine().contains("y"))
                            zugBeenden = true;
                    }
                    break;
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    //Belege tippfeld, die Runde kann erst beendet werden wenn das Feld richtig gesetzt wurde
    private void setzeTippFeld()
    {
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        boolean tippFeldStatus = true;
        while (tippFeldStatus)
        {
            try
            {
                System.out.print("Farbe: ");
                farbe = Integer.parseInt(eingabe.readLine());
                System.out.print("Position: ");
                position = Integer.parseInt(eingabe.readLine());
                spielbrett.getTipp().setzeSpielfigur(position, new Spielfigur(farbe));
                /*System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());*/
                tippFeldStatus = spielbrett.pruefeTippFeld();
            }
            catch (IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
    //preuft ob das Versuchs Feld dem Master Feld entspricht, also ob die Sieg Bedingung erfuellt ist
    private void pruefeSiegBedingung()
    {
        //System.out.println("Siegbedingung");
        siegBedingung = true;
        for(int i = 0; i < spielbrett.getVersuch().figuren.length; i++)
        {
            if(spielbrett.getVersuch().figuren[i].getFarbe() != spielbrett.getMaster().figuren[i].getFarbe())
            {
                //System.out.println("SiegBedingung nicht erfuellt");
                siegBedingung = false;
                return;
            }

        }
    }
    //Setzen des Versuchsfeldes. Die Runde kann erst beendet werden, wenn das Feld richtig gesetzt wurde
    private void setzeVersuchsFeld()
    {
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        zugBeenden = false;
        feldStatus = true;
        while(!zugBeenden || feldStatus)
        {
            try
            {
                System.out.print("Farbe: ");
                farbe = Integer.parseInt(eingabe.readLine());
                System.out.print("Position: ");
                position = Integer.parseInt(eingabe.readLine());
                spielbrett.getVersuch().setzeSpielfigur(position, new Spielfigur(farbe));
                /*System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());*/
                spielBeenden(ZUGBEENDEN, VERSUCHSSPIELER);
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
    //Setzen des MasterMind Feldes. Die Runde kann erst beendet werden, wenn das Feld richtig gesetzt wurde
    private void setzeMasterMind()
    {
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        zugBeenden = false;
        feldStatus = true;
        while(!zugBeenden || feldStatus)
        {
            try
            {
                System.out.print("Farbe: ");
                farbe = Integer.parseInt(eingabe.readLine());
                System.out.print("Position: ");
                position = Integer.parseInt(eingabe.readLine());
                spielbrett.getMaster().setzeSpielfigur(position, new Spielfigur(farbe));
                /*System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());*/
                spielBeenden(ZUGBEENDEN, SPIELERMASTER);
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }
    //Hauptschleife des Spiels. Sequenziertes setzen der Felde und pruefen auf Siegbedingung. Wurde Sieg erreicht,
    //Frage ob Spiel beendet werden soll oder weiter gespielt werden soll
    public void spielen()
    {
        //while(true)
        //{
            //gui.zeichneSpielbrett();
            /*setzeMasterMind();
            while (!siegBedingung && versuche < 11)
            {
                setzeVersuchsFeld();
                setzeTippFeld();
                pruefeSiegBedingung();
                versuche++;
                spielbrett.setTipp(new TippFeld());
            }
            spielbrett = new Spielbrett();
            spielBeenden(SPIELBEENDEN, SPIELERMASTER);
        }*/
    }
    /*public static void main(String args[]) {
        try {
            MasterMind spielSitzung = new MasterMind();
            spielSitzung.spielen();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }*/
}
