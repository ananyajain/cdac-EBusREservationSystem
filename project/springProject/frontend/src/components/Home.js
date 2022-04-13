import React from 'react';
import {Container,Button} from 'reactstrap';

export const Home = () => {
    return (
        <div className='text-center'>
            <div className="container-fluid bg-light text-dark p-3">
                <div className="container bg-light p-3">
                    <h1>LearnCode with Anshul</h1>
                    
                    <p>This is developed by learncode with anshul for learning purpose</p>
                    <Container>
                        <Button color = "primary" outline>Start Using</Button>
                    </Container>
                </div>
            </div>
        </div>
    )
}

