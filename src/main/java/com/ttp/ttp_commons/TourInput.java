/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.ttp_commons;

/**
 *
 * @author Graham
 */
public class TourInput {
    private final String mode;
    private final String[] locations;
    
    public TourInput(String Mode, String[] Locations){
        mode = Mode;
        locations = Locations;
    }
    
    public TourInput(String Mode, String Location){
        mode = Mode;
        locations = new String[]{Location};
    }
    
    public String getMode(){
        return mode;
    }
    
    public String[] getLocations(){
        return locations;
    }
}
