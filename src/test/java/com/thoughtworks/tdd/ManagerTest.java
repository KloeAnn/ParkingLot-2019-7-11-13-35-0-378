package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    @Test
    public void specify_paekingBoy_park_and_fetch_car()throws Exception{
        //given
        Car car=new Car();
        ParkingBoy parkingBoy1=new ParkingBoy();
        ParkingBoy parkingBoy2=new ParkingBoy();
        Manager manager=new Manager();
        manager.addParkingBoyToList(parkingBoy1);
        manager.addParkingBoyToList(parkingBoy2);
        //when
        Ticket ticket=manager.specifyParkingBoyPark(parkingBoy1,car);
        Car actulCar=manager.specifyParkingBoyFetch(parkingBoy1,ticket);
        //then
        assertSame(actulCar,car);
    }

    @Test
    public void manager_should_park_and_fetch_car()throws Exception{
        //given
        Car car=new Car();

        //when
        //then
    }
}