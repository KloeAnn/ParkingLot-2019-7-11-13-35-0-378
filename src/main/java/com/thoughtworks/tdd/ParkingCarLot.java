package com.thoughtworks.tdd;
import java.util.HashMap;
import java.util.Map;

public class ParkingCarLot {
    private Map<Ticket, Car> ticketCarMap;

    public ParkingCarLot() {
        ticketCarMap = new HashMap<>();
    }

    public Ticket addCar(Car car) {
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }


    public Car getCar(Ticket ticket) throws Exception{
        if(ticket==null)
            throw new Exception("You can't fetch a car without a ticket.");
        Car car=ticketCarMap.get(ticket);
        if(car==null)
            throw new Exception("Unrecognized parking ticket.");

        return car;
    }
}
