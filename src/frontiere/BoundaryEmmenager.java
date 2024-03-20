package frontiere;

import controleur.ControlEmmenager;
import personnages.Gaulois;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois "+nomVisiteur);
					int choixForce = Clavier.entrerEntier("Quelle est votre force ?");
					controlEmmenager.ajouterGaulois(nomVisiteur, choixForce);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		int choixForce, choixForcePotionFaible, choixForcePotionForte;
		System.out.println("Bienvenue druide "+nomVisiteur);
		choixForce = Clavier.entrerEntier("Quelle est votre force ?");
		choixForcePotionFaible = Clavier.entrerEntier("Quelle est la force de la potion la plus faible que vous pouvez produire ?");
		choixForcePotionForte = Clavier.entrerEntier("Quelle est la force de la potion la plus forte que vous pouvez produire ?");
		if(choixForcePotionFaible>choixForcePotionForte) {
			System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum");
			int temp = choixForcePotionFaible;
		    choixForcePotionFaible = choixForcePotionForte;
		    choixForcePotionForte = temp;
		}
		controlEmmenager.ajouterDruide(nomVisiteur, choixForce, choixForcePotionFaible, choixForcePotionForte);
	}
}
