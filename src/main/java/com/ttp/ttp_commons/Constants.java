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
public class Constants {
    private final static String google_map_api_key = "AIzaSyADAKoMEDAV7NwnBkuVT3-oZ-nfXAFUAJY";
    private final static String wsdl = "http://localhost:8080/TourCreation/TourCreation?WSDL";

    public static String getWsdl() {
        return wsdl;
    }
    
    public static String getGoogle_map_api_key() {
        return google_map_api_key;
    }
}
