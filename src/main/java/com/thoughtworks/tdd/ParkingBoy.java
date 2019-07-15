package com.thoughtworks.tdd;

public class ParkingBoy {
    private ParkingCarLot parkingCarLot;
    ParkingBoy(){
        parkingCarLot=new ParkingCarLot();
    }

    public Ticket park(Car car){
        return  parkingCarLot.addCar(car);
    }

    public Car fetchCar(Ticket ticket){
        return parkingCarLot.getCar(ticket);
    }
}
