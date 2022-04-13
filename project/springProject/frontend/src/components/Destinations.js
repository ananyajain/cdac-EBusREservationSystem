import React from 'react'
import image1 from '../assets/image1.jpg'
import image2 from '../assets/image2.png'
import image3 from '../assets/image3.jpg'

const Destinations = () => {
  return (
    <section className='destinations'>
      <h3>Now available in 46 countries!</h3>
      <div className='grid'>
        <div>
          <img src={image1} alt='destination-1' />
          <h3>Travel Across India</h3>
          <p>
            E-bus Reservation system provides the facility to traavel
            across the india without any hussle.
          </p>
        </div>

        <div>
          <img src={image2} alt='destination-2' />
          <h3>Experience </h3>
          <p>
            Fast and Easy Online Booking.
            Zero Booking Free No Extra Charges For Online booking
            
          </p>
        </div>

        <div>
          <img src={image3} alt='destination-3' />
          <h3>Service</h3>
          <p>
            Online Cancellation and Phone Support Available.
            Book Bus Tickets online for major route acrossIndia
          </p>
        </div>
      </div>
    </section>
  )
}

export default Destinations
