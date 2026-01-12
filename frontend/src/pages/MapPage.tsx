import React, { useEffect, useState } from "react";
import { MapContainer, TileLayer, Marker, Popup } from "react-leaflet";
import api from "../api/api";
import "../leafletIcon";

interface Location {
    latitude: number;
    longitude: number;
}

const MapPage: React.FC = () => {
    const [location, setLocation] = useState<Location | null>(null);

    useEffect(() => {
        const watchId = navigator.geolocation.watchPosition(
            (pos) => {
                const loc = {
                    latitude: pos.coords.latitude,
                    longitude: pos.coords.longitude
                };

                setLocation(loc);

                api.post("/location/update", {
                    userId: 1,
                    latitude: loc.latitude,
                    longitude: loc.longitude
                });
            },
            (err) => console.error(err),
            { enableHighAccuracy: true }
        );

        return () => navigator.geolocation.clearWatch(watchId);
    }, []);

    if (!location) return <p>Fetching location...</p>;

    return (
        <MapContainer
            center={[location.latitude, location.longitude]}
            zoom={15}
            style={{ height: "100vh", width: "100%" }}
        >
            <TileLayer
                attribution='© OpenStreetMap contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />

            <Marker position={[location.latitude, location.longitude]}>
                <Popup>You are here</Popup>
            </Marker>
        </MapContainer>
    );
};

export default MapPage;
