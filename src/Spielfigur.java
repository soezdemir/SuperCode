/**
 * Created by geht dich mo gor nix on 17/05/2017.
 */
import java.util.*;

public class Spielfigur
{
    // Farben in hex: rot=DF1818, gr�n=18DF18, blau=1839DE, lila=DE18DF, gelb=DEDF18, orange=DE5A18, pink = DE5A82
    // hellgr�n = 9CDF18, schwarz = 0, wei�=FFFFFF
    public static final int ROT = 0xDF1818;
    public static final int GR�N = 0x18DF18;
    public static final int BLAU = 0x1839DE;
    public static final int LILA = 0xDE18DF;
    public static final int GELB = 0xDEDF18;
    public static final int ORANGE = 0xDE5A18;
    public static final int PINK = 0xDE5A82;
    public static final int HELLGR�N = 0x9CDF18;
    public static final int SCHWARZ = 0;
    public static final int WEI�= 0xFFFFFF;
    public static final int GR��E = 5;
    public static final ArrayList<int> farben = new ArrayList<int>{ROT, GR�N, BLAU, LILA, GELB, ORANGE, PINK, HELLGR�N,
        SCHWARZ, WEI�};
    Spielfigur(int farbe)
    {
        this.farbe = farbe;
    }
    private int farbe;
}