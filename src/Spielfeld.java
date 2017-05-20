/**
 * Created by Christian Patzek & Sadri Oezdemir on 17/05/2017.
 */
public class Spielfeld
{
    // Farben in hex: rot=DF1818, gr�n=18DF18, blau=1839DE, lila=DE18DF, gelb=DEDF18, orange=DE5A18, pink = DE5A82
    // hellgr�n = 9CDF18, schwarz = 0, wei�=FFFFFF
    public static final short GR��E = 5;
    protected Spielfigur figuren[];
    Spielfeld()
    {
        for(int i = 0; i < GR��E; i++)
        {
            figuren[i] = new Spielfigur(Spielfigur.WEI�);
        }
    }

    protected void setzeSpielfigur(int position, Spielfigur figur)
    {
        figuren[position] = figur;
    }
}