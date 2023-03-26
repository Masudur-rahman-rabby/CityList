package com.example.citylist;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    public void testDelete() {
        City city1 = new City("Dhaka", "Gulshan");
        City city2 = new City("Barishal", "Police line");
        City city3 = new City("Narayanganj", "Muslimnagar");

        CityList cityList = new CityList();
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        // Delete a city that exists in the list
        cityList.delete(city2);
        assertFalse(cityList.contains(city2));

        // Delete a city that doesn't exist in the list
        try {
            cityList.delete(new City("Feni","Sadab Ganj"));
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Can't found the city", e.getMessage());
        }
    }
    @Test
    public void testCount() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.count());

        City city1 = new City("Dhaka", "Gulshan");
        City city2 = new City("Barishal", "Police line");
        City city3 = new City("Narayanganj", "Muslimnagar");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);

        assertEquals(3, cityList.count());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDeleteException() {
        CityList cityList = new CityList();
        City city1 = new City("Gopalganj", "Vanga");
        City city2 = new City("Khulna", "KUET");
        cityList.add(city1);
        cityList.delete(city2);
    }
    @Test
    public void testSort() {
        CityList cityList = new CityList();
        City city1 = new City("Dhaka", "Badda");
        City city2 = new City("Bogra", "Thanakuchi");
        City city3 = new City("Shanarpar", "Ruthila gram");
        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        List<City> sortedCityList = cityList.getCities("city");
        assertEquals("Bogra", sortedCityList.get(0).getCityName());
        assertEquals("Dhaka", sortedCityList.get(1).getCityName());
        assertEquals("Shanarpar", sortedCityList.get(2).getCityName());
        List<City> sortedCityLists = cityList.getCities("province");
        assertEquals("Badda", sortedCityLists.get(0).getProvinceName());
        assertEquals("Ruthila gram", sortedCityLists.get(1).getProvinceName());
        assertEquals("Thanakuchi", sortedCityLists.get(2).getProvinceName());
    }
}
