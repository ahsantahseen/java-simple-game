package game;

import java.util.Random;
import java.util.Scanner;
import game.game_items;

public class main_game {

public static void main(String[] args) {
	// System objects
	Scanner in = new Scanner(System.in);
	Random rand = new Random();
	boolean running = true;
    
	//Class Object 
	
	game_items game=new game_items();
	
	
	System.out.println("Welcome to the dungeon!");

	// Label
	GAME: while (running) {
		System.out.println("--------------------------------------");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|LOOKS LIKE YOUVE MET AN ENEMY \t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("|\t\t\t\t\t|");
		System.out.println("--------------------------------------");

		int enemyHealth = rand.nextInt(game.maxEnemyHealth);
		String enemy = game.enemies[rand.nextInt(game.enemies.length)];
		System.out.println("\t# " + enemy + " has appeared! #\n");

		while (enemyHealth > 0) {
			System.out.println("\tYour HP: " + game.health);
			System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
			System.out.println("\n\tWhat would you like to do?");
			System.out.println("\t1. Attack");
			System.out.println("\t2. Drink health potion");
			System.out.println("\t3. Run");

			String input = in.nextLine();
			if (input.equals("1")) {
				int damageDealt = rand.nextInt(game.attackDmg);
				int damageTaken = rand.nextInt(game.enemyAttackDamage);

				enemyHealth -= damageDealt;
				game.health -= damageTaken;

				System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage");
				System.out.println("\t> You recieved " + damageTaken + " in retaliation");

				if (game.health < 1) {
					System.out.println("\t You have taken too much damage, you are too weak to go on");
					break;
				}
			} else if (input.equals("2")) {

				if (game.numHealthPots > 0) {
					game.health += game.healthPotionHealAmount;
					game.numHealthPots--;
					System.out.println("\t> You drank a health potion, healed for: " + game.healthPotionHealAmount + "."
							+ "\n\t> You now have" + game.health + "HP." + "\n\t> You now have" + game.numHealthPots
							+ " health potions left.\n");
				} else {
					System.out.println("\t> You have no health potions, defeat enemies for a chance to get one");
				}

			} else if (input.equals("3")) {
				System.out.println("\t> You run away from the " + enemy);
				continue GAME;
			} else {
				System.out.println("\tInvalid command");
			}
		}
		if (game.health < 1) {
			System.out.println("You limp out of the dungeon, weak from battle.");
			break;
		}
		System.out.println("--------------------------------------");
		System.out.println(" # " + enemy + " was defeated! # ");
		System.out.println(" # You have " +game.health + "HP left # ");
		// If the random number is less than 50 it drops
		if (rand.nextInt(100) < game.healthPotionDropChance) {
			game.numHealthPots++;
			System.out.println(" # The " + enemy + " dropped a health potion. # ");
			System.out.println(" # You now have " + game.numHealthPots + " health potion(s). # ");
		}
		System.out.println("--------------------------------------");
		System.out.println("What would you like to do now?");
		System.out.println("1. Continue fighting");
		System.out.println("2. Exit dungeon");
		String input = in.nextLine();

		while (!input.equals("1") && !input.equals("2")) {
			System.out.println("invalid command");
			input = in.nextLine();

		}
		if (input.equals("1")) {
			System.out.println("You continue your adventure.");
		} else if (input.equals("2")) {
			System.out.println("You exit the dungeon.");
			break;
		}
	}
	in.close();
	System.out.println("######################");
	System.out.println("# THANKS FOR PLAYING #");
	System.out.println("######################");
}
}
	


