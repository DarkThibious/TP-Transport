package lieux2;

public class CompAttente implements Comparateur 
{
	/* Renvoie 1 si attente t1 > attente t2
	 * -1 si attente t1 < attente t2
	 * 0 si attente t1 = attente t2
	 */ 
	public int compare(Trajet t1, Trajet t2) 
    {
        Heure attente1, attente2;
        try
        {
            attente1 = t1.attente();
        }
        catch (ErreurTrajet e)
        {
            return 1;
        }
        try
        {
            attente2 = t2.attente();
        }
        catch (ErreurTrajet e)
        {
            return -1;
        } 
        return attente1.compareTo(attente2);
    }
}