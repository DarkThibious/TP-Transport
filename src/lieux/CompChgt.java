package lieux;

public class CompChgt implements Comparateur 
{
	public int compare(Trajet t1, Trajet t2) 
    {
        //throw new UnsupportedOperationException(); // à changer !
        int chgt1, chgt2;
	    try
	    {
	        chgt1 = t1.nbChgt();
	    }
	    catch (ErreurTrajet e)
	    {
	        return 1;
	    }
	    try
	    {
	        chgt2 = t2.nbChgt();
	    }
	    catch (ErreurTrajet e)
	    {
	    	return -1;
	    }
	    if(chgt1>chgt2)
	    {
	        return 1;
	    }
	    else if(chgt1<chgt2)
	    {
	        return -1;
	    }
	    else
	    {
	        return 0;
	    }
    }
}

