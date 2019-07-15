package com.thoughtworks.tdd;
import java.util.HashMap;
import java.util.Map;

public class ParkingCarLot {
    private Map<Ticket, Car> ticketCarMap;
    private int capacity;

    public ParkingCarLot() {
        ticketCarMap = new HashMap<>();
        capacity=10;
    }

    public Ticket addCar(Car car)throws Exception{
        if(ticketCarMap.size()==capacity)
            throw new Exception("Not enough position.");
        Ticket ticket = new Ticket();
        ticketCarMap.put(ticket, car);
        return ticket;
    }


    public Car getCar(Ticket ticket) throws Exception{
        if(ticket==null)
            throw new Exception("Please provide your parking ticket.");
        Car car=ticketCarMap.get(ticket);
        if(car==null)
            throw new Exception("Unrecognized parking ticket.");

        return car;
    }
}
