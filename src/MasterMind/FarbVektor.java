/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */


package MasterMind;
import java.util.Vector;


//Dies war eine Testklasse fuer die Pruefung des Tippfeldes. Deprecated
public class FarbVektor
{
    public int getFarbe() {
        return farbe;
    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }

    private int farbe = 0x5A5A5A;

    public int getSchwarz() {
        return schwarz;
    }

    public void setSchwarz(int schwarz) {
        this.schwarz = schwarz;
    }

    private int schwarz;

    public int getWeiss() {
        return weiss;
    }

    public void setWeiss(int weiss) {
        this.weiss = weiss;
    }

    private int weiss ;

    FarbVektor(int farbe)
    {
        this.farbe = farbe;
        schwarz = 0;
        weiss = 0;
    }

    public void erhoeheAnzahlSchwarz()
    {
        if(weiss > 0)
        {
            weiss--;
        }
        schwarz++;
    }

    public void erhoeheAnzahlWeiss(){weiss++;}
}
