package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CityList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CityList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }
    /**
     * This returns a sorted list of cities
     * @return List
     * Return the sorted list
     */
    public List getCities() {
        List list = cities;
        Collections.sort(list);
        return list;
    }

    /**
     * This returns a True/False value
     * @return Boolean
     * @param city
     * Return if city in list (True) or not (False)
     */
    public Boolean hasCity(City city){
        Boolean i = Boolean.FALSE;
        for (City cityInList : cities){
            if (cityInList == city){i = Boolean.TRUE;}
        }
        return  i;
    }

    /**
     * This deletes a city from the list
     * @param  city
     * throws an exception if city not in list
     */
    public void deleteCity(City city) {
        if (!(cities.contains(city))) {
            throw new IllegalArgumentException();
        }
        cities.remove(city);

//        try{
//        }
//        catch(Exception e){
//            throw new Exception("city not in list");
//        }
//        //finally

    }

    /**
     * returns count of items in list
     * @return int
     */
    public int CountCities(){
        return cities.size();
    }

}


