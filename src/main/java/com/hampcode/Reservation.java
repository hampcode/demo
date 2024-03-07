package com.hampcode;

public class Reservation {
    private  String reservationId;
    private  String guestName;
    private  String reservationDate;

    public Reservation(String reservationId, String guestName, String reservationDate) {
        this.reservationId = reservationId;
        this.guestName = guestName;
        this.reservationDate = reservationDate;
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", guestName='" + guestName + '\'' +
                ", reservationDate='" + reservationDate + '\'' +
                '}';
    }
}
