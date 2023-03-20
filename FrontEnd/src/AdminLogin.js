import { useNavigate } from 'react-router-dom';
import './adminlogin.css';
import React, {useState} from 'react';
import axios from 'axios';
import AdminHome from './adminHome';


 export default function Login()
  {
    const navigate=useNavigate();

  const [Email, setEmail] = useState('');
  const [Password, setPassword] = useState('');
  

  const handleSubmit = (event) => {
      event.preventDefault();
      const admin={
          email_id:Email,
          password:Password,
         
      }

      axios.post('http://localhost:8080/api/admin/signin',admin)
          .then(response => {
              console.log(response.data)
              if(response.data!=null){
                alert("Login successfully!!")
                               
               navigate("/admin")  
                 
              }
          })
          .catch(error => {
             console.log("no page")
          });
  }


  return(
<div class="wrapper">
        
      
        <div class="text-center mt-4 name" align={'center'}>
          Admin Login
        </div>
        <form class="p-3 mt-3" onSubmit={handleSubmit}>
            <div class="form-field d-flex align-items-center">
                <span class="far fa-user"></span>
                <input type="email" name="email" id="email" placeholder="email" onChange={e=>setEmail(e.target.value)}/>
            </div>
            <div class="form-field d-flex align-items-center">
                <span class="fas fa-key"></span>
                <input type="password" name="password" id="pwd" placeholder="Password"onChange={e=>setPassword(e.target.value)}/>
            </div>

            

            <button className="btn mt-3">Login</button>
        </form>
        <div className="text-center fs-6">
            <a href="#">Forget password?</a>
        </div>
    </div>

  )

 
  }

