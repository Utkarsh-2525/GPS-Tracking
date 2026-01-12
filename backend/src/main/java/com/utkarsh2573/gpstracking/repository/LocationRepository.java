package com.utkarsh2573.gpstracking.repository;

import com.utkarsh2573.gpstracking.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long> {
}