package com.thoughtworks.tdd;

import java.util.List;
import java.util.stream.Collectors;

public class SmartParkingBoy extends ParkingBoy{
    @Override
    public Ticket park(Car car)throws Exception {
        if(car==null)
            throw new Exception("The car is null.");
        if(getParkingCarLot().stream().filter(i->!i.isParkingLotFull()).collect(Collectors.toList()).size()==0)
            throw new Exception("Not enough position.");
        int parkingLotWithMostPositionRate=0;
        for(int i=0;i<getParkingCarLot().size();i++){
            if(getParkingCarLot().get(parkingLotWithMostPositionRate).getParkingLotEmptyPstions()<
                    getParkingCarLot().get(i).getParkingLotEmptyPstions())
                parkingLotWithMostPositionRate=i;
        }
        return parkCarInParkingLot(parkingLotWithMostPositionRate,car);
    }
}
