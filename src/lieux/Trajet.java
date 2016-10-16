package lieux;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class Trajet {
    private String nom;
    private Lieu depart;
    private Lieu arrivee;
    private Heure dateDepart;
    private ArrayList<Etape> sesEtapes;

    public Trajet(String n, Lieu dep, Lieu arr, Heure d,
		  ArrayList<Etape> etapes) 
    {
		nom = n;
		depart = dep;
		arrivee = arr;
		dateDepart = d;
		sesEtapes = etapes;
    }

    public String nom() 
    { 
    	return nom; 
    }

    public Lieu depart() 
    { 
    	return depart; 
    }

    public Lieu arrivee() 
    { 
    	return arrivee; 
    }

    public void liste() 
    {
    	System.out.println("Trajet " + nom + " de " + depart.nom() + " a " 
    			+ arrivee.nom() + ", depart a " + dateDepart + " :");
    	for(Etape e: sesEtapes) e.liste();
    }

    //TODO
    public boolean estCoherent() 
    {
    	if(sesEtapes.size()==0)
    	{
    		return false;
    	}
    	int i=0;
    	while(i<this.sesEtapes.size()-1)
    	{
    		try
    		{
    			/* le trajet est coherent
    			 * si toutes les etapes sont possibles
    			 * ET l'heure d'arrivée de l'etape i < heure de depart de l'etape i+1 
    			 * ET l'arrivéé de l'etape i = depart de l'etape i+1
    			 * */
    			 
				if ( this.sesEtapes.get(i).estPossible() && 
					 (this.sesEtapes.get(i).hArrivee().compareTo(this.sesEtapes.get(i+1).hDepart()) <= 0) &&
					 (this.sesEtapes.get(i).arrivee().equals(this.sesEtapes.get(i+1).depart())))
				{

					i=i+1;
				}
				else
				{
					return false;
				}
			} 
    		catch (ErreurTrajet e) {
				return false;
			}
    	}
    	return this.sesEtapes.get(this.sesEtapes.size()-1).estPossible();
    	}

    //TODO
    public Heure hArrivee() throws ErreurTrajet 
    {
    	// L'heure d'arrivée du trajet est l'heure d'arrivée de la dernière étape
    	return this.sesEtapes.get(this.sesEtapes.size()-1).hArrivee();
    }

    //TODO
    public Heure duree() throws ErreurTrajet 
    {
    	Heure dureeTrajet = new Heure();

    	// La duree du trajet est l'heure d'arrivée - heure de depart
    	try 
    	{
			dureeTrajet = dateDepart.delaiAvant(this.hArrivee());
		} 
    	catch (ErreurHeure e) 
    	{
			throw new ErreurTrajet("Problème avec les horaires");
		}
    	return dureeTrajet;
    }

    //TODO
    public Heure attente() throws ErreurTrajet 
    {
    	int i = 0;
    	Heure tempsAttente = new Heure();
    	for(i=0;i<this.sesEtapes.size();i++)
    	{
    		try 
    		{
				tempsAttente = tempsAttente.add(this.sesEtapes.get(i).attente());
			} 
    		catch (ErreurHeure e) 
    		{
    			throw new ErreurTrajet("Problème avec les horaires");
			}
    	}
    	return tempsAttente;
    }
    
    //TODO
    public int nbChgt() throws ErreurTrajet 
    {
    	return 0;
    }


    public static Trajet meilleur(Collection<Trajet> col, Comparateur comp)
    throws ErreurTrajet 
    {
    	return null;
    }

}