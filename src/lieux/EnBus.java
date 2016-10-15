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
    /* Renvoie le temps d'attente du bus qui va de "l1" à "l2" à l'heure dep*/
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet
    {
    	if (this.estPossible(l1, l2, dep) == false) // lance une erreur si le tajet n'est possible en bus entre "l1" et "l2"  à l'heure "dep"
    	{
    		throw new ErreurTrajet("Arrêt non desservi par cette ligne de bus.");
    	}
    	else //sinon renvoie le temps d'attente
    	{
        	Arret a1 = (Arret)l1;
        	Arret a2 = (Arret)l2;
        	Heure attenteBus = new Heure();
    		attenteBus = this.saLigne.attente(a1, dep);
    		return attenteBus;
    	}

    }

    //TODO
    /* Renvoie la duree en bus entre "l1" et "l2"*/
    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	if(this.estPossible(l1, l2, dep) == false) // lance une erreur si le tajet n'est possible en bus entre "l1" et "l2"  à l'heure "dep"
    	{
    		throw new ErreurTrajet("non desservi");
    	}
    	else // sinon renvoie la duree
    	{
    		Arret a1 = (Arret)l1;
        	Arret a2 = (Arret)l2;
        	Heure dureeBus = this.saLigne.dureeEnBus(a1, a2);
        	return dureeBus;
    	}
    }

    //TODO
    /* Renvoie vrai si le chemin est possible en bus entre "l1" et "l2"  à l'heure "dep" 
     * faux sinon*/
    public boolean estPossible(Lieu l1, Lieu l2, Heure dep)
    {
    	Arret a1 = (Arret)l1;
    	Arret a2 = (Arret)l2;
    	try 
    	{
				if(this.saLigne.estPossible(a1, a2, dep) == true)
				{
					return true;
				}
		} 
    	catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return false;
    }
}