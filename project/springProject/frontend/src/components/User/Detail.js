import React from 'react';
import {Link} from 'react-router-dom';
import { Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container } from 'reactstrap';

export const Detail = ({ticket,cancelTicket}) => {
    var journeyDate = new Date(ticket.journeyDate)
    var finalDate = journeyDate.getFullYear()+"-"+journeyDate.getMonth()+1+"-"+journeyDate.getDate();
    var bookingDate = new Date(ticket.bookingDateTime);
    var finalBookingDate = bookingDate.getFullYear()+"-"+bookingDate.getMonth()+1+"-"+bookingDate.getDate();
  return (
        
      <div>
          <Card className='text-center'>
            <CardBody>
            <CardTitle className='font-weight-bold'>{"Bus Number : "}{ticket.busId}</CardTitle>
            <CardSubtitle className='font-weight-bold'>
                {"JourneyDate "}{finalDate}
                {"    BookingDate "}{finalBookingDate}
                {"   BookedSeat  "}{ticket.numOfSeats}
                </CardSubtitle>  
            <Container className='text-center'>
                    <Link 
                    style={{width: 150}}
                    className='primary'
                    to={`/ticket/fullDetails/${ticket.ticket_id}`}>
                    View Details
                </Link>

                <Button 
                type = "submit"
                color = "danger"s
                style={{marginLeft:30}}
                onClick={() => {cancelTicket(ticket.ticket_id)}}
                >Cancel Ticket</Button>
            </Container>
            </CardBody>
        </Card>
      </div>
  )
};
