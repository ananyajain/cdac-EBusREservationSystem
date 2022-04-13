import React, { useState } from "react";
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'

import axios from "axios";

import { base_url } from "../server/bootapi";
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';


export const Register = () => {
  const [user,setUser] = useState({});
  const navigate = useNavigate();
  const RegisterForm = (e) => {
      e.preventDefault();
      console.log(user);
      
      axios.post(`${base_url}/user/register`,user).then((response)=>{
          console.log(response.data);
          setUser({});
          navigate("/login");                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               
      },(error)=>{
          console.log(error);
      })
  };                                                                                                        

  const diffToast = () => {
    toast.success("Registration Done successfull");
   // position:"top-center"
  }
  return (
    <div>
        <section className='showcase login'>
        <div className='showcase-overlay'>
      <Form onSubmit={RegisterForm}>
                <FormGroup>
                    <Input 
                    type="text" 
                    name="id" 
                    placeholder="Name"
                    onChange={(e)=>{
                        setUser({...user,name:e.target.value});
                    }}
                    required
                    />

                </FormGroup>

                <FormGroup>
                    <Input 
                    type="text" 
                    name="email" 
                    placeholder="EmailId"
                    onChange={(e)=>{
                        setUser({...user,email:e.target.value});
                    }}
                    required
                     />
                </FormGroup>
                <FormGroup>
                    <Input 
                    type="text" 
                    name="mobile" 
                    placeholder="MobileNumber"
                    onChange={(e)=>{
                        setUser({...user,mobile:e.target.value});
                    }}
                    required
                     />
                </FormGroup>
                <FormGroup>
                    <Input 
                    type="password" 
                    name="title" 
                    placeholder="Password"
                    onChange={(e)=>{
                        setUser({...user,password:e.target.value});
                    }}
                    required
                     />
                </FormGroup>

                <Button 
                className='btn btn-block btn-info'
                
              onClick={diffToast}

                color="info" type="submit">Register</Button>
            </Form>

            </div>
            <ToastContainer/>
            </section>
    </div>
  );
};
