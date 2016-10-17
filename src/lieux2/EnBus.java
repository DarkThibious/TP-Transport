package lieux2;

import java.util.ArrayList;

public class EnBus extends MoyenTransport 
{
    private LigneBus saLigne;
    private static ArrayList<EnBus> lesLignes = new ArrayList<EnBus>();
    
    
    protected EnBus(LigneBus l) 
    {
    	saLigne = l;
    	EnBus.lesLignes.add(this);
    }
    
    public static EnBus getInstance(LigneBus l)
    {
    	for(EnBus eb : EnBus.lesLignes)
    	{
    		if(eb.saLigne.equals(l))
    		{
    			return eb;
    		}
    	}
    	return null;
    }

    public String toString() 
    {
    	return "Ligne Bus [" + saLigne.nom() + "]";
    }
    
    //TODO
    /* Renvoie le temps d'attente du bus qui va de "l1" à "l2" à l'heure dep*/
    public Heure attente(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet
    {
    	if (!this.estPossible(l1, l2, dep)) // lance une erreur si le trajet n'est possible en bus entre "l1" et "l2"  à l'heure "dep"
    	{
    		throw new ErreurTrajet("Arrêt non desservi par cette ligne de bus.");
    	}
    	else //sinon renvoie le temps d'attente
    	{
        	Arret a1 = (Arret)l1;
        	return this.saLigne.attente(a1, dep);
    	}
    }

    //TODO
    /* Renvoie la duree en bus entre "l1" et "l2"*/
    public Heure duree(Lieu l1, Lieu l2, Heure dep) throws ErreurTrajet 
    {
    	if(!this.estPossible(l1, l2, dep)) // lance une erreur si le tajet n'est possible en bus entre "l1" et "l2"  à l'heure "dep"
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
		return this.saLigne.estPossible(a1, a2, dep);
    }
}