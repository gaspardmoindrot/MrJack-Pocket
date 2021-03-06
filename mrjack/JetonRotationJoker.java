package mrjack;
import java.util.Scanner;

public class JetonRotationJoker extends JetonAction
{
	private Scanner scanner = new Scanner(System.in);

	public JetonRotationJoker() {
		this.mNom1 = "Rotation";
		this.mNom2 = "Joker";
		this.mPileFace = -1;
	}

	public void fonction1(Plateau plateau) {
		int nb = 0;
		int rota = -1;
		int i;
		int j;

		System.out.println("Tapez un nombre entre 1 et 9 pour selection la case a tourner (1 etant haut / gauche et 9 etant bas / droit)");
		while (!(nb > 0 && nb < 10) || nb == plateau.flag) {
			nb = scanner.nextInt();
			if (!(nb > 0 && nb < 10) || nb == plateau.flag)
				System.out.println("Veuillez retaper un nombre entre 1 et 9 (pas le droit de faire tourner une meme case au sein d'un meme tour)");
		}
		plateau.flag = nb;
		System.out.println("Tapez un nombre entre 1 et 4 pour orienter le mur (1 = nord, 2 = est, 3 = sud et 4 = ouest)");
		while (!(rota > 0 && rota < 5) || plateau.mPlateau[(nb - 1) / 3][(nb - 1) % 3].getPosition() == (rota - 1)) {
			rota = scanner.nextInt();
			if (!(rota > 0 && rota < 5) || plateau.mPlateau[(nb - 1) / 3][(nb - 1) % 3].getPosition() == (rota - 1))
				System.out.println("Veuillez retaper un nombre entre 1 et 4 (oblige de tourner)");
		}
		i = (nb - 1) / 3;
		j = (nb - 1) % 3;
		plateau.mPlateau[i][j].setPosition(rota - 1);
	}

	public void fonction2(Plateau plateau) {
		int nb = 0;
		int perso = 0;

		System.out.println("Tapez 1 pour avancer Holmes, 2 pour Watson et 3 pour Monsieur Le Chien");
		while (perso != 1 && perso != 2 && perso != 3) {
			perso = scanner.nextInt();
			if (perso != 1 && perso != 2 && perso != 3)
				System.out.println("Veuillez retaper 1, 2 ou 3");
		}
		if (plateau.mDetective[perso - 1].getPosition() == 11)
			plateau.mDetective[perso - 1].setPosition(0);
		else
			plateau.mDetective[perso - 1].setPosition(plateau.mDetective[perso - 1].getPosition() + 1);
	}
}
