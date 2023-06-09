package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import modelo.exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number: ");
			int number = ler.nextInt();
			System.out.print("Check-in date (DD/MM/YYYY): ");
			Date checkIn = sdf.parse(ler.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			Date checkOut = sdf.parse(ler.next());
	
			
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println("");
			System.out.println("Enter data to upgrade the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(ler.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(ler.next());
	
			reservation.update(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}catch(ParseException e) {
			System.out.println("Invalid date format");
		}catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}

		ler.close();
	}

}
