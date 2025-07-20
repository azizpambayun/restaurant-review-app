package com.project.restaurant.services;

import com.project.restaurant.domain.GeoLocation;
import com.project.restaurant.domain.entities.Address;

public interface GeoLocationService {
    GeoLocation geoLocate(Address address);
}
