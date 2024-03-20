package controleur;

import java.util.Iterator;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public boolean isInVillage(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public String[] listVendeur(String produit){
	    String[] lesVillageois = village.donnerVillageois();
	    String[] temp = new String[lesVillageois.length];
	    int count = 0;
	    for (int i = 0; i < lesVillageois.length; i++) {
	        if(controlTrouverEtalVendeur.trouverEtalVendeur(lesVillageois[i]) != null && controlTrouverEtalVendeur.trouverEtalVendeur(lesVillageois[i]).contientProduit(produit)) {
	            temp[count] = lesVillageois[i];
	            count++;
	        }
	    }
	    if(count==0) return null;
	    String[] list = new String[count];
	    System.arraycopy(temp, 0, list, 0, count);
	    return list;
	}

	
	public int acheterProduit(String nomVendeur,int quantite){
		return quantite <= 0 ? -1 : controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur).acheterProduit(quantite);
	}
}

