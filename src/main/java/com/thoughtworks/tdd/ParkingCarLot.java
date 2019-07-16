package com.thoughtworks.tdd;
import java.util.HashMap;
import java.util.Map;

    public class ParkingCarLot {

    private Map<Ticket, Car> ticketCarMap;
    private int capacity;

    public boolean isParkingLotFull(){
            if(ticketCarMap.size()==capacity)
                return true;
            else
                return false;
        }



    public ParkingCarLot() {
        ticketCarMap = new HashMap<>();
        capacity=10;
    }
        public ParkingCarLot(int i) {
            ticketCarMap = new HashMap<>();
            capacity=i;
        }

        public int getParkingLotEmptyPstions(){
            return capacity-ticketCarMap.size();
        }



        public boolean isTicketIncluded(Ticket ticket){
            Car car=ticketCarMap.get(ticket);
            if(car==null)
                return false;
            else
                return true;

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
