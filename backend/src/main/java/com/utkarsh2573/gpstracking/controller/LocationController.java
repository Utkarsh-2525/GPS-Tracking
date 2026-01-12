package com.utkarsh2573.gpstracking.controller;

import com.utkarsh2573.gpstracking.dto.LocationRequest;
import com.utkarsh2573.gpstracking.entity.Location;
import com.utkarsh2573.gpstracking.repository.LocationRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/location")
@CrossOrigin
public class LocationController {

    private final LocationRepository repo;

    public LocationController(LocationRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/update")
    public void update(@RequestBody LocationRequest req) {
        Location loc = new Location();
        loc.setUserId(req.userId());
        loc.setLatitude(req.latitude());
        loc.setLongitude(req.longitude());
        loc.setTimestamp(LocalDateTime.now());
        repo.save(loc);
    }
}
