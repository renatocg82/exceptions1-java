package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc;
		sc = new Scanner(System.in);
		SimpleDateFormat sdf;
		sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation, Check-Out date must be after Check-in date.");
		} 
		else {
			Reservation reserv = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println("Reservation: " + reserv);
			System.out.println("");
			System.out.println("***********************");
			System.out.println("Enter data to update the reservation: ");

			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date newCheckIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date newCheckOut = sdf.parse(sc.next());

			Date now = new Date();
			if (newCheckOut.before(now) || newCheckIn.before(now)) {
				System.out.println("Error in reservation: Reservation dates for updates must be future dates");
			}

			else if (!newCheckOut.after(newCheckIn)) {
				System.out.println("Error in reservation, Check-Out date must be after Check-in date.");
			}

			else {
				reserv.updateDates(newCheckIn, newCheckOut);
				System.out.println("Reservation " + reserv);
			}
		}

		sc.close();
	}

}
