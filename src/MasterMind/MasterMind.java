/**
 * Created by Noctis on 24.05.2017.
 */
package MasterMind;



// Klasse die den Spielfluss bestimmt
public class MasterMind implements Runnable
{
    public Spielbrett getSpielbrett() {
        return spielbrett;
    }

    public void setSpielbrett(Spielbrett spielbrett) {
        this.spielbrett = spielbrett;
    }

    //private StartController controller;
    private Spielbrett spielbrett;
    
    private boolean siegBedingung = false;

    public boolean isSiegBedingung() {
		return siegBedingung;
	}

	public void setSiegBedingung(boolean siegBedingung) {
		this.siegBedingung = siegBedingung;
	}

	public boolean isZugBeenden() {
        return zugBeenden;
    }

    public void setZugBeenden(boolean zugBeenden) {
        this.zugBeenden = zugBeenden;
    }

    private boolean zugBeenden = false;

    public boolean isFeldStatus() {
        return feldStatus;
    }

    public void setFeldStatus(boolean feldStatus) {
        this.feldStatus = feldStatus;
    }

    private boolean feldStatus = true;
    private int versuche = 0;

    public int getFarbe() {
        return farbe;
    }

    public void setFarbe(int farbe) {
        this.farbe = farbe;
    }

    private int farbe = 0;

    public boolean isFarbeGedrueckt() {
        return farbeGedrueckt;
    }

    public void setFarbeGedrueckt(boolean farbeGedrueckt) {
        this.farbeGedrueckt = farbeGedrueckt;
    }

    public boolean isPositionGedrueckt() {
        return positionGedrueckt;
    }

    public void setPositionGedrueckt(boolean positionGedrueckt) {
        this.positionGedrueckt = positionGedrueckt;
    }

    private boolean farbeGedrueckt = false;
    private boolean positionGedrueckt = false;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int position = 0;
    //private GUI gui = new GUI();

    //private MasterMind.MasterMindRegeln regeln;
    public MasterMind()
    {
        try
        {
            spielbrett = new Spielbrett();
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        //regeln = new MasterMind.MasterMindRegeln();
    }
   //Belege tippfeld, die Runde kann erst beendet werden wenn das Feld richtig gesetzt wurde
    private void setzeTippFeld()
    {
        try{
        	feldStatus = false;
        	zugBeenden = false;
        while (!zugBeenden)
        {
        	Thread.sleep(1);
        	if(farbeGedrueckt && positionGedrueckt)
            {
                spielbrett.getTipp().setzeSpielfigur(position, new Spielfigur(farbe));
                farbeGedrueckt = false;
                positionGedrueckt = false;
                for(int i = 0; i < 5; i++)
                    System.out.println("Signal "+versuche+": Position"+i+": "+
                        Integer.toHexString(spielbrett.getTipp().figuren[i].getFarbe()));
            }
                /*System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());*/
                feldStatus = spielbrett.pruefeTippFeld();
        }
    }catch(Exception e){
    	e.printStackTrace();
		System.out.println(e.getMessage());
     }
    }
    //preuft ob das Versuchs Feld dem Master Feld entspricht, also ob die Sieg Bedingung erfuellt ist
    private boolean pruefeSiegBedingung()
    {
        //System.out.println("Siegbedingung");
        for(int i = 0; i < spielbrett.getVersuch().figuren.length; i++)
        {
            if(spielbrett.getVersuch().figuren[i].getFarbe() != spielbrett.getMaster().figuren[i].getFarbe())
            {
                //System.out.println("SiegBedingung nicht erfuellt");
                siegBedingung = false;
                return false;
            }
        }
        siegBedingung = true;
        return true;
    }
    //Setzen des Versuchsfeldes. Die Runde kann erst beendet werden, wenn das Feld richtig gesetzt wurde
    private void setzeVersuchsFeld()
    {
        try{
    	zugBeenden = false;
        feldStatus = false;
        while(!zugBeenden)
        {
        	Thread.sleep(1);
        	if(farbeGedrueckt && positionGedrueckt)
            {
                spielbrett.getVersuch().setzeSpielfigur(position, new Spielfigur(farbe));
                farbeGedrueckt = false;
                positionGedrueckt = false;
                for(int i = 0; i < 5; i++)
                {
                    System.out.println("Versuch "+versuche+": Position"+i+": "+
                            Integer.toHexString(spielbrett.getVersuch().figuren[i].getFarbe()));
                }
            }
                /*System.out.println("Versuch Feld: Position: "+position+" Farbe: "+
                        spielbrett.getVersuch().figuren[position].getFarbe());*/
            feldStatus = spielbrett.getVersuch().pruefeFeldAufGesetzt();

        }
        }catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
    }
    //Setzen des MasterMind Feldes. Die Runde kann erst beendet werden, wenn das Feld richtig gesetzt wurde
    private void setzeMasterMind()
    {
    	try{
        zugBeenden = false;
        feldStatus = false;
    	
        while(!zugBeenden)
        {
        	Thread.sleep(1);
        	if(farbeGedrueckt && positionGedrueckt)
            {
                spielbrett.getMaster().setzeSpielfigur(position, new Spielfigur(farbe));
                farbeGedrueckt = false;
                positionGedrueckt = false;
                for(int i = 0; i < 5; i++)
                {
                    System.out.println("MasterMind: Position"+i+": "+Integer.toHexString(spielbrett.getMaster().figuren[i].getFarbe()));
                }
            }
            feldStatus = spielbrett.getMaster().pruefeFeldAufGesetzt();
        }
    	}
        catch(Exception e)
    	{
    		e.printStackTrace();
    		System.out.println(e.getMessage());
    	}
        
    }

    //Hauptschleife des Spiels. Sequenziertes setzen der Felde und pruefen auf Siegbedingung. Wurde Sieg erreicht,
    //Frage ob Spiel beendet werden soll oder weiter gespielt werden soll
    public void run()
    {
        setzeMasterMind();
        while(versuche < 11 && !siegBedingung)
        {
        	setzeVersuchsFeld();
            if(!pruefeSiegBedingung())
                setzeTippFeld();
            versuche++;
        	spielbrett.setTipp(new TippFeld());
        	spielbrett.setVersuch(new VersuchsFeld());
        }
    }
    
}
