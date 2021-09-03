package Asm1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Algorithm {

	int n = 0;
	float[] a;
	float[] b;
	Scanner cs = new Scanner(System.in);

	Algorithm() {
	}

	public void inputData() throws IOException {
		System.out.print("INPUT ELEMENTS: ");
		n = cs.nextInt();
		float[] temArr = new float[n];

		for (int i = 0; i < n; i++) {
			System.out.print("a[" + i + "]: ");
			temArr[i] = cs.nextFloat();
		}

		writeF(temArr, "INPUT.txt");

	}

	public void writeF(float[] temArr, String url) throws IOException {

		FileOutputStream fos = new FileOutputStream(url);
		DataOutputStream fileO = new DataOutputStream(fos);

		// write elements of array to file.
		for (int i = 0; i < n; i++) {
			fileO.writeFloat(temArr[i]);
		}
		fileO.close();
	}

	public void readF() {
		try {
			FileInputStream fis = new FileInputStream("INPUT.txt");
			DataInputStream file = new DataInputStream(fis);

			// File can be read even without implement 1st function before.
			// due to float = 4 bytes.
			n = fis.available() / 4;
			a = new float[n];

			// read file and set elements to array.
			for (int i = 0; i < n; i++) {
				a[i] = file.readFloat();
			}

			System.out.print("\nARRAY a: ");
			display(a, n);
			file.close();
		} catch (Exception e) {
			System.out.println("PLEASE CREATE ARRAY BEFORE.");
		}

	}

	public void display(float[] a, int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + "  ");
		}
		System.out.println();
	}

	// ARRAY VALUE SWAP METHOD
	public void swap(int i, int j) {
		float temp;
		temp = b[i];
		b[i] = b[j];
		b[j] = temp;
	}

	// BUBBLE SORT METHOD
	public void bubbleSort() {
		try {
			// Create an array b[] of same as a[]
			b = Arrays.copyOfRange(a, 0, n);

			System.out.print("\nInitial array: ");
			display(b, n);
			System.out.println();

			// Start of time counting
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - i - 1; j++) {
					if (b[j] > b[j + 1])
						swap(j, j + 1);
				}
				System.out.print("STEP " + (i + 1) + "\t:  ");
				display(b, n);
			}

			// End of time counting
			long endTime = System.currentTimeMillis();
			System.out.println("\nRunning time of bubble sort algorithm: " + (endTime - startTime) + " ms");

			// Write to file
			writeF(b, "OUTPUT1.txt");
		} catch (Exception e) {
			System.out.println("PLEASE CREATE ARRAY AND DISPLAY IT (2nd function) BEFORE.");
		}

	}

	// SELECTION SORT METHOD
	public void selectionSort() {
		try {
			// Create an array b[] of same as a[]
			b = Arrays.copyOfRange(a, 0, n);

			System.out.print("\nInitial array: ");
			display(b, n);
			System.out.println();

			// Start of time counting
			long startTime = System.currentTimeMillis();
			for (int i = 0; i < n - 1; i++) {
				int minIndex = i;
				for (int j = i + 1; j < n; j++) {
					if (b[j] < b[minIndex]) {
						minIndex = j;
					}
				}
				swap(minIndex, i);
				System.out.print("STEP " + (i + 1) + "\t :  ");
				display(b, n);
			}
			// End of time counting
			long endTime = System.currentTimeMillis();
			System.out.println("\nRunning time of selection sort algorithm: " + (endTime - startTime) + " ms");

			// Write to file
			writeF(b, "OUTPUT2.txt");
		} catch (Exception e) {
			System.out.println("PLEASE CREATE ARRAY AND DISPLAY IT (2nd function) BEFORE.");
		}
	}

	// INSERTION SORT METHOD
	public void insertionSort() {
		try {
			// Create an array b[] of same as a[]
			b = Arrays.copyOfRange(a, 0, n);

			System.out.print("\nInitial array: ");
			display(b, n);
			System.out.println();

			// Start of time counting
			long startTime = System.currentTimeMillis();
			for (int i = 1; i < n; i++) {
				float temp = b[i];
				int j = i - 1;

				while (j >= 0 && b[j] > temp) {
					b[j + 1] = b[j];
					j--;
				}
				b[j + 1] = temp;

				System.out.print("STEP " + i + "\t :  ");
				display(b, n);
			}

			// End of time counting
			long endTime = System.currentTimeMillis();
			System.out.println("\nRunning time of insertion sort algorithm: " + (endTime - startTime) + " ms");

			// Write to file
			writeF(b, "OUTPUT3.txt");
		} catch (Exception e) {
			System.out.println("PLEASE CREATE ARRAY AND DISPLAY IT (2nd function) BEFORE.");
		}

	}

	// LINEAR SEARH METHOD
	public void linearSearch() throws IOException {

		boolean exist = false;

		FileOutputStream fos = new FileOutputStream("OUTPUT4.txt");
		DataOutputStream fileO = new DataOutputStream(fos);

		System.out.print("INPUT VALUE: ");
		float value = cs.nextFloat();

		System.out.print("VALID INDEX: ");
		for (int i = 0; i < n; i++) {
			if (a[i] > value) {
				System.out.print(i + " ");
				fileO.writeFloat(i);
				exist = true;
			}
		}
		if (exist == false) {
			System.out.println("NOT EXIST!");
		}
		fileO.close();
	}

	// BINARY SEARH METHOD
	public void binarySearch() {
		try {
			// Sort
			// Create an array b[] of same as a[]
			b = Arrays.copyOfRange(a, 0, n);

			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (b[i] > b[j]) {
						swap(i, j);
					}
				}
			}

			// Search
			FileOutputStream fos = new FileOutputStream("OUTPUT5.txt");
			DataOutputStream fileO = new DataOutputStream(fos);

			int first = 0;
			int last = n - 1;
			int mid = (first + last) / 2;

			System.out.print("INPUT VALUE: ");
			float value = cs.nextFloat();
			while (first <= last) {
				if (b[mid] > value) {
					last = mid - 1;
				} else if (b[mid] == value) {
					System.out.print("INDEX OF FIRST ELEMENT: " + mid);
					fileO.writeFloat(mid);
					break;
				} else {
					first = mid + 1;
				}
				mid = (first + last) / 2;
			}
			if (first > last) {
				System.out.println("NOT FOUND!");
			}
			fileO.close();
		} catch (Exception e) {
			System.out.println("PLEASE CREATE ARRAY AND DISPLAY IT (2nd function) BEFORE.");
		}
	}

}
