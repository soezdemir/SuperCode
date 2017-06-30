/**
 * Created by cpatzek & soezdemir 17/05/2017.
 */


package MasterMind;
import java.util.Random;

public class MasterMindFeld extends Spielfeld
{
    private static int random()
    {
        return new Random().nextInt(8);
    }
    MasterMindFeld()
    {
        super();
    }
}
