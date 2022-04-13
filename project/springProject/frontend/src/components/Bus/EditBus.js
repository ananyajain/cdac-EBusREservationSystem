import React,{useState, useEffect} from 'react'
import axios from 'axios';
import { base_url } from '../server/bootapi';
import { useNavigate,useParams } from 'react-router-dom';
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'

export const EditBus = () => {

    const [bus,setBus] = useState({});
    const navigate = useNavigate();
    const {id} = useParams();

    useEffect(()=>{
        getDataFromServer();
    },[])


    const getDataFromServer = () =>{
        console.log(id);
        axios.get(`${base_url}/buses/bus/${id}`).then((response)=>{
            console.log(response.data.bus);
            setBus(response.data.bus);
        },(error)=>{
            console.log(error);
        })
    }

    const updateBus = (bus) =>{
        console.log(bus);
        axios.put(`${base_url}/buses/updateBus`,bus).then((response)=>{
            console.log(response.data);
            setBus({});
            navigate("/buses");
        },(error)=>{
            console.log(error);
        })
    }

    const onHandleSubmit = (e) =>{
        e.preventDefault();
        updateBus(bus);
    }


    return (
        <div>
            <section className='showcase login'>
            <div className='showcase-overlay'>
            <Form onSubmit={onHandleSubmit}>
                <FormGroup>
                    <Input 
                    type="text" 
                    name="busNumber" 
                    placeholder="BusNumber"
                    value={bus.busId}
                    onChange={(e)=>{
                        setBus({...bus,busId:e.target.value});
                    }}
                    />

                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="name" 
                    value={bus.busName}
                    placeholder="busName"
                    onChange={(e)=>{
                        setBus({...bus,busName:e.target.value});
                    }}
                     />
                </FormGroup>


                <FormGroup>
                    <Input 
                    type="text" 
                    name="source" 
                    value={bus.startingPoint}
                    placeholder="Source Location"
                    onChange={(e)=>{
                        setBus({...bus,startingPoint:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="destination" 
                    value={bus.endingPoint}
                    placeholder="Source Destination"
                    onChange={(e)=>{
                        setBus({...bus,endingPoint:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="type" 
                    value={bus.busType}
                    placeholder="Bus Type"
                    onChange={(e)=>{
                        setBus({...bus,busType:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="seats" 
                    value={bus.totalSeats}
                    placeholder="Seats"
                    onChange={(e)=>{
                        setBus({...bus,totalSeats:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="price" 
                    value={bus.cost}
                    placeholder="Price"
                    onChange={(e)=>{
                        setBus({...bus,cost:e.target.value});
                    }}/>

                </FormGroup>
                <Button className='btn btn-primary btn-block' color="success" type="submit">Update Bus</Button>
            </Form>
            </div>
            </section>
        </div>
    )
}
