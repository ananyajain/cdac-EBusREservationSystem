import React,{useState,useEffect} from 'react'
import { useParams } from 'react-router-dom';

import axios from 'axios';
import { base_url } from './server/bootapi';
import { useNavigate } from 'react-router-dom';
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export const BookTicket = () => {
    const {id,date} = useParams();
    const [ticketDetail,setTicketDetail] = useState([]);
    const [singleDetail,setSingleDetail] = useState({});
    const [seats,setSeats] = useState([]);
    const navigate = useNavigate();


    useEffect(()=>{
        if(!localStorage.getItem("jwtToken")){
            navigate("/login");
        }
    },[])

    const onHandleSubmit = (e) =>{
        e.preventDefault();
        const ticketDetails = [];

        for(let i = 1;i<ticketDetail.length;i++){
            ticketDetails.push(ticketDetail[i].detail);
        }
        const data = {
            busId:ticketDetail[0].busId,
            emailId:localStorage.getItem("email"),
            journeyDate:ticketDetail[0].journeyDate,
            numOfSeats:ticketDetail[0].seats,
            ticketDetails:ticketDetails
        }
        console.log(data);
        
        axios.post(`${base_url}/ticket/bookTicket`,data)
            .then((response)=>{
                console.log(response)
                navigate('/user/dashboard')
            },(error)=>{
                console.log(error);
            }).catch((err)=>console.log(err));



    }
    

    const diffToast=()=>{

        toast.success("Ticket Booked Successfully!!!!");
        }
      
    return (
        <div>
            <section className='showcase login'>
            <div className='showcase-overlay'>
            <Form onSubmit={onHandleSubmit}>
                <FormGroup>
                    <Label for="courseId">BusNumber</Label>
                    <Input 
                    type="text" 
                    name="busNumber" 
                    value = {id}
                    placeholder="BusNumber"
                    required
                    />

                </FormGroup>

                <FormGroup>
                    <Label for="courseId">Journey Date</Label>
                    <Input 
                    type="text" 
                    name="busNumber" 
                    value = {date}
                    placeholder="BusNumber"
                    />Date
                           required
                </FormGroup>

                <FormGroup>
                    <Label for="Seats">Seats</Label>
                    <Input type="text" 
                    name="seats" 
                    placeholder="Seats"
                    onChange={(e)=>{
                        setTicketDetail(ticketDetail => [...ticketDetail,{
                            seats:e.target.value,busId:id,journeyDate:date}]);
                        for(let i = 1;i<=e.target.value;i++)
                            seats.push(i);
                    }}
                    required
                    />
                </FormGroup>

                {
                    seats.length > 0 ? 
                    seats.map((seat) => (
                        <>
                            <FormGroup>
                                <Label for="name">Name{seat}</Label>
                                <Input 
                                    type="text" 
                                    name="name" 
                                    placeholder="Name"
                                    onChange={(e)=>{
                                        setSingleDetail({...singleDetail,name:e.target.value});
                                    }}
                                />
                            </FormGroup>

                            <FormGroup>
                                <Label for="name">Age{seat}</Label>
                                <Input 
                                    type="text" 
                                    name="age" 
                                    placeholder="Age"
                                    onChange={(e)=>{
                                        setSingleDetail({...singleDetail,age:e.target.value});
                                    }}
                                    required
                                />
                            </FormGroup>

                            <FormGroup>
                                <Label for="name">Gender{seat}</Label>
                                <Input 
                                    type="text" 
                                    name="gender" 
                                    placeholder="gender"
                                    onChange={(e)=>{
                                        setSingleDetail({...singleDetail,gender:e.target.value});
                                    }}
                                    required
                                />
                            </FormGroup>

                            <Container className='text-center'>
                                <Button color="primary" 
                                className='btn btn-block btn-secondary'
                                onClick={() => {
                                    console.log(singleDetail);
                                    setTicketDetail(ticketDetail => [...ticketDetail,{detail:singleDetail}])
                                    setSingleDetail({});
                                }}
                               // onClick={diffToast}
                                >Add Detail</Button>
                                
                            </Container>
                        </>
                    )) :''
                }
                <Container className='text-center'>
                        <Button color="success" 
                        className='btn btn-block btn-info'
                        style={{marginTop:100}}
                       onClick={diffToast}
                        type="submit">BookTicket</Button>
                </Container>
                <ToastContainer/>  
            </Form>
           
            </div>
            </section>
        </div>
    )
}
