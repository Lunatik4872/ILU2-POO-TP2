package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur){
	    if(!controlAcheterProduit.isInVillage(nomAcheteur)){
	        System.out.println("Désolé mais seul les habitant du village peuvent acheter des produits");
	        return;
	    }
	    String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
	    String[] listeVendeur = controlAcheterProduit.listVendeur(produit);
	    if(listeVendeur == null || listeVendeur.length == 0){
	        System.out.println("Désolé, personne ne vend ce produit au marché.");
	        return;
	    }
	    String list = "";
		for (int i = 0; i < listeVendeur.length; i++) {
			list+= ""+(i+1)+" - "+listeVendeur[i]+"\n";
		}
	    int vendeur = Math.min(Clavier.entrerEntier("Chez quel commerçant voulez-vous acheter des "+produit+" \n"+list)-1, listeVendeur.length - 1);
	    System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+listeVendeur[vendeur]+"\nBonjour "+nomAcheteur+"\n");
	    int nbAcheter = Clavier.entrerEntier("Combien de "+produit+" voulez-vous acheter ?");
	    int resAcheter = controlAcheterProduit.acheterProduit(listeVendeur[vendeur], nbAcheter);
	    switch (resAcheter){
	        case -1:
	            System.out.println("Vous ne pouvez pas acheter un nombre négatif ou nul de produit !");
	            break;
	        case 0:
	            System.out.println(nomAcheteur+" veut acheter "+nbAcheter+" "+produit+", malheureusement il n’y en a plus !");
	            break;
	        default:
	            String message = resAcheter < nbAcheter ? 
	                nomAcheteur+" veut acheter "+nbAcheter+" "+produit+", malheureusement "+listeVendeur[vendeur]+" n’en a plus que "+resAcheter+". "+nomAcheteur+" achète tout le stock de "+listeVendeur[vendeur]+"." :
	                nomAcheteur+" achète "+nbAcheter+" "+produit+" à "+listeVendeur[vendeur];
	            System.out.println(message);
	            break;
	    }
	}
}
