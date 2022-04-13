import React from 'react'
import image1 from '../assets/image1.jpg'
const Error = () => {
  return (
    <div
      style={{
        height: '100vh',
        display: 'flex',
        alignItems: 'Top',
        justifyContent: 'center'
      }}
    >
      <h1></h1>
      <p>
      <h4>
        Regarding Any Query:<br></br></h4>
       <h3> Please ContactUs</h3>
       Name:Ananya Jain
       EmailId:jainananya13@gmail.com<br></br>
       Mobile No:7898135525
       Website:www.onlineTicket.com<br></br>
       <br></br>
       <br></br>
       <h3> Alternate Contact details</h3>
       Name:Ashish Thube
       EmailId:thubeAshish23@gmail.com<br></br>
       Mobile No:8744567888
       Website:www.onlineTicket.com<br></br>
       <br></br>
       <br></br>
       <h3> Company Website Details</h3>

       EmailId:OnlineEticket23@gmail.com<br></br>
       Website:www.onlineTicket.com<br></br>
</p>
      <img src={image1} alt='destination-1' />
    </div>
    
  )
}

export default Error
