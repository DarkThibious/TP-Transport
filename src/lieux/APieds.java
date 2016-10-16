package lieux;

public class APieds extends MoyenTransport 
{

    // Pas vraiment utile. On pourrait en faire un singleton.
    public APieds() {}

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
    
    public boolean equals(Object arg)
    {
    	if (arg == null) { return false; }
		if (arg == this) { return true; }
		if (arg instanceof APieds) 
		{
		    return true;
		} 
		else 
		{ 
			return false; 
		}
    	
    }
}