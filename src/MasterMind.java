/**
 * Created by Noctis on 24.05.2017.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MasterMind
{
    private static final int ZUGBEENDEN = 2;
    private static final int SPIELBEENDEN = 1;
    private Spielbrett spielbrett;
    private boolean siegBedingung = false;
    private boolean zugBeenden = false;
    private int versuche = 0;
    private int farbe;
    private int position;

    //private MasterMindRegeln regeln;
    private MasterMind()
    {
        spielbrett = new Spielbrett();
        //regeln = new MasterMindRegeln();
    }
    private void spielBeenden(int fall)
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
                    break;
                case ZUGBEENDEN:
                    System.out.print("Moechten Sie Ihren Zug beenden?(y/n) ");
                    if(eingabe.readLine().contains("y"))
                        zugBeenden = true;
                    break;
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    private void setzeTippFeld()
    {
        int i = 0;
        int j = 0;
        for(Spielfigur versuch : spielbrett.getVersuch().figuren)
        {
            for(Spielfigur master : spielbrett.getMaster().figuren)
            {
                if(versuch.getFarbe() == master.getFarbe())
                {
                    if(i==j)
                        spielbrett.getTipp().figuren[i].setFarbe(Spielfigur.SCHWARZ);
                    else
                        spielbrett.getTipp().figuren[i].setFarbe(Spielfigur.WEISS);
                }
                j++;
            }
            i++;
            j = 0;

        }
    }
    private void pruefeSiegBedingung()
    {
        System.out.println("Siegbedingung");
        siegBedingung = true;
        for(int i = 0; i < spielbrett.getVersuch().figuren.length; i++)
        {
            if(spielbrett.getVersuch().figuren[i].getFarbe() != spielbrett.getMaster().figuren[i].getFarbe())
            {
                System.out.println("SiegBedingung nicht erfuellt");
                siegBedingung = false;
            }

        }
    }
    private void setzeSpielfiguren()
    {
        BufferedReader eingabe = new BufferedReader(new InputStreamReader(System.in));
        zugBeenden = false;
        while(!zugBeenden)
        {
            try
            {
                System.out.print("Farbe: ");
                farbe = Integer.parseInt(eingabe.readLine());
                System.out.print("Position: ");
                position = Integer.parseInt(eingabe.readLine());
                spielbrett.getVersuch().setzeSpielfigur(this.position, new Spielfigur(this.farbe));
                System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());
                spielBeenden(ZUGBEENDEN);
            }
            catch(IOException ioe)
            {
                ioe.printStackTrace();
            }
        }
    }

    private void spielen()
    {
        while(true)
        {
            while (!siegBedingung && versuche < 11)
            {
                setzeSpielfiguren();
                setzeTippFeld();
                pruefeSiegBedingung();
                versuche++;
            }
            spielbrett = new Spielbrett();
            spielBeenden(SPIELBEENDEN);
        }
    }
    public static void main(String args[]) {
        try {
            MasterMind spielSitzung = new MasterMind();
            spielSitzung.spielen();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
