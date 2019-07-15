package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    @Test
    public void should_fetch_car_when_park_car_and_get_it_back(){
        //given
        Car car=new Car();
        Ticket ticket=new Ticket();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Ticket actualTicket=parkingBoy.park(car);
        Car actualCar=parkingBoy.fetchCar(actualTicket);
        //then
        assertSame(car,actualCar);
    }
}