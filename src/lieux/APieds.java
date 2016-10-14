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
    	return false;
    }

    //TODO
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	return null;
    }

    // duree du voyage de l1 a l2, hors temps d'attente, a l'heure dep selon
    // ce moyen de transport
    //TODO
    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	return null;
    }
}