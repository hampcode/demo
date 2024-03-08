package com.hampcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create a ReservationService instance
        ReservationService reservationService = new ReservationService();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("""
                    Menu:
                    1. Register Reservation
                    2. List All Reservations
                    3. Filter Reservations by Date
                    4. Count Reservations by Date - UPDATE 2
                    5. Exit
                    """);

            System.out.print("Select an option: ");
            int choice = Integer.parseInt(reader.readLine());

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter reservation ID: ");
                    String id = reader.readLine();
                    System.out.print("Enter guest name: ");
                    String guest = reader.readLine();
                    System.out.print("Enter reservation date (yyyy-MM-dd): ");
                    String date = reader.readLine();

                    reservationService.registerReservation(new Reservation(id, guest, date));
                    System.out.println("Reservation registered successfully!");
                }
                case 2 -> {
                    System.out.println("All Reservations:");
                    reservationService.getAllReservations().forEach(System.out::println);
                }
                case 3 -> {
                    System.out.print("Enter target date for filtering (yyyy-MM-dd): ");
                    String targetDate = reader.readLine();
                    System.out.println("Filtered Reservations:");
                    reservationService.filterReservationsByDate(targetDate).forEach(System.out::println);
                }
                case 4 -> {
                    System.out.println("Reservations Count by Date:");
                    //reservationService.countReservationsByDate().forEach((date, count) ->
                    //        System.out.printf("Date: %s, Count: %d%n", date, count));
                    reservationService.countReservationsByDateRecord().forEach((date, count) ->
                            System.out.printf("Date: %s, Count: %d%n", date, count));
                }
                case 5 -> {
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}