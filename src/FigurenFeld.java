/**
 * Created by cpatzek & soezdemir  17/05/2017.
 */
public class FigurenFeld extends Spielfeld
{
    public static final int GROESSE = 8;
    FigurenFeld()
    {
        figuren[0] = new Spielfigur(Spielfigur.WEISS);
    }
}
