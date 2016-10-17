package lieux2;

public class APieds extends MoyenTransport 
{
	public static APieds instance = null;
	
    // Pas vraiment utile. On pourrait en faire un singleton.
    private APieds() 
    {}
    
    public static APieds getInstance()
    {
    	if (APieds.instance == null)
    	{
    		APieds.instance = new APieds();	
    	}
    	return APieds.instance;
    }
    
    public String toString() 
    { 
    	return "A Pieds"; 
    }

    //TODO
    public boolean estPossible(Lieu l1, Lieu l2, Heure dep) 
    {
    	return l1.estVoisin(l2);
    }

    //TODO
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	return new Heure();
    }

    // duree du voyage de l1 a l2, hors temps d'attente, a l'heure dep selon
    // ce moyen de transport
    //TODO
    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	return l1.distance(l2);
    }
}