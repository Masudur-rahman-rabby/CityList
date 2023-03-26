package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list of cities
     */
    public List<City> getCities() {
        List<City> cityList = cities;
        Collections.sort(cityList);
        return cityList;
    }

    /**
     * Removes the specified city from the list of cities.
     *
     * @param city The city to remove.
     * @throws IllegalArgumentException If the city is not in the list.
     */
    public void delete(City city) throws IllegalArgumentException {
        if (!cities.contains(city)) {
            throw new IllegalArgumentException("City not found");
        }
        cities.remove(city);
    }
    /**
     * Returns the total number of cities in the city list.
     *
     * @return the total number of cities
     */
    public int count() {
        return cities.size();
    }
    /**
     * This returns a sorted list of cities
     *
     * @return Return the sorted list of cities
     */
    public List<City> getCities(String sortCriteria) {
        List<City> cityList = new ArrayList<>(cities);
        if (sortCriteria.equals("city")) {
            Collections.sort(cityList, Comparator.comparing(City::getCityName));
        } else if (sortCriteria.equals("province")) {
            Collections.sort(cityList, Comparator.comparing(City::getProvinceName));
        } else {
            throw new IllegalArgumentException("Invalid sort criteria");
        }
        return cityList;
    }
    public boolean contains(City city2) {
        return cities.contains(city2);
    }

}
