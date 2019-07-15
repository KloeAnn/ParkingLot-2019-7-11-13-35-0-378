package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingBoy {
    private ParkingCarLot parkingLot;
    private List<ParkingCarLot> parkingCarLot;
    private List<Ticket> usedTickets;

    ParkingBoy(){
        ParkingCarLot parkingLot=new ParkingCarLot();
        parkingCarLot=new ArrayList<ParkingCarLot>();
        parkingCarLot.add(parkingLot);
        usedTickets=new ArrayList<Ticket>(0);
    }

    public void addParkingLot(ParkingCarLot parkingLot){
        parkingCarLot.add(parkingLot);
    }

    public Ticket park(Car car)throws Exception {
        if(car==null)
            throw new Exception("The car is null.");
        if(parkingCarLot.stream().filter(i->!i.isParkingLotFull()).collect(Collectors.toList()).size()==0)
            throw new Exception("Not enough position.");
        for(int i=0;i<parkingCarLot.size();i++){
            if(!parkingCarLot.get(i).isParkingLotFull())
                return parkingCarLot.get(i).addCar(car);
        }
        throw new Exception();
    }

    public Car fetchCar(Ticket ticket)throws Exception {

        if(ticket==null)
            throw new Exception("Please provide your parking ticket.");

        if(usedTickets.stream().filter(i->i==ticket).collect(Collectors.toList()).size()!=0)
            throw new Exception("Unrecognized parking ticket.");

        for(int i=0;i<parkingCarLot.size();i++){
            if(parkingCarLot.get(i).isTicketIncluded(ticket)){
                usedTickets.add(ticket);
                return parkingCarLot.get(i).getCar(ticket);
            }
            else {
                throw new Exception("Unrecognized parking ticket.");
            }
        }
        throw new Exception();
    }
}
