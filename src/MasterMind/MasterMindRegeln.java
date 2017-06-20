package MasterMind;

/**
 * Created by Noctis on 24.05.2017.
 */
//wird noch nicht benoetigt. Vlt in Zukunft zum Auslagern von Code
public class MasterMindRegeln
{
    public boolean isBeendeZug() {
        return beendeZug;
    }

    public void setBeendeZug(boolean beendeZug) {
        this.beendeZug = beendeZug;
    }

    private boolean beendeZug = false;

    public boolean isSiegBedingung() {
        return siegBedingung;
    }

    public void setSiegBedingung(boolean siegBedingung) {
        this.siegBedingung = siegBedingung;
    }

    private boolean siegBedingung = false;
/*
    public void pruefeSiegBedingung()
    {
        for(int i)
    }*/
}
