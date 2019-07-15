package com.thoughtworks.tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTest {
    @Test
    public void should_fetch_car_when_park_car_and_get_it_back()throws Exception {
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

    @Test
    public void should_fetch_correspond_cars_when_park_multiple_cars_and_get_them_back()throws Exception {
        // given
        Car firstCar = new Car();
        Car secondCar = new Car();
        ParkingBoy parkingBoy = new ParkingBoy();

        // when
        Ticket firstTicket = parkingBoy.park(firstCar);
        Ticket secondTicket = parkingBoy.park(secondCar);
        Car actualFirstCar = parkingBoy.fetchCar(firstTicket);
        Car actualSecondCar = parkingBoy.fetchCar(secondTicket);

        // then
        assertSame(firstCar, actualFirstCar);
        assertSame(secondCar, actualSecondCar);
    }

    @Test
    public void should_not_fetch_car_when_ticket_is_wrong(){
        //given
        Ticket ticket=new Ticket();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Executable executable=()->{
            parkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception= assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"The ticket is wrong.");
    }

    @Test
    public void should_not_fetch_car_without_ticket(){
        //given
        Ticket ticket=null;
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Executable executable=()->{
          parkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"You can't fetch a car without a ticket.");

    }

    @Test
    public void should_not_fetch_car_if_ticket_has_been_used() throws Exception {
        //given
        Car car=new Car();
        ParkingBoy parkingBoy=new ParkingBoy();
        //when
        Ticket ticket=parkingBoy.park(car);
        parkingBoy.fetchCar(ticket);
        //then
        Executable executable=()->{
            parkingBoy.fetchCar(ticket);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"The ticket has been used.");
    }


}