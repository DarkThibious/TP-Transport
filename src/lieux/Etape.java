package lieux;

public class Etape 
{
    private Lieu dep, arr;
    private MoyenTransport moyen;
    private Heure hdep;

    /* Pour l'instant on autorise la creation d'une etape meme si
     * elle n'utilise pas un moyen de transport possible entre ces
     * lieux a cette heure.
     */
    public Etape(Lieu d, Lieu a, MoyenTransport m, Heure h) {}

    public void liste() 
    {
    	/* manque encore l'horaire de depart + le delai d'attente */
    	System.out.println("De " + dep.nom() + " a " + arr.nom() + ": "
    				+ moyen.toString() + " [depart: " + hdep + "]");
    }

    public MoyenTransport moyen() 
    { 
    	return moyen; 
    }

    public Lieu depart() 
    { 
    	return dep; 
    }

    public Lieu arrivee() 
    { 
    	return arr; 
    }

    public Heure hDepart() 
    { 
    	return hdep; 
    }

    //TODO
    public Heure hArrivee() throws ErreurTrajet 
    {
    	return null;
    }

    //TODO
    public boolean estPossible() 
    {
    	return false;
    }

    //TODO
    public Heure duree() throws ErreurTrajet 
    {
    	return null;
    }

    //TODO
    public Heure attente()  throws ErreurTrajet 
    {
    	return null;
    }
}