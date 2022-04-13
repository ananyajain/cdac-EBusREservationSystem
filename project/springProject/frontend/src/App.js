import React from 'react'
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Header from './components/Header'
import Showcase from './components/Showcase'
import Destinations from './components/Destinations'
import Footer from './components/Footer'

import Error from './components/Error'
import {Home} from './components/Home';
import {Menus} from './components/Menus';

import {Register} from './components/User/Register';
import  {Login}  from './components/User/Login';
import  {Logout}  from './components/User/Logout';
import  {AboutUs}  from './components/AboutUs';
import  {ContactUs}  from './components/ContactUs';
import {BusList} from "./components/Bus/BusList";
import {Bus}  from './components/Bus/Bus';
import {AddBus}  from './components/Bus/AddBus';
import {EditBus}  from './components/Bus/EditBus';
import {Search}  from './components/Search';
import {BookTicket} from "./components/BookTicket";  
import {DashBoard} from "./components/User/DashBoard";
import {FullDetail} from "./components/User/FullDetail";


function App() {
  return (
    <Router>
      <Menus />
      <Routes>
        <Route path="/" element={[<Search />, <Destinations/>]} />
        <Route path="/search" element={<Search />}/>
        <Route path="/login" element={<Login />}/>
        <Route path="/AboutUs" element={<AboutUs />}/>
        <Route path="/ContactUs" element={<ContactUs />}/>
        <Route path="/register" element={<Register />}/>
        <Route path="/addbus" element={<AddBus />}/>  
        <Route path="/buses" element={<BusList />}/>
        <Route path="/buses/update/:id" element={<EditBus />}/>
        <Route path="/user/dashboard" element={<DashBoard />}/>
        <Route path="/logout" element={<Logout />}/>
        <Route path="/buses/book/:id/:date" element={<BookTicket />}/>
        <Route path="/ticket/fullDetails/:id" element={<FullDetail />}/>
        <Route path="*" element={<Error />}/>
      </Routes>
      <Footer />
    </Router>
  )
}

export default App
