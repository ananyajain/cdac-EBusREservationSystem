import React,{useEffect} from 'react'
import { useNavigate } from 'react-router-dom';

export const Logout = () => {
    const navigate = useNavigate();
    useEffect(() => {
        localStorage.removeItem("jwtToken");
        localStorage.removeItem("email");
        navigate("/");
    }, [])
    return (
        <div>
            
        </div>
    )                                                                                                                                           
}
