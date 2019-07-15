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
        Car car=ticketCarMap.get(ticket);
        if(car==null)
            throw new Exception("The ticket is wrong.");
        return car;
    }
}
