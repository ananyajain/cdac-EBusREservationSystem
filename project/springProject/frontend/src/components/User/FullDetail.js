import React,{useState, useEffect} from 'react'
import axios from 'axios';
import { Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Container } from 'reactstrap';
import { base_url } from '../server/bootapi';
import { useNavigate,useParams } from 'react-router-dom';

export const FullDetail = () => {
    const {id} = useParams();
    const [details,setDetails] = useState([]);
    useEffect(()=>{
        getData();

    },[])


    const getData = () =>{
        axios.get(`${base_url}/ticket/getTicket/${id}`)
             .then((response)=>{
                 setDetails(response.data.ticket.ticketDetails);
             }).catch((err)=>console.log(err));
    }
  return (
        <div>
                        <section className='showcase login'>
            <div className='showcase-overlay'>
            {
            details.map(detail =>
            <Card className='text-center'>
                <CardBody>
                <CardImg top width="100%" src="https://assets.volvo.com/is/image/VolvoInformationTechnologyAB/BSVI_2new?qlt=82&wid=512&ts=1625744269778&fit=constrain" alt="Card image cap"></CardImg>
                    <CardTitle className='font-weight-bold'>{detail.name}</CardTitle>
                    <CardSubtitle className='font-weight-bold'>{detail.age}{"     "}{detail.gender}</CardSubtitle>
                </CardBody>
            </Card>
            )
            }
            </div>
            </section>
        </div>
    )
}
