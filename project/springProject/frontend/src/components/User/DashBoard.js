import React, { useEffect,useState } from 'react';
import { useParams } from 'react-router-dom';

import axios from 'axios';
import { base_url } from "../server/bootapi"
import { useNavigate } from 'react-router-dom';
import {Detail} from "./Detail";

export const DashBoard = () => {
  const [details,setDetails] = useState([]);
    useEffect(()=>{
        getData();

    },[])


    const getData = () =>{
      const email = localStorage.getItem("email");
        axios.get(`${base_url}/ticket/getAllTicket/${email}`)
             .then((response)=>{
               console.log(response.data);
                 setDetails(response.data.ticketList);
             }).catch((err)=>console.log(err));
    }

    const cancelTicket = (id) =>{
      axios.delete(`${base_url}/ticket/deleteTicket/${id}`)
      .then((response)=>{
          getData();
      }).catch((err)=>console.log(err));
  }

  return(
    <div>
                  <section className='showcase login'>
            <div className='showcase-overlay'>
      {
        
      details.length > 0 ? 
        details.map((detail)=>(
          <Detail key={detail.ticket_id}
                  ticket={detail}
                  cancelTicket = {cancelTicket}
          />
      ))
      :"No booking yet"}
    </div>
    </section>
    </div>
  ) 
};
