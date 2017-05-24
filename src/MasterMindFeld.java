import java.util.Random;

public class MasterMindFeld extends Spielfeld
{
    private static int random()
    {
        return new Random().nextInt(8);
    }
    MasterMindFeld()
    {
        System.out.println("Konstruktor MasterMindFeld");
        for(int i = 0; i < GROESSE; i++)
        {
            figuren[i] = new Spielfigur(Spielfigur.FARBEN[random()]);
            System.out.println("Position: "+i+"Farbe: "+figuren[i].getFarbe());
        }

    }
}
