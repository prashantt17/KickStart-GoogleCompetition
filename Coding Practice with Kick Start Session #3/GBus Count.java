import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Hashtable;

class Solution {
	public static void main(String[] args) {
		getGBusCount();
	}

	public static int getGBusCount() {
		Scanner in = new Scanner(System.in);
		int numTests = in .nextInt();
		if (numTests > 10 || numTests < 1) {
			return -1;
		}

			int numOfGBuses;

		for (int caseNum = 1; caseNum<= numTests; caseNum++) {
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			numOfGBuses = in .nextInt();

			for (int i = 1; i<= numOfGBuses; i++) {
				ArrayList<Integer> listOfPairs = new ArrayList<>();
				listOfPairs.add( in .nextInt());
				listOfPairs.add( in .nextInt());
				map.put(i, listOfPairs);
			}

			int numCities = in .nextInt();

			int countOfCity = 0;
			int city;
			System.out.print("Case #" + caseNum + ":");

			while (countOfCity != numCities) {
				ArrayList<Integer> y = new ArrayList<>();
				int serveCount = 0;
				city = in .nextInt();

				for (int k: map.keySet()) {
					if (city >= map.get(k).get(0) && (city<= map.get(k).get(1))) {
						serveCount++;
					}
				}
				y.add(serveCount);
				for (int i: y) {
					System.out.print(" " + i);
				}
				countOfCity++;

			}
			System.out.println();

			String s = in .nextLine();

		}
		return 0;
	}

}
