import org.junit.Assert;
import org.junit.Test;

import java.time.*;
import java.io.IOException;


import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.Assert.*;

public class MyCalendarTest {

    @Test
    public void FridayTh() throws IOException {
        Date curr = new Date(26,11,2020,3);


        System.out.println("Заданная текущая дата: " + curr.getDay() + "."
                + curr.getMonth() + "."
                + curr.getYear());
        System.out.println("Номер дня недели: " + curr.getWeekDay() + " (0 - Пн и т.д.)\n");

        Date fridayTh = MyCalendar.nearestDay(curr, 13, 4);
        System.out.println(fridayTh.getDay() + " "
                + fridayTh.getMonth() + " "
                + fridayTh.getYear() + " "
                + fridayTh.getWeekDay());
        Assert.assertEquals(13,fridayTh.getDay());
        Assert.assertEquals(8,fridayTh.getMonth());
        Assert.assertEquals(2021,fridayTh.getYear());

    }

    @Test
    public void Weekday1024() throws IOException {
        Date curr = new Date(26,11,2020,3);

        LocalDate currLib = LocalDate.parse("2020-11-26");

        LocalDate libRes = currLib.plusDays(1024);
        Date myRes = MyCalendar.plusDays(curr, 1024);

        String myResult = myRes.weekDayToString();
        String libResult = libRes.getDayOfWeek().toString();
        Assert.assertEquals(myResult,libResult);

    }

    @Test
    public void minus50Days() throws IOException {
        Date curr = new Date(26,11,2020,3);

        LocalDate currLib = LocalDate.parse("2020-11-26");

        LocalDate libRes = currLib.minusDays(100);
        Date myRes = MyCalendar.minusDays(curr, 100);

        System.out.println(libRes);
        System.out.println(myRes.getDay() + " "
                + myRes.getMonth() + " "
                + myRes.getYear() + " "
                + myRes.getWeekDay());

        String myResult = myRes.weekDayToString();
        String libResult = libRes.getDayOfWeek().toString();
        Assert.assertEquals(myResult,libResult);
    }

    @Test
    public void VictoryDay() throws IOException {

        Date curr = new Date(26,11,2020,3);

        LocalDate currLib = LocalDate.parse("2020-11-26");

        Date victoryDay = new Date(9,5,1945,2);

        LocalDate victoryDayLib = LocalDate.parse("1945-05-09");

        long myRes = MyDuration.inDays(victoryDay, curr);
        long libRes = DAYS.between(victoryDayLib, currLib);

        assertEquals(myRes, libRes);

    }

    @Test
    public void WhatMonthWillBe() throws IOException {
        Date curr = new Date(26,11,2020,3);
        LocalDate currLib = LocalDate.parse("2020-11-26");

        Date myRes = MyCalendar.plusWeeks(curr, 17);
        LocalDate libRes = currLib.plusWeeks(17);

        String myResult = myRes.weekDayToString();
        String libResult = libRes.getDayOfWeek().toString();

        Assert.assertEquals(myResult,libResult);

    }
    }