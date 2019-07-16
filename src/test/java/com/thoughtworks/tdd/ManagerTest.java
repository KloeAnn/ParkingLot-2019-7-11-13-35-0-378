package com.thoughtworks.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.console;
import static java.lang.System.out;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertSame;

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
        Ticket ticket=manager.specifyParkingBoyPark(1,car);
        Car actulCar=manager.specifyParkingBoyFetch(2,ticket);
        //then
        assertSame(actulCar,car);
    }

    @Test
    public void manager_should_park_and_fetch_car()throws Exception{
        //given
        Car car=new Car();
        Manager manager=new Manager();
        //when
        Ticket ticket=manager.park(car);
        Car actulCar=manager.fetchCar(ticket);
        //then
        assertSame(actulCar,car);
    }


}