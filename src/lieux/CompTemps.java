package lieux;

public class CompTemps implements Comparateur 
{
   	/* Renvoie 1 si duree t1 > duree t2
	 * -1 si duree t1 < duree t2
	 * 0 si duree t1 = duree t2
	 */ 
    
    public int compare(Trajet t1, Trajet t2)
    {
    	//throw new UnsupportedOperationException(); // à changer !
    	//throw new ErreurHeure();
        	try 
        	{
    			Heure dureeT1 = t1.duree();
    			Heure dureeT2 = t2.duree();
    			return dureeT1.compareTo(dureeT2);
    		} 
        	catch (ErreurTrajet e) 
    		{
        		
    		}
        	
        	 
        
    }
}