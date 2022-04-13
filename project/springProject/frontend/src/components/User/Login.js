import React,{useState} from 'react'
import { Form,FormGroup,Label,Input, Container, Button } from 'reactstrap'
import axios from 'axios';
import { base_url } from '../server/bootapi';
import { useNavigate } from 'react-router-dom';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';

export const Login = () => {
    const navigate = useNavigate();
    const [user,setUser] =  useState({})


    const LoginForm = (e) => {
        e.preventDefault();
        axios.post(`${base_url}/user/authenticate`,user).then((response)=>{
            let token = response.data.token;
            let email = response.data.email;
            let authorities = response.data.authorities[0];
            console.log(response.data);
            localStorage.setItem('jwtToken',token);
            localStorage.setItem('email',email);
            localStorage.setItem("authorities",authorities)
           alert("Login Successfull!!");
            navigate("/");
        },(error)=>{
            console.log(error);
            alert("Invalid Credential!!!!");
        })
        
        };
        const diffToast = () => {
            toast.success("Login successfull");
         //   position:"top-center"
          }
        
    return (
        <div>
         <section className='showcase login'>
            <div className='showcase-overlay'>
            <Form onSubmit={LoginForm}>
                <FormGroup>
                    <Input 
                    type="text" 
                    name="emailId" 
                    placeholder="Email"
                    
                    onChange={(e)=>{
                        setUser({...user,email:e.target.value});
                        
                        
                    }}
                    required
                    />

                </FormGroup>

                <FormGroup>
                    <Input 
                    type="password" 
                    name="password" 
                    placeholder="Password"

                    onChange={(e)=>{
                        setUser({...user,password:e.target.value});
                        
                    }}
                    required
                     />
                </FormGroup>

                <Button 
                    className='btn btn-block btn-info'
                    color="info" 
                    onClick={diffToast}
                    type="submit">Login
                </Button>
            </Form>
           /
            </div>
            </section>
    </div>
    )
}
