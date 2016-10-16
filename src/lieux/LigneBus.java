package lieux;
import java.util.ArrayList;

public class LigneBus 
{
	protected String nomLigne;
	protected ArrayList<Arret> sesArrets;
	protected Heure[] sesDeparts;
	protected Heure[] sesTemps;

	public LigneBus(String nom) 
	{
		nomLigne = nom;
	}

	public void addArrets(Arret[] lesArrets)
	{
		sesArrets = new ArrayList<Arret>();
		for(Arret a : lesArrets) 
		{
			a.ajoutLigne(this);
			sesArrets.add(a);
		}
	}

	public String nom() 
	{
		return nomLigne;
	}

	/* pour simplifier on suppose que les durees de deplacement sont
	 * independantes de l'heure. Pour definir les horaires il suffit de donner
	 * les heures de depart ainsi que les durees entre 2 arrets successifs.
	 * La dimension du tableau des horaires doit etre egale au nombre d'arrets
	 * de la ligne moins 1.
	 * 
	 * Attention: une ligne de bus est orientee. Les horaires sont donnes dans
	 * le sens de parcours. Si on veut aussi pouvoir parcourir une ligne dans
	 * l'autre sens, il faut creer une deuxieme ligne !
	 * On suppose enfin que les lignes ne sont pas circulaires,
	 */
	public void ajoutHoraires(Heure[] horaire, Heure[] hdepart) throws ErreurTrajet 
	{
		if (horaire.length != sesArrets.size() - 1) 
		{
			throw new ErreurTrajet("Horaire mal formatte");
		}
		sesDeparts = hdepart;
		sesTemps = horaire;
	}

	//TODO
	public boolean estPossible(Arret a1, Arret a2, Heure dep)
	{
		Heure dernierBus;

		if(sesArrets.indexOf(a1) != -1 && sesArrets.indexOf(a2) != -1)
		{
			try 
			{
				dernierBus = this.sesDeparts[this.sesDeparts.length-1].add(dureeEnBus(this.sesArrets.get(0),a1));
			} 
			catch(Exception e)
			{
				return false;
			}
			if(dernierBus.compareTo(dep) >= 0)
			{
				return true;
			}
		}
		return false;
	}

	// On suppose que la duree de transport entre deux arrets ne depend pas
	// de l'heure et qu'on n'arrive jamais le lendemain du jour de depart.
	//TODO
	public Heure dureeEnBus(Arret a1, Arret a2) throws ErreurTrajet 
	{
		int indDep, indArr;
		indDep = this.sesArrets.indexOf(a1);
		indArr = this.sesArrets.indexOf(a2);
		if(indDep == -1 || indArr == -1)
		{
			throw new ErreurTrajet("Arrêt non desservi par cette ligne de bus.");
		}
		else if(indDep > indArr)
		{
			throw new ErreurTrajet("Faites demi-tour. Faites demi-tour. Faites demi-tour.");
		}

		else
		{
			if(a1.equals(a2))
			{
				return new Heure();
			}
			int i;
			Heure h = new Heure();
			for(i = indDep; i<indArr-1;i++)
			{
				try 
				{
					h = h.add(this.sesTemps[i]);
				} catch (ErreurHeure e) 
				{
					throw new ErreurTrajet("Problème de calcul de la duree du trajet");
				}
			}
			return h;
		}
	}

	//TODO
	public Heure attente(Arret a, Heure h) throws ErreurTrajet 
	{
		int indDep;
		indDep = this.sesArrets.indexOf(a);

		if(indDep == -1) // vérifier que l'arrêt donné en paramètre est bien sur la ligne de bus
		{
			throw new ErreurTrajet("Arrêt non desservi par cette ligne de bus.");
		}
		else
		{
			Heure tempsAttente = dureeEnBus(this.sesArrets.get(0), a); // duree que le bus met entre le 1er arret et l'arret a 
			Heure arrivee = this.sesDeparts[0];
			boolean b = true;
			int i = 0;
			while(b)
			{
				arrivee = this.sesDeparts[i];
				try
				{
					arrivee = arrivee.add(tempsAttente); // calcul de l'heure à laquelle le bus arrive
					
				} catch (ErreurHeure e) 
				{
					throw new ErreurTrajet("Problème avec les horaires");
				}
				if (arrivee.compareTo(h) == -1)
				{
					i = i+1;
				}
				else
				{
					b = false;
				}
			}
			if(i == this.sesDeparts.length) // dernier bus dejà passé
			{
				throw new ErreurTrajet("Il n'y a plus aucun bus à cette heure-ci.");
			}
			else // sinon on retourne le temps qu'il doit attendre avant le prochain bus
			{
				Heure attente;
				try 
				{
					attente = h.delaiAvant(arrivee); // calcul temps d'attente
				} catch (ErreurHeure e) 
				{
					throw new ErreurTrajet("Problème avec les horaires");
				}
				return attente;
			}
		}
	}
}