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
public class TourInput {
    private final String mode;
    private final LatLng[] locations;
    
    public TourInput(String Mode, LatLng[] Locations){
        mode = Mode;
        locations = Locations;
    }
    
    public TourInput(String Mode, LatLng Location){
        mode = Mode;
        locations = new LatLng[]{Location};
    }
    
    public String getMode(){
        return mode;
    }
    
    public LatLng[] getLocations(){
        return locations;
    }
}