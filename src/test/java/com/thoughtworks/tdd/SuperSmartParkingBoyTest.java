package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SuperSmartParkingBoyTest {

    @Test
    public void should_fetch_car_when_park_car_and_get_it_back()throws Exception {
        //given
        Car car=new Car();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        Ticket actualTicket=superSmartParkingBoy.park(car);
        Car actualCar=superSmartParkingBoy.fetchCar(actualTicket);
        //then
        assertSame(car,actualCar);
    }

    @Test
    public void should_fetch_correspond_cars_when_park_multiple_cars_and_get_them_back()throws Exception {
        // given
        Car firstCar = new Car();
        Car secondCar = new Car();
        SuperSmartParkingBoy superSmartParkingBoy = new SuperSmartParkingBoy();

        // when
        Ticket firstTicket = superSmartParkingBoy.park(firstCar);
        Ticket secondTicket = superSmartParkingBoy.park(secondCar);
        Car actualFirstCar = superSmartParkingBoy.fetchCar(firstTicket);
        Car actualSecondCar = superSmartParkingBoy.fetchCar(secondTicket);

        // then
        assertSame(firstCar, actualFirstCar);
        assertSame(secondCar, actualSecondCar);
    }

    @Test
    public void should_not_fetch_car_when_ticket_is_wrong(){
        //given
        Ticket ticket=new Ticket();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        Executable executable=()->{
            superSmartParkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception= assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Unrecognized parking ticket.");
    }

    @Test
    public void should_not_fetch_car_without_ticket(){
        //given
        Ticket ticket=null;
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        Executable executable=()->{
            superSmartParkingBoy.fetchCar(ticket);
        };
        //then
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Please provide your parking ticket.");

    }

    @Test
    public void should_not_fetch_car_if_ticket_has_been_used() throws Exception {
        //given
        Car car=new Car();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        Ticket ticket=superSmartParkingBoy.park(car);
        superSmartParkingBoy.fetchCar(ticket);
        //then
        Executable executable=()->{
            superSmartParkingBoy.fetchCar(ticket);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Unrecognized parking ticket.");
    }

    @Test
    public void should_not_return_ticket_if_car_is_null() throws Exception {
        //given
        Car car=null;
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        //then
        Executable executable=()->{
            superSmartParkingBoy.park(car);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"The car is null.");
    }

    @Test
    public void should_not_return_ticket_if_parking_plot_is_full() throws Exception {
        //given
        Car car=new Car();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        //when
        for(int i=0;i<10;i++){
            superSmartParkingBoy.park(new Car());
        }
        //then
        Executable executable=()->{
            superSmartParkingBoy.park(car);
        };
        Exception exception=assertThrows(Exception.class,executable);
        assertEquals(exception.getMessage(),"Not enough position.");
    }

    @Test
    public void should_park_car_in_which_position_rate_is_largest() throws Exception {
        //given
        Car car=new Car();
        SuperSmartParkingBoy superSmartParkingBoy=new SuperSmartParkingBoy();
        ParkingCarLot parkingCarLot2=new ParkingCarLot();
        superSmartParkingBoy.addParkingLot(parkingCarLot2);
        //when
        superSmartParkingBoy.park(new Car());
        Ticket ticket=superSmartParkingBoy.park(car);
        boolean isCarInParkingLot2=parkingCarLot2.isTicketIncluded(ticket);
        //then
        assertTrue(isCarInParkingLot2);
    }

}