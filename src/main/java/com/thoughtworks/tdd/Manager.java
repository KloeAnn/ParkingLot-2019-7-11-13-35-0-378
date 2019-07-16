package com.thoughtworks.tdd;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager extends ParkingBoy {
    private Map<Integer,ParkingBoy> managementList;
    private ParkingCarLot parkingLot;
    Manager(){
        parkingLot=new ParkingCarLot();
        managementList=new HashMap<>();
    }

    public Map<Integer, ParkingBoy> getManagementList() {
        return managementList;
    }

    public void addParkingBoyToList(ParkingBoy parkingBoy){
        getManagementList().put(getManagementList().size()+1,parkingBoy);
    }

    public Ticket specifyParkingBoyPark(int i,Car car)throws Exception{
        Ticket ticket=null;
        try {
            ticket = getManagementList().get(i).park(car);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return ticket;

    }


    public Car specifyParkingBoyFetch(int i,Ticket ticket)throws Exception{
        Car car = null;
        try {
            car = getManagementList().get(i).fetchCar(ticket);
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return car;
    }
}
