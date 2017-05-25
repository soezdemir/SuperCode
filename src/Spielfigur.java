/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */
public class Spielfigur
{
    public static final int ROT = 0xDF1818;
    public static final int ORANGE = 0xFF6A00;
    public static final int GELB = 0xFFF500;
    public static final int BLAU = 0x183DFF;
    public static final int GRUEN = 0x00B712;
    public static final int HELLGRUEN = 0xB6FF00;
    public static final int PINK = 0xFF7FD5;
    public static final int LILA = 0xB200FF;
    public static final int SCHWARZ = 0x000000;
    public static final int WEISS= 0xFFFFFF;

    public static final int[] FARBEN = {ROT, GRUEN, BLAU, LILA, GELB, ORANGE, PINK, HELLGRUEN, SCHWARZ, WEISS};

    public static final int GROESSE = 5;

    public int getFarbe() {
        return farbe;
    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }

    private int farbe;

    Spielfigur(int farbe)
    {
        this.farbe = farbe;
    }
}
