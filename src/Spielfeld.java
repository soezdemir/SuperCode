/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */
public class Spielfeld
{
    protected static final short GROESSE = 5;

    protected Spielfigur figuren[] = new Spielfigur[GROESSE];
    Spielfeld()
    {
        for(int i = 0; i < GROESSE; i++)

            figuren[i] = new Spielfigur(Spielfigur.WEISS);

    }

    protected void setzeSpielfigur(int position, Spielfigur figur)
    {
        figuren[position] = figur;
    }

    protected boolean pruefeGleichheit(Spielfeld vergleichsFeld)
    {
        for(int i = 0; i < GROESSE; i++)
        {
            if(this.figuren[i].getFarbe() != vergleichsFeld.figuren[i].getFarbe())
                return false;
        }
        return true;
    }
}
