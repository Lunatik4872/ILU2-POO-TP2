package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infoMache = controlAfficherMarche.donnerInfoMarche();
		if(infoMache.length == 0) {
			System.out.println("Le marché est vide, revenez plus tard.");
		}else {
			System.out.println(nomAcheteur+", vous trouverez au marché :");
			int i = 0;
			while(i < infoMache.length) {
				System.out.println("- "+infoMache[i++]+" qui vend "+infoMache[i++]+" "+infoMache[i++]);
			}
		}
	}
}
