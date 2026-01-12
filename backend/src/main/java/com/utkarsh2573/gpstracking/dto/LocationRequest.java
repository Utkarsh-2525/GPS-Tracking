package com.utkarsh2573.gpstracking.dto;

public record LocationRequest(
        Long userId,
        double latitude,
        double longitude
) {}
