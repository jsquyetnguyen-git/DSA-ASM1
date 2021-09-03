package Asm1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner cs = new Scanner(System.in);
		boolean cont = false;

		Algorithm aL = new Algorithm();

		do {
			showMenu();
			int functionID = 0;
			try {
				functionID = cs.nextInt();
			} catch (Exception e) {
				System.out.println("\n<< INVALID ID >> INPUT FUNCTION ID (0-7)!");
				cont = true;
			}
			switch (functionID) {

			// Input
			case 1:
				aL.inputData();
				break;

			// Output
			case 2:
				aL.readF();
				break;

			// Bubble Sort
			case 3:
				aL.bubbleSort();
				break;

			// Selection Sort
			case 4:
				aL.selectionSort();
				break;

			// Insert Sort
			case 5:
				aL.insertionSort();
				break;

			// Linear search > value
			case 6:
				aL.linearSearch();
				break;

			// Binary search = value
			case 7:
				aL.binarySearch();
				break;

			// Exit
			case 0:
				System.out.println("GOOD BYE!");
				System.exit(0);
				break;

			default:
				System.out.println("\n<< INVALID ID >> INPUT FUNCTION ID (0-7)!");
				break;
			}

			System.out.println("\n\n[1] - SHOW FUNCTION MENU | [2] - EXIT");
			int temp = cs.nextInt();
			if (temp == 1)
				cont = true;
			else {
				System.out.println("GOOD BYE!");
				cont = false;
			}
		} while (cont);

	}

	// Hien thi menu chuc nang
	public static void showMenu() {

		System.out.println("\n|------------------------------------------|");
		System.out.println("|****************** MENU ******************|");
		System.out.println("|------------------------------------------|");
		System.out.println("|       [1] INPUT                          |");
		System.out.println("|       [2] OUTPUT                         |");
		System.out.println("|       [3] BUBBLE SORT                    |");
		System.out.println("|       [4] SELECTION SORT                 |");
		System.out.println("|       [5] INSERTION SORT                 |");
		System.out.println("|       [6] SEARCH > VALUE                 |");
		System.out.println("|       [7] SEARCH = VALUE                 |");
		System.out.println("|       [0] EXIT                           |");
		System.out.println("|__________________________________________|");
		System.out.print("\n>> INPUT FUNCTION ID: ");
	}

}
