package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SmartParkingBoyTest {
    @Test
    public void should_fetch_car_when_park_car_and_get_it_back()throws Exception {
        //given
        Car car=new Car();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        Ticket actualTicket=smartParkingBoy.park(car);
        Car actualCar=smartParkingBoy.fetchCar(actualTicket);
        //then
        assertSame(car,actualCar);
    }

    @Test
    public void should_fetch_correspond_cars_when_park_multiple_cars_and_get_them_back()throws Exception {
        // given
        Car firstCar = new Car();
        Car secondCar = new Car();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();

        // when
        Ticket firstTicket = smartParkingBoy.park(firstCar);
        Ticket secondTicket = smartParkingBoy.park(secondCar);
        Car actualFirstCar = smartParkingBoy.fetchCar(firstTicket);
        Car actualSecondCar = smartParkingBoy.fetchCar(secondTicket);

        // then
        assertSame(firstCar, actualFirstCar);
        assertSame(secondCar, actualSecondCar);
    }

    @Test
    public void should_not_fetch_car_when_ticket_is_wrong(){
        //given
        Ticket ticket=new Ticket();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        Executable executable=()->{
            smartParkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception= assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Unrecognized parking ticket.");
    }

    @Test
    public void should_not_fetch_car_without_ticket(){
        //given
        Ticket ticket=null;
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        Executable executable=()->{
            smartParkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Please provide your parking ticket.");

    }

    @Test
    public void should_not_fetch_car_if_ticket_has_been_used() throws Exception {
        //given
        Car car=new Car();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        Ticket ticket=smartParkingBoy.park(car);
        smartParkingBoy.fetchCar(ticket);
        //then
        Executable executable=()->{
            smartParkingBoy.fetchCar(ticket);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Unrecognized parking ticket.");
    }

    @Test
    public void should_not_return_ticket_if_car_is_null() throws Exception {
        //given
        Car car=null;
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        //then
        Executable executable=()->{
            smartParkingBoy.park(car);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"The car is null.");
    }

    @Test
    public void should_not_return_ticket_if_parking_plot_is_full() throws Exception {
        //given
        Car car=new Car();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        //when
        for(int i=0;i<10;i++){
            smartParkingBoy.park(new Car());
        }
        //then
        Executable executable=()->{
            smartParkingBoy.park(car);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Not enough position.");
    }

    @Test
    public void should_park_car_in_which_contains_more_empty_positions() throws Exception {
        //given
        Car car=new Car();
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        ParkingCarLot parkingCarLot2=new ParkingCarLot(12);
        smartParkingBoy.addParkingLot(parkingCarLot2);
        //when
        Ticket ticket=smartParkingBoy.park(car);
        boolean isCarInParkingLot2=parkingCarLot2.isTicketIncluded(ticket);
        //then
        assertTrue(isCarInParkingLot2);
    }
}