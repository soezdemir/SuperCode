/**
 * Created by cpatzek & soezdemir 17/05/2017.
 *@author: Christian Patzek
 */
package MasterMind;
/**
 * Spielfeld haelt Spielfiguren. Klasse von der allen anderen spezifischen Felder erben
 */
public class Spielfeld
{
   protected static final short GROESSE = 5;
    protected Spielfigur figuren[] = new Spielfigur[GROESSE];
    Spielfeld()
    {
        for(int i = 0; i < GROESSE; i++)
            figuren[i] = new Spielfigur(Spielfigur.GRAU);

    }
    /**
    *pruefe ob die Farben der Felder richtig gesetzt sind
    *@return true wenn das Feld richtig gesetzt wurde, sprich alle Felder wurden mit Farben außer Schwarz,Weiss und Grau gesetzt
    */
    protected boolean pruefeFeldAufGesetzt()
    {
        for(Spielfigur figur: figuren)
        {
            if(figur.getFarbe() == Spielfigur.GRAU || figur.getFarbe() == Spielfigur.SCHWARZ
                    || figur.getFarbe() == Spielfigur.WEISS)
                return false;


        }
        return true;
    }
    protected void setzeSpielfigur(int position, Spielfigur figur)
    {
        figuren[position] = figur;
    }
    /**
    *pruefe ob zwei Felder gleich sind
    *@return true wenn die Felder gleich sind
    */
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
