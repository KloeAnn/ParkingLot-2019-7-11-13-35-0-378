package com.thoughtworks.tdd;

import java.util.stream.Collectors;

public class SuperSmartParkingBoy extends ParkingBoy{

    @Override
    public Ticket park(Car car)throws Exception {
        if(car==null)
            throw new Exception("The car is null.");
        if(getParkingCarLot().stream().filter(i->!i.isParkingLotFull()).collect(Collectors.toList()).size()==0)
            throw new Exception("Not enough position.");
        int parkingLotWithMostEmptyPositions=0;
        for(int i=0;i<getParkingCarLot().size();i++){
            if(getParkingCarLot().get(parkingLotWithMostEmptyPositions).getParkingLotEmptyPstions()<
                    getParkingCarLot().get(i).getParkingLotEmptyPstions())
                parkingLotWithMostEmptyPositions=i;
        }
        return parkCarInParkingLot(parkingLotWithMostEmptyPositions,car);
    }
}
