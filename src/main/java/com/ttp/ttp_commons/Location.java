/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.ttp_commons;

import com.google.maps.model.LatLng;

/**
 *
 * @author Graham
 */
public class Location {
    private final LatLng location;
    private final boolean startingLoc;
    private boolean inRoute;

    public Location(LatLng location, boolean startingLoc) {
        this.location = location;
        this.startingLoc = startingLoc;
        inRoute = false;
    }
    
    public Location(LatLng location){
        this.location = location;
        startingLoc = false;
        inRoute = false;
    }

    public LatLng getLocation() {
        return location;
    }

    public boolean isStartingLoc() {
        return startingLoc;
    }
    
    public boolean getInRoute() {
        return inRoute;
    }
    
    public void setInRoute(){
        inRoute = !inRoute;
    }
    
    public double getLat(){
        return location.lat;
    }
    
    public double getLng(){
        return location.lng;
    }
}
