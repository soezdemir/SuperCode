/**
 * Created by Christian Patzek & Sadri Oezdemir on 17/05/2017.
 */
public class Spielbrett
{
    public FigurenFeld getFiguren() {
        return figuren;
    }

    public void setFiguren(FigurenFeld figuren) {
        this.figuren = figuren;
    }

    public MasterMindFeld getMaster() {
        return master;
    }

    public void setMaster(MasterMindFeld master) {
        this.master = master;
    }

    public VersuchsFeld getVersuch() {
        return versuch;
    }

    public void setVersuch(VersuchsFeld versuch) {
        this.versuch = versuch;
    }

    private MasterMindFeld master;
    private VersuchsFeld versuch;

    public TippFeld getTipp() {
        return tipp;
    }

    public void setTipp(TippFeld tipp) {
        this.tipp = tipp;
    }

    private TippFeld tipp;
    private FigurenFeld figuren;

    Spielbrett()
    {
        master = new MasterMindFeld();
        versuch = new VersuchsFeld();
        tipp = new TippFeld();
        figuren = new FigurenFeld();
    }
}
