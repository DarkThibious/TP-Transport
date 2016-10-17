package lieux2;

public class CompTemps implements Comparateur 
{
   	/* Renvoie 1 si duree t1 > duree t2
	 * -1 si duree t1 < duree t2
	 * 0 si duree t1 = duree t2
	 */ 
    
    public int compare(Trajet t1, Trajet t2)
    {
    	Heure dureeT1, dureeT2;
        try 
        {
        	dureeT1 = t1.duree();
    	
    	} 
        catch (ErreurTrajet e) 
    	{
        	return 1;
    	}
        try
        {
        	dureeT2 = t2.duree();
        }
        catch (ErreurTrajet e)
        {
        	return -1;
        }
    	return dureeT1.compareTo(dureeT2);
    }
}