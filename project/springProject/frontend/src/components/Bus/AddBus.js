import React,{useState, useEffect} from 'react'
import axios from 'axios';
import { base_url } from '../server/bootapi';
import { useNavigate } from 'react-router-dom';
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export const AddBus = () => {

    const [bus,setBus] = useState({});
    const navigate = useNavigate();

    useEffect(()=>{
        setBus({})
    },[])

    const addBus = (bus) =>{
        console.log(bus);
        axios.post(`${base_url}/buses/addBus`,bus).then((response)=>{
            console.log(response.data);
            setBus({});
            navigate("/buses");
        },(error)=>{
            console.log(error);
        })
    }

    const onHandleSubmit = (e) =>{
        e.preventDefault();
        addBus(bus);
    }
    const diffToast = () => {
        toast.success("added Bus successfull!!!!");
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
                    onChange={(e)=>{
                        setBus({...bus,busId:e.target.value});
                    }}
                    required
                    />

                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="name" 
                    placeholder="busName"
                    onChange={(e)=>{
                        setBus({...bus,busName:e.target.value});
                    }}
                    required
                     />
                </FormGroup>


                <FormGroup>
                    <Input type="text" name="source" placeholder="Source Location"
                    onChange={(e)=>{
                        setBus({...bus,startingPoint:e.target.value});
                    }}/>
                </FormGroup>

                <FormGroup>
                    <Input type="text" name="destination" placeholder="Source Destination"
                    onChange={(e)=>{
                        setBus({...bus,endingPoint:e.target.value});
                    }}
                    required
                    />
                </FormGroup>

                <FormGroup>
                    <Input type="text" name="type" placeholder="Bus Type"
                    onChange={(e)=>{
                        setBus({...bus,busType:e.target.value});
                    }}
                    required
                    />
                </FormGroup>

                <FormGroup>
                    <Input type="text" name="seats" placeholder="Seats"
                    onChange={(e)=>{
                        setBus({...bus,totalSeats:e.target.value});
                    }}
                    required
                    />
                </FormGroup>

                <FormGroup>
                    <Input type="text" name="price" placeholder="Price"
                    onChange={(e)=>{
                        setBus({...bus,cost:e.target.value});
                    }}
                    required
                    />

                </FormGroup>

                <Button color="primary" 
                className='btn btn-primary btn-block'
                onClick={diffToast}
                type="submit">Add Bus</Button>
            </Form>
            </div>
            <ToastContainer/>
            </section>
        </div>
    )
}
