/**
 * Created by cpatzek & soezdemir 17/05/2017.
 *@ author: Christian Patzek und Sadri Oezdemir
 */
package MasterMind;
/**
*Das Spielbrett enthaelt alle moeglichen Spielfelder. Es verwaltet diese und kann sie ueberpreufen.
*/
public class Spielbrett
{
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
    /**
    * preuft ob die Menge der gesetzten Schwarz, Weiss figuren im Tippfeld tatsaechlich richtig ist
    *@param schwarz ist die Menge an Schwarz die gesetzt sein muessen
    *@param weiss ist die Menge an Weiss die gesetzt sein muessen
    *@return true wenn das Feld richtig gesetzt wurde
    */
    public boolean pruefeWeissSchwarz(int schwarz, int weiss)
    {
        int schwarzGesetzt = 0;
        int weissGesetzt = 0;
        for(Spielfigur tipp: tipp.figuren)
        {
            if(tipp.getFarbe() == Spielfigur.WEISS)
                weissGesetzt++;
            else if(tipp.getFarbe() == Spielfigur.SCHWARZ)
                schwarzGesetzt++;
        }
        return((schwarzGesetzt == schwarz && weissGesetzt == weiss));
    }
    /**
    *algorithmus zur Berechnung der Anzahl der Schwarzen und Weissen Figuren im Tippfeld die vorhanden sein muessen
    *@return true wenn Feld richtig gesetzt wurde
    */
    public boolean pruefeTippFeld()
    {
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
                        schwarzRecall[i] = true;
                        if(weissRecall[i])
                            weiss--;
                        j+=5;
                    }
                    else if(!schwarzRecall[i] && !weissRecall[i])
                    {
                        weiss++;
                        weissRecall[i] = true;
                    }
                }
            }
        }
        return pruefeWeissSchwarz(schwarz, weiss);
    }
    Spielbrett()
    {
        master = new MasterMindFeld();
        versuch = new VersuchsFeld();
        tipp = new TippFeld();
        figuren = new FigurenFeld();
    }
}
