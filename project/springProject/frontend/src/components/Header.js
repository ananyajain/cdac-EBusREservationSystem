import React from 'react'
import { Link } from 'react-router-dom'

const Header = () => {
  return (
    
    <header className='header'>
      
      <div>
        <Link className='links' to='/'>
          aboutus
        </Link>
        <Link className='links' to='/'>
          ContactUs
        </Link>
        <Link className='links' to='/'>
          Home
        </Link>
        
      </div>

      <nav className='navbar'>
        <ul>
          <Link className='links' to='/login'>
            Login
          </Link>
          <Link className='links' to='/register'>
            Sign Up
          </Link>
        </ul>
      </nav>
    </header>
  )
}

export default Header
