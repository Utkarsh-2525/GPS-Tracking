import React, { useState } from "react";
import Login from "./pages/login";
import MapPage from "./pages/MapPage";

const App: React.FC = () => {
    const [token, setToken] = useState<string | null>(null);

    if (!token) {
        return <Login setToken={setToken} />;
    }

    return <MapPage />;
};

export default App;
