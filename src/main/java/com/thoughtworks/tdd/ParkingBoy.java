package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ParkingBoy {
    private List<ParkingCarLot> parkingCarLot;
    private List<Ticket> usedTickets;

    ParkingBoy(){
        parkingCarLot=new ArrayList<ParkingCarLot>();
        usedTickets=new ArrayList<Ticket>();
    }

    public Ticket park(Car car)throws Exception {
        if(car==null)
            throw new Exception("The car is null.");
        for(int i=0;i<parkingCarLot.size();i++){
            if(!parkingCarLot.get(i).isParkingLotFull())
                return parkingCarLot.get(i).addCar(car);
        }
        throw new Exception();
    }

    public Car fetchCar(Ticket ticket)throws Exception {
        if(usedTickets.stream().filter(i->i==ticket).collect(Collectors.toList()).size()!=0)
            throw new Exception("Unrecognized parking ticket.");
        else
            usedTickets.add(ticket);
        for(int i=0;i<parkingCarLot.size();i++){
            if(parkingCarLot.get(i).isTicketIncluded(ticket))
                return parkingCarLot.get(i).getCar(ticket);
        }
        throw  new Exception();
    }
}
