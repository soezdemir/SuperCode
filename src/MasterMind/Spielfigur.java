/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */
package MasterMind;
//Spielfiguren haben nur eine Farbe die aus Konstanten auswaehlbar ist
public class Spielfigur
{
    // FARBEN in hex: rot=DF1818, gruen=18DF18, blau=1839DE, lila=DE18DF, gelb=DEDF18, orange=DE5A18, pink =
//DE5A82
    // hellgruen = 9CDF18, schwarz = 0, weiss=FFFFFF
    public static final int ROT = 0xDF1818;
    public static final int GRUEN = 0x18DF18;
    public static final int BLAU = 0x1839DE;
    public static final int LILA = 0xDE18DF;
    public static final int GELB = 0xDEDF18;
    public static final int ORANGE = 0xDE5A18;
    public static final int PINK = 0xDE5A82;
    public static final int HELLGRUEN = 0x9CDF18;
    public static final int SCHWARZ = 0;
    public static final int WEISS= 0xFFFFFF;
    public static final int GRAU = 0x5A5A5A;
    public static final int GROESSE = 5;
    public static final int[] FARBEN = {ROT, GRUEN, BLAU, LILA, GELB, ORANGE, PINK, HELLGRUEN, SCHWARZ, WEISS, GRAU};

    Spielfigur(int farbe)
    {
        this.farbe = farbe;
    }

    public int getFarbe() {
        return farbe;
    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }
    private int farbe;
}
