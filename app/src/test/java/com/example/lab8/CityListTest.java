package com.example.lab8;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import android.util.Log;


public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
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
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(0)));
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0,
                mockCity().compareTo(cityList.getCities().get(1)));
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
        CityList cityList = new CityList();
        assertEquals(0, cityList.CountCities());

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(1, cityList.CountCities());

        cityList.deleteCity(city);

        assertEquals(0, cityList.CountCities());
    }





}


