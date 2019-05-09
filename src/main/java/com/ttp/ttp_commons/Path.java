/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttp.ttp_commons;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.errors.ApiException;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.TravelMode;
import java.io.IOException;

/**
 *
 * @author Graham
 */
public class Path {
    private final Location from;
    private final Location to;
    private DirectionsResult direction;
    private long distance;

    public Path(Location from, Location to) {
        this.from = from;
        this.to = to;
    }
    
    public void calculateDirections(GeoApiContext mGeoApiContext, String mode){
        final DirectionsApiRequest directions = new DirectionsApiRequest(mGeoApiContext);
        directions.alternatives(false);
        directions.mode(TravelMode.valueOf(mode));
        directions.origin(new com.google.maps.model.LatLng(from.getLocation().lat, from.getLocation().lng));
        directions.destination(new com.google.maps.model.LatLng(to.getLocation().lat, to.getLocation().lng))
            .setCallback(new PendingResult.Callback<DirectionsResult>() {
                @Override
                public void onResult(DirectionsResult result) {
                    if(result.routes.length > 0){
                        direction = result;
                        distance = 0;
                        for(DirectionsRoute route : direction.routes){
                            for(DirectionsLeg leg : route.legs){
                                distance += leg.distance.inMeters;
                            }
                        }
                    } else {
                        direction = null;
                        distance = 0;
                    }
                }

                @Override
                public void onFailure(Throwable e) {
                    System.out.println(e.getMessage());
                }
            });
}
    
    public void forceDirections(GeoApiContext mGeoApiContext, String mode) throws ApiException, InterruptedException, IOException{
        direction = DirectionsApi.newRequest(mGeoApiContext)
                .mode(TravelMode.valueOf(mode))
                .origin(new com.google.maps.model.LatLng(from.getLocation().lat, from.getLocation().lng))
                .destination(new com.google.maps.model.LatLng(to.getLocation().lat, to.getLocation().lng))
                .await();
            
        distance = 0;
        for(DirectionsRoute route : direction.routes){
            for(DirectionsLeg leg : route.legs){
                distance += leg.distance.inMeters;
            }
        }
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public DirectionsResult getDirection() {
        return direction;
    }
    
    public Long getDistance() {
        return distance;
    }
}
