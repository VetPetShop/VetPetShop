import React, { useEffect } from "react";
import { useNavigate } from "react-router";

function Logout(){

    const navigate = useNavigate();

    useEffect(()=>{

        localStorage.removeItem('userData');

        window.location.reload();
        navigate("/");
        // window.location.reload();
        
    },[navigate])
        
    return (
        <div>Logging out...</div>
      );

}export default Logout;