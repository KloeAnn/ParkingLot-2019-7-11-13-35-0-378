package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParkingBoy {
    private ParkingCarLot parkingCarLot;
    private List<Ticket> usedTickets;

    ParkingBoy(){
        parkingCarLot=new ParkingCarLot();
        usedTickets=new ArrayList<Ticket>();
    }

    public Ticket park(Car car){
        return  parkingCarLot.addCar(car);
    }

    public Car fetchCar(Ticket ticket)throws Exception {
        if(usedTickets.stream().filter(i->i==ticket).collect(Collectors.toList()).size()!=0)
            throw new Exception("The ticket has been used.");
        else
            usedTickets.add(ticket);
        return parkingCarLot.getCar(ticket);
    }
}
