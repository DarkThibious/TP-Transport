package lieux;

public class CompAttente implements Comparateur 
{
	/* Renvoie 1 si attente t1 > attente t2
	 * -1 si attente t1 < attente t2
	 * 0 si attente t1 = attente t2
	 */ 
    public int compare(Trajet t1, Trajet t2) 
    {
    	throw new UnsupportedOperationException(); // à changer !
/*
    	int retour;
		try 
		{
			retour = t1.attente().compareTo(t2.attente());
	    	return retour; 
		} 
		catch (ErreurTrajet e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
			//return t1.attente().compareTo(t2.attente());
    }
}