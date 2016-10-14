package lieux;

public class EnBus extends MoyenTransport 
{
    private LigneBus saLigne;

    public EnBus(LigneBus l) 
    { 
    	saLigne = l;
    }

    public String toString() 
    {
    	return "Ligne Bus [" + saLigne.nom() + "]";
    }
    
    //TODO
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet
    {
    	return null;
    }

    //TODO
    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	return null;
    }

    //TODO
    public boolean estPossible(Lieu l1, Lieu l2, Heure dep)
    {
    	return false;
    }
}