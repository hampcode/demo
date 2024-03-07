package com.hampcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservationService {
    private final List<Reservation> reservations;

    public ReservationService() {
        this.reservations = new ArrayList<>();
    }

    public void registerReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return new ArrayList<>(reservations);
    }

    public List<Reservation> filterReservationsByDate(String targetDate) {
        return reservations.stream()
                .filter(reservation -> reservation.getReservationDate().equals(targetDate))
                .collect(Collectors.toList());
    }

//    public Map<String, Long> countReservationsByDate() {
//        return reservations.stream()
//                .collect(Collectors.groupingBy(Reservation::getReservationDate, Collectors.counting()));
//    }

    // Método para contar ReservationRecord por fecha
    public Map<String, Long> countReservationsByDateRecord() {
        return reservations.stream()
                .map(reservation -> new ReservationRecord(reservation.getReservationId(), reservation.getGuestName(), reservation.getReservationDate()))
                .collect(Collectors.groupingBy(ReservationRecord::recordDate, Collectors.counting()));
    }


}
