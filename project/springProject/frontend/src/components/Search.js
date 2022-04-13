import React,{useState, useEffect} from 'react'
import axios from 'axios';
import { base_url } from './server/bootapi'
import { useNavigate } from 'react-router-dom';
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import {AvailableBus} from "./Bus/AvailableBus";

import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export const Search = () => {

    const navigate = useNavigate();
    const [startingPoint,setStartingPoint] = useState('');
    const [endingPoint,setEndingPoint] = useState('');
    const [startDate, setStartDate] = useState(new Date());
    const [availableBus,setAvailableBus] = useState([]);

    function getBusDetail(info){
        let data = info.map((bus)=> (getData(bus.busId,bus.availableSeat,bus.availableDate)));  
    }

    const getData = async (id,seat,date) => {
        const {data: response} = await axios.get(`${base_url}/buses/bus/${id}`);
        setAvailableBus(availableBus => [...availableBus,{bus:response.bus,seat:seat,date:date}]);
    }


    const onHandleSubmit = (e) =>{
        e.preventDefault();
        var searchDate = startDate.toISOString().split('T')[0]
        axios.get(`${base_url}/booking/checkAvailability/${startingPoint}/${endingPoint}/${searchDate}`)
            .then((response)=>{
                getBusDetail(response.data.availList)
            })
    }
    const diffToast = () => {
        toast.success("Available Buses!!");
      }

    return (
        <div>
                <section className='showcase'>
                   
      <div className='showcase-overlay'>
          
            <h2 className='text-center my-3                                 '>
                {availableBus.length > 0 ? "Available Buses" : "Search Bus Availability"}
                </h2>
            {availableBus.length > 0 ? availableBus.map(({bus,seat,date})=>(
                <AvailableBus 
                    key = {bus.busId}
                    bus = {bus}
                    date = {date}
                    seat = {seat}
                />
            )) :

            <Form onSubmit={onHandleSubmit}>                                                                                                                                                                                                                                                                                                                                                                                        
                <FormGroup>
                    <Label for="courseId">Source</Label>
                    <Input 
                    type="text" 
                    name="source" 
                    placeholder="Source Location"
                    onChange={(e)=>{
                        setStartingPoint(e.target.value);
                    }}
                    />

                </FormGroup>

                <FormGroup>
                    <Label for="coursetitle">Destination</Label>
                    <Input 
                    type="text" 
                    name="destination" 
                    placeholder="Destination"
                    onChange={(e)=>{
                        setEndingPoint(e.target.value);
                    }}
                     />
                </FormGroup>
                <FormGroup>
                    <Label for="Source Location">Date</Label>
                    <DatePicker 
                        selected={startDate} 
                        onChange={(date) => setStartDate(date)} 
                        />
                </FormGroup>

                <Container className='text-center'>
                    <Button 
                        className='btn btn-block btn-info'
                        color="primary" 
                        onClick={diffToast}
                        type="submit">Search Bus</Button>
                </Container>
                
            </Form>
            
}       
<ToastContainer/>
    </div>
   
    </section>
        </div>
    )
}
