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
    //TODO
    public Etape(Lieu d, Lieu a, MoyenTransport m, Heure h) 
    {
    	this.dep = d;
    	this.arr = a;
    	this.moyen = m;
    	this.hdep = h;
    }

    public void liste() 
    {
    	Heure att;
    	Heure arri;
    	try
    	{
    		att = attente();
    		arri = hArrivee();
    	}
    	catch (Exception e)
    	{
    		return;
    	}
    	/* manque encore l'horaire de depart + le delai d'attente */
    	System.out.println("De " + dep.nom() + " a " + arr.nom() + ": "
    				+ moyen.toString() + " [depart: " + hdep + "]" + " [attente: " + att + "]" + " [arrivée: " + arri + "]");
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
    	return moyen.hArrivee(dep, arr, hdep);
    }

    //TODO
    public boolean estPossible() 
    {
    	return moyen.estPossible(dep, arr, hdep);
    }

    //TODO
    public Heure duree() throws ErreurTrajet 
    {
    	return moyen.duree(dep, arr, hdep);
    }

    //TODO
    public Heure attente()  throws ErreurTrajet 
    {
    	return moyen.attente(dep, arr, hdep);
    }
}