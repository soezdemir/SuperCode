/**
 * Created by cpatzek & soezdemir  17/05/2017.
 */
public class FigurenFeld extends Spielfeld
{
    public static final int GROESSE = 8;
    private Spielfigur figuren[] = new Spielfigur[GROESSE];
    FigurenFeld()
    {
        super();
        for(int i = 5; i < GROESSE; i++)
        {
            figuren[i] = new Spielfigur(Spielfigur.FARBEN[i]);
        }
    }
}
