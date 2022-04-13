import React,{useState, useEffect} from 'react'
import {Link,History} from 'react-router-dom';

import { base_url } from '../server/bootapi'
import authToken from '../util/AuthToken';
import axios from 'axios';



import {Bus} from "./Bus";

export const BusList = () => {
    const [buses,setBuses]  = useState([]);

    useEffect(() => {
        if(localStorage.getItem("jwtToken")){
            authToken(localStorage.getItem("jwtToken"));
        }             
        getbusList();
    }, [])

    const deleteBus = (id) =>{
        axios.delete(`${base_url}/buses/deleteBus/${id}`).then((response) =>{
            console.log("deleted",response.data);
            getbusList();
        },(error)=>{
            console.log(error);
        })
    }

    const getbusList = () =>{
        axios.get(`${base_url}/booking/getAllBus`).then((response)=>{
            console.log(response.data.busList);
            setBuses(response.data.busList);
        },(error)=>{
            console.log(error);
        })
    }

    return (
        <div>
            <section className='showcase login'>
            <div className='showcase-overlay'>
            {
                buses.length > 0 ? buses.map((bus)=>
                (
                    <Bus key = {bus.busId} 
                            bus = {bus} 
                            deleteBus = {deleteBus}
                    />
                ))
    : "No Buses Available"
            }
            </div>
            </section>
        </div>
    )
}
