import React,{useState} from 'react'
import {Link,History} from 'react-router-dom';
import { Button, Modal} from 'react-bootstrap';
import { Card, CardImg, CardText, CardBody,
CardTitle, CardSubtitle, Container } from 'reactstrap';
import { Form,FormGroup,Input } from 'reactstrap'
import axios from 'axios';
import { base_url } from "../server/bootapi";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { faCommentsDollar } from '@fortawesome/free-solid-svg-icons';

export const Bus = ({bus,deleteBus}) => {
    const [show, setShow] = useState(false);

    const [seats,setSeats] = useState(0);
    const [date,setDate] = useState(new Date());

    const handleClose = () => {
        var month = parseInt(date.getMonth())+1;
        var datevalue = parseInt(date.getDate());
        var finalDate;
        console.log(datevalue);
        if(month < 10){
            if(datevalue < 9){
                finalDate = date.getFullYear()+"-0"+month+"-0"+date.getDate();
            }
            else
            finalDate = date.getFullYear()+"-0"+month+"-"+date.getDate();
        }   
        else
            finalDate = date.getFullYear()+"-"+month+"-"+date.getDate();
        console.log(finalDate);

        const data = {
            busId:bus.busId,
            availableDate:finalDate,
            availableSeat:seats
        }
        console.log(data);  
        axios.post(`${base_url}/buses/seatAvaliability`,data)
             .then((response)=>{
                 console.log(response.data)
             }).catch((err)=>console.log(err));
        setShow(false);
    }
    const handleShow = () => setShow(true);
    return (
        <div>
        <Card className='text-center'>
            <CardBody>
            <CardImg top width="100%" src="https://assets.volvo.com/is/image/VolvoInformationTechnologyAB/BSVI_2new?qlt=82&wid=512&ts=1625744269778&fit=constrain" alt="Card image cap"></CardImg>
            <CardTitle className='font-weight-bold'>{bus.busName}</CardTitle>
            <CardSubtitle className='font-weight-bold'>{bus.startingPoint}{"     "}{bus.endingPoint}</CardSubtitle>
            <CardText>{bus.type}{" Price: "}{bus.cost}</CardText>
            {localStorage.getItem("jwtToken") && localStorage.getItem("authorities") !== "ROLE_USER" ? 
            <Container className='text-center'>
            <Button variant="info" onClick={handleShow}>
                Update SeatAvailability
            </Button>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                <Modal.Title>Seat Availability</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <FormGroup>
                        <Input 
                            type="text" 
                            placeholder="Available Date"
                            onChange={(e)=>{
                                setSeats(e.target.value);
                            }}
                        />
                    </FormGroup>

                    <FormGroup>
                    <DatePicker 
                            selected={date} 
                            onChange={(date) => setDate(date)} 
                            />
                    </FormGroup>

                </Modal.Body>
                <Modal.Footer>
                <Button variant="primary" onClick={handleClose}>
                    Save Changes
                </Button>
                </Modal.Footer>
            </Modal>

            <Button 
            type = "submit"
            variant="danger"
            style={{marginLeft:10}}
            onClick={() => {deleteBus(bus.busId)}}
            >Delete</Button>

            <Link to={`/buses/update/${bus.busId}`}>
                <Button 
                variant="primary"
                    style={{marginLeft:10}}
                    >Update
                </Button>
            </Link>
        </Container>    
        :""
        }
            
            </CardBody>
        </Card>
        </div>
    )
}
