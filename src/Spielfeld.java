/**
 * Created by Christian Patzek & Sadri Oezdemir on 17/05/2017.
 */

/*
 * Spielfeld haelt Spielfiguren. Klasse von der allen anderen spezifischen Felder erben
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
            figuren[i] = new Spielfigur(Spielfigur.GRAU);

    }
    //pruefe ob die Farben der Felder richtig gesetzt sind
    protected boolean pruefeFeldAufGesetzt()
    {
        for(Spielfigur figur: figuren)
        {
            if(figur.getFarbe() == Spielfigur.GRAU || figur.getFarbe() == Spielfigur.SCHWARZ
                    || figur.getFarbe() == Spielfigur.WEISS)
                return true;


        }
        return false;
    }
    protected void setzeSpielfigur(int position, Spielfigur figur)
    {
        figuren[position] = figur;
    }
    //pruefe ob zwei Felder gleich sind
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
