package com.thoughtworks.tdd;

import java.util.ArrayList;
import java.util.List;

public class Manager extends ParkingBoy {
    private List<ParkingBoy> managementList;
    Manager(){
        super();
        managementList=new ArrayList<ParkingBoy>(0);
    }
    public void addParkingBoyToList(ParkingBoy parkingBoy){
        managementList.add(parkingBoy);
    }

    public Ticket specifyParkingBoyPark(ParkingBoy parkingBoy,Car car)throws Exception{
        return parkingBoy.park(car);
    }

    public Car specifyParkingBoyFetch(ParkingBoy parkingBoy,Ticket ticket)throws Exception{
        return parkingBoy.fetchCar(ticket);
    }
}
