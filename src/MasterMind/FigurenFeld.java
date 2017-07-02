/**
 * Created by cpatzek & soezdemir 17/05/2017.
 *@author : Christian Patzek
 */


package MasterMind;

/**
* Feld das alle Spielfiguren und Ihre Farben haelt zur Auswahl in der GUI
*/
public class FigurenFeld extends Spielfeld
{
    public static final int GROESSE = 10;
    private Spielfigur figuren[] = new Spielfigur[GROESSE];
    FigurenFeld()
    {
        for(int i = 0; i < GROESSE; i++)
        {
            figuren[i] = new Spielfigur(Spielfigur.FARBEN[i]);
        }
    }
}
