package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner ler = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = ler.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(ler.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(ler.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be "
					+ "after check-in date");
		}else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println("");
			System.out.println("Enter data to upgrade the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(ler.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(ler.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: reservation dates for update must be future.");
			}else if(!checkOut.after(checkIn)){
				System.out.println("Error in reservation: Check-out date must be "
						+ "after check-in date");
			}else {
				reservation.update(checkIn, checkOut);
				
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		
		ler.close();
	}

}
