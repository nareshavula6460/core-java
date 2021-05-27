package com.cj.inheritance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class IplManager {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("1.display players of the given team \n" + "2.display total amount spend by each team \n"
					+ "3.Display the role count of the given team \n" + "4.Display max paid player of the given team \n"
					+ "5.Display all the player from the given country \n" + "6.Display top 3  paid players details");
			int ch = sc.nextInt();
			sc.nextLine();

			switch (ch) {
			case 1:

				System.out.println("Enter the team name :");
				String name = sc.nextLine();

				String[] str = displayPlayerOfTheGivenTeam(name);
				for (String s : str) {
					System.out.println(s);

				}

				break;

			case 2:
				System.out.println("Enter the team name:");
				String name1 = sc.nextLine();

				Ipl2020[] teams = getAllTeamsInformation();

				double price = 0;
				for (Ipl2020 t : teams) {
					if (t.iplTName.equalsIgnoreCase(name1)) {
						price = price + t.getPrice();

					}

				}
				System.out.println(price);
				break;
			case 3:
				System.out.println("Enter the team name:");
				String name2 = sc.nextLine();
				System.out.println("Enter the role :");
				String role = sc.nextLine();
				int count = 0;

				Ipl2020[] teams1 = getAllTeamsInformation();
				for (Ipl2020 tr : teams1) {
					if (tr.iplTName.equalsIgnoreCase(name2)) {
						if (tr.getRole().equalsIgnoreCase(role)) {
							count++;
						}
					}
				}
				System.out.println(count);
				break;
			case 4:
				System.out.println("Enter the team name");
				String name3 = sc.nextLine();
				Ipl2020[] teams3 = getAllTeamsInformation();
				double[] arr = maxPlayer(name3);
				double max_price_player = arr[0];
				for (int i = 1; i < arr.length; i++) {
					if (max_price_player < arr[i]) {
						max_price_player = arr[0];
					}
				}
				for (Ipl2020 mpp : teams3) {
					if (mpp.getIplTName().equalsIgnoreCase(name3)) {
						if (mpp.getPrice() == max_price_player) {
							mpp.showDetails();
							System.out.println("----------------------------------------------");

						}

					}
				}

				break;
			case 5:
				System.out.println("Enter the country name:");
				String name4 = sc.nextLine();
				Ipl2020[] teams4 = getAllTeamsInformation();
				for (Ipl2020 at : teams4) {
					if (at.countryName.equalsIgnoreCase(name4)) {
						System.out.println(at.getName());

					}
				}
				System.out.println("---------------------------------------------------------");
				break;
			case 6:
				Ipl2020[] teams5 = getAllTeamsInformation();
				double[] arr4 = new double[teams5.length];
				int count4 = 0;
				for (Ipl2020 t3 : teams5) {
					arr4[count4++] = t3.getPrice();

					Arrays.sort(arr4);
					int temp = 0;
					for (int i = arr4.length - 1; i > 0; i--) {
						if (temp <= 2) {

							if (t3.getPrice() == arr4[i]) {
								t3.showDetails();
								temp++;
							}

						}

					}
					

				}

			}
			break;
		}
	
	}
	

	private static double[] maxPlayer(String Name) throws IOException {
		Ipl2020[] teams = getAllTeamsInformation();
		double[] arr = new double[teams.length];
		int count = 0;

		for (Ipl2020 t : teams) {
			if (t.iplTName.equalsIgnoreCase(Name)) {
				arr[count++] = t.getPrice();

			}

		}
		return arr;

	}

	private static String[] displayPlayerOfTheGivenTeam(String Name) throws IOException {
		Ipl2020[] teams = getAllTeamsInformation();
		String[] arr = new String[50];
		int count = 0;
		for (Ipl2020 t : teams) {
			if (t.getIplTName().equalsIgnoreCase(Name)) {
				arr[count++] = t.getName();
			}
		}
		return arr;

	}

	private static Ipl2020[] getAllTeamsInformation() throws IOException {
		List<String> list = Files.readAllLines(Paths.get("iplTeams.csv"));
		Ipl2020[] teams = new Ipl2020[list.size() - 1];
		int count = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			String data = list.get(i);

			String[] arr = data.split(",");
			Ipl2020 tt = null;
			String name = arr[0];
			String role = arr[1];
			String countryName = arr[2];
			String iplTName = arr[3];
			double price = Double.parseDouble(arr[4]);
			tt = new Ipl2020(name, role, countryName, iplTName, price);
			teams[count++] = tt;

		}
		return teams;
	}

}
