package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commencer ici.");
		}else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un étal.");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un étal pour vous !\n"
				+ "Il me faudrait quelques renseignements :");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous en vendre ?");
		int numEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numEtal != -1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+numEtal);
		}
	}
}
