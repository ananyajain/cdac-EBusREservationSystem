import React from 'react'
import { setDefaultLocale } from 'react-datepicker';
import {Link,History} from 'react-router-dom';
import { Card, CardImg, CardText, CardBody,
    CardTitle, CardSubtitle, Button, Container } from 'reactstrap';
export const AvailableBus = ({bus,seat,date}) => {
    return (
        <div>
            {console.log(bus)}
            <Card className='text-center'>
                <CardBody>
                <CardImg top width="100%" src="https://assets.volvo.com/is/image/VolvoInformationTechnologyAB/BSVI_2new?qlt=82&wid=512&ts=1625744269778&fit=constrain" alt="Card image cap"></CardImg>
                <CardTitle className='font-weight-bold'>{bus.busName}</CardTitle>
                <CardSubtitle className='font-weight-bold'>{bus.startingPoint}{"     "}{bus.endingPoint}</CardSubtitle>
                <CardText>{bus.type}{" Price: "}{bus.cost}{"  Available-Seat "}{seat}</CardText>
                <Container className='text-center'>
                <Link to={`/buses/book/${bus.busId}/${date}`}>
                    <Button 
                    className='btn btn-info btn-block'
                    type="submit"
                    >Book Seat</Button>
                </Link>
                </Container>
            </CardBody>
        </Card>
        </div>
    )
}
