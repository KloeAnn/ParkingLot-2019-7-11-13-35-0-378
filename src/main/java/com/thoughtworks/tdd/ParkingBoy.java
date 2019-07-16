package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

    public List<ParkingCarLot> getParkingCarLot(){
        return  parkingCarLot;
    }

    public List<Ticket> getUsedTickets(){
        return usedTickets;
    }

    public void addUsedTickets(Ticket ticket){
        usedTickets.add(ticket);
    }

    public Ticket parkCarInParkingLot(int i,Car car)throws Exception{
        return parkingCarLot.get(i).addCar(car);
    }

    public Car fetchCarInParkingLot(int i,Ticket ticket)throws Exception{
        return parkingCarLot.get(i).getCar(ticket);
    }

    public Ticket park(Car car)throws Exception {
        if(car==null)
            throw new Exception("The car is null.");
        if(getParkingCarLot().stream().filter(i->i.isParkingLotFull()).collect(Collectors.toList()).size()==0)
            throw new Exception("Not enough position.");
        for(int i=0;i<getParkingCarLot().size();i++){
            if(!getParkingCarLot().get(i).isParkingLotFull())
                return parkCarInParkingLot(i,car);
        }
        throw new Exception();
    }

    public Car fetchCar(Ticket ticket)throws Exception {

        if(ticket==null)
            throw new Exception("Please provide your parking ticket.");

        if(getUsedTickets().stream().filter(i->i==ticket).collect(Collectors.toList()).size()!=0)
            throw new Exception("Unrecognized parking ticket.");

        for(int i=0;i<getParkingCarLot().size();i++){
            if(getParkingCarLot().get(i).isTicketIncluded(ticket)){
                addUsedTickets(ticket);
                return parkingCarLot.get(i).getCar(ticket);
            }
            else {
                throw new Exception("Unrecognized parking ticket.");
            }
        }
        throw new Exception();
    }
}
