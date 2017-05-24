/**
 * Created by Christian Patzek & Sadri Oezdemir on 17/05/2017.
 */
public class Spielfeld
{
    // FARBEN in hex: rot=DF1818, gruen=18DF18, blau=1839DE, lila=DE18DF, gelb=DEDF18, orange=DE5A18, pink =
//DE5A82
    // hellgruen = 9CDF18, schwarz = 0, weiss=FFFFFF
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
