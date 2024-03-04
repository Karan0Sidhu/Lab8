package com.example.lab8;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import android.util.Log;

import java.util.ArrayList;


public class CityListTest {
    private CityList list;
    private CityList mockCityList() {
        list = new CityList(null,new ArrayList<>());
        list.add(mockCity());
        return list;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void addCityTest(){
        CityList list = mockCityList();
        int listSize = list.CountCities();
        list.add(new City("Estevan", "SK"));
        assertEquals(listSize + 1, list.CountCities());
    }
    @Test
    public void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.add(city); });
    }

    @Test
    public void testHasCity() {
        CityList cityList = mockCityList();


        City city = new City("Charlottetown", "Prince Edward Island");
        assertEquals(Boolean.FALSE, cityList.hasCity(city));
        cityList.add(city);
        assertEquals(Boolean.TRUE, cityList.hasCity(city));


    }

    @Test
    public void testDeleteCity() {
        CityList cityList = mockCityList();


        City city = new City("Charlottetown", "Prince Edward Island");
        //cityList.add(city);
        assertThrows( IllegalArgumentException.class, () -> {
            cityList.deleteCity(city); });

        cityList.add(city);
        cityList.deleteCity(city);
        assertEquals(Boolean.FALSE, cityList.hasCity(city));

    }

    @Test
    public void testCountCities() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.CountCities());

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(2, cityList.CountCities());

        cityList.deleteCity(city);

        assertEquals(1, cityList.CountCities());
    }





}


