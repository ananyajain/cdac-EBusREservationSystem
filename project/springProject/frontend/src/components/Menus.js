import React from 'react'
import { ListGroup, ListGroupItem } from 'reactstrap'
import {Link} from 'react-router-dom';
import { useNavigate } from 'react-router-dom';


export const Menus = () => {

    const navigate = useNavigate();
    const guestLinks = (
        <>
        <Link className='links' to="/login" action>
            Login
        </Link>
        <Link className='links' to="/register" action>
            Register
        </Link>
        </>
      );

      
      const userLinks = (
        <>
            <Link className='links' to="/buses" action>
                Bus List
            </Link>

            <Link className='links' to="/user/dashboard" action>
                Dashboard
            </Link>

            <Link className='links'to="/logout">
            Logout
        </Link>

        </>
      );
      const adminLinks = (
        <>
          <Link className='links' to="/addBus" action>
              Add Bus
          </Link>
        </>
    )
      
    return (

    <header className='header'>
      
 
      <div>
        
        <Link className='links' to='/'>
          Home
        </Link>
        <Link className='links' to='/AboutUs'>
          AboutUs
        </Link>
        
        <Link className='links' to='/ContacttUs'>
          ContactUs
        </Link>
        &nbps;
        &nbps;
        &nbps;
        &nbps;
        &nbps;
        &nbps;
        
        <Link className='links' to='/'>
          E-BUS RESERVATION SYSTEM
        </Link>
        
      </div>
     

      <nav className='navbar'>
        <ul>
        {localStorage.getItem("jwtToken") ? userLinks : guestLinks}
        {localStorage.getItem("jwtToken") && localStorage.getItem("authorities") !== "ROLE_USER" ? adminLinks : ""}
        </ul>
      </nav>
    </header>
    )
}

