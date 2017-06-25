/**
 * Created by Christian Patzek & Sadri Oezdemir on 17/05/2017.
 */
package MasterMind;
//Das Spielbrett enthaelt alle moeglichen Spielfelder. Es verwaltet diese und kann sie ueberpreufen
public class Spielbrett
{
    public static final int VERSUCHSFELD = 0;
    public static final int MASTERFELD = 1;
    //deprecated siehe MasterMind.FarbVektor.java
    //public static final int SCHWARZERHOEHEN = 2;
    //public static final int WEISSERHOEHEN = 3;

    /*private MasterMind.FarbVektor rot = new MasterMind.FarbVektor(Spielfigur.ROT);
    private MasterMind.FarbVektor blau = new MasterMind.FarbVektor(Spielfigur.BLAU);
    private MasterMind.FarbVektor gruen = new MasterMind.FarbVektor(Spielfigur.GRUEN);
    private MasterMind.FarbVektor gelb = new MasterMind.FarbVektor(Spielfigur.GELB);
    private MasterMind.FarbVektor lila = new MasterMind.FarbVektor(Spielfigur.LILA);
    private MasterMind.FarbVektor orange = new MasterMind.FarbVektor(Spielfigur.ORANGE);
    private MasterMind.FarbVektor pink = new MasterMind.FarbVektor(Spielfigur.PINK);
    private MasterMind.FarbVektor hellgruen = new MasterMind.FarbVektor(Spielfigur.HELLGRUEN);*/

    public FigurenFeld getFiguren() {
        return figuren;
    }

    public void setFiguren(FigurenFeld figuren) {
        this.figuren = figuren;
    }

    public MasterMindFeld getMaster() {
        return master;
    }

    public void setMaster(MasterMindFeld master) {
        this.master = master;
    }

    public VersuchsFeld getVersuch() {
        return versuch;
    }

    public void setVersuch(VersuchsFeld versuch) {
        this.versuch = versuch;
    }

    private MasterMindFeld master;
    private VersuchsFeld versuch;

    public TippFeld getTipp() {
        return tipp;
    }

    public void setTipp(TippFeld tipp) {
        this.tipp = tipp;
    }

    private TippFeld tipp;
    private FigurenFeld figuren;

    //deprecated
    /*public void resetVektoren()
    {
        rot.setSchwarz(0);rot.setWeiss(0);
        blau.setSchwarz(0);blau.setWeiss(0);
        gruen.setSchwarz(0);gruen.setWeiss(0);
        gelb.setSchwarz(0);gelb.setWeiss(0);
        lila.setSchwarz(0);lila.setWeiss(0);
        orange.setSchwarz(0);orange.setWeiss(0);
        pink.setSchwarz(0);pink.setWeiss(0);
        hellgruen.setSchwarz(0);hellgruen.setWeiss(0);
    }*/
    //preuft ob die Menge der gesetzten Schwarz, Weiss figuren im Tippfeld tatsaechlich richtig ist
    public boolean pruefeWeissSchwarz(int schwarz, int weiss)
    {
        /*int schwarz = rot.getSchwarz()+blau.getSchwarz()+gruen.getSchwarz()+gelb.getSchwarz()+lila.getSchwarz()
                +orange.getSchwarz()+pink.getSchwarz()+hellgruen.getSchwarz();
        System.out.println("Schwarz in Vektoren: "+schwarz);
        int weiss = rot.getWeiss()+blau.getWeiss()+gruen.getWeiss()+gelb.getWeiss()+lila.getWeiss()
                +orange.getWeiss()+pink.getWeiss()+hellgruen.getWeiss();*/
        int schwarzGesetzt = 0;
        int weissGesetzt = 0;
        for(Spielfigur tipp: tipp.figuren)
        {
            if(tipp.getFarbe() == Spielfigur.WEISS)
                weissGesetzt++;
            else if(tipp.getFarbe() == Spielfigur.SCHWARZ)
                schwarzGesetzt++;
        }
        //System.out.println("Schwarz tatsaechlich gesetzt: "+schwarzGesetzt);
        return((schwarzGesetzt == schwarz && weissGesetzt == weiss));
    }
    //deprecated
    /*public void bestimmeFarbvektor(int farbe, int fall)
    {
        switch(farbe)
        {
            case Spielfigur.BLAU:
                if(fall == SCHWARZERHOEHEN)
                    blau.erhoeheAnzahlSchwarz();
                else
                    blau.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.GELB:
                if(fall == SCHWARZERHOEHEN)
                    gelb.erhoeheAnzahlSchwarz();
                else
                    gelb.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.GRUEN:
                if(fall == SCHWARZERHOEHEN)
                    gruen.erhoeheAnzahlSchwarz();
                else
                    gruen.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.HELLGRUEN:
                if(fall == SCHWARZERHOEHEN)
                    hellgruen.erhoeheAnzahlSchwarz();
                else
                    hellgruen.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.LILA:
                if(fall == SCHWARZERHOEHEN)
                    lila.erhoeheAnzahlSchwarz();
                else
                    lila.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.ORANGE:
                if(fall == SCHWARZERHOEHEN)
                    orange.erhoeheAnzahlSchwarz();
                else
                    orange.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.PINK:
                if(fall == SCHWARZERHOEHEN)
                    pink.erhoeheAnzahlSchwarz();
                else
                    pink.erhoeheAnzahlWeiss();
                break;
            case Spielfigur.ROT:
                if(fall == SCHWARZERHOEHEN)
                    rot.erhoeheAnzahlSchwarz();
                else
                    rot.erhoeheAnzahlWeiss();
                break;
        }
    }*/

    //algorithmus zur Berechnung der Anzahl der Schwarzen und Weissen Figuren im Tippfeld
    public boolean pruefeTippFeld()
    {
        //resetVektoren();
        int schwarz = 0;
        int weiss = 0;
        boolean[] schwarzRecall = new boolean[5];
        boolean[] weissRecall = new boolean[5];
        for(int i = 0; i < 5; i++)
        {
            for(int j = 0; j < 5; j++)
            {
                if(versuch.figuren[i].getFarbe() == master.figuren[j].getFarbe())
                {
                    if(i == j && !schwarzRecall[i])
                    {
                        schwarz++;
                        //bestimmeFarbvektor(versuch.figuren[i].getFarbe(), SCHWARZERHOEHEN);
                        schwarzRecall[i] = true;
                        if(weissRecall[i])
                            weiss--;
                        j+=5;
                    }
                    else if(!schwarzRecall[i] && !weissRecall[i])
                    {
                        weiss++;
                        weissRecall[i] = true;
                        //bestimmeFarbvektor(versuch.figuren[i].getFarbe(), WEISSERHOEHEN);
                        //j+=5;
                    }
                }
            }
        }
        return pruefeWeissSchwarz(schwarz, weiss);
    }
    public boolean pruefeVersuchsOderMasterFeld(int fall)
    {
        switch(fall)
        {
            case VERSUCHSFELD:
                return versuch.pruefeFeldAufGesetzt();
            case MASTERFELD:
                return master.pruefeFeldAufGesetzt();
        }
        return true;
    }
    Spielbrett()
    {
        master = new MasterMindFeld();
        versuch = new VersuchsFeld();
        tipp = new TippFeld();
        figuren = new FigurenFeld();
    }
}
