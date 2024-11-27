import React, { useState } from 'react'
import axios from 'axios';
import { Link,useNavigate } from 'react-router-dom';
// import { ToastContainer, toast } from 'react-toastify';
import '../App.css';
import toast, { Toaster } from 'react-hot-toast';
// import log from "./moon.png";

export default function Login() {
    let navigate=useNavigate();

    // const [user,setUser]=useState({
    //   name:"",
    //   username:"",
    //   email:""
    // })

    const [loginData,setLoginData]=useState({
      email:"",
      password:""
    })
    // const{name,username,email} = user
    
    const{email,password}=loginData
    const [pop,setPop] = useState(false);

    const [loginstatus,setLoginstatus]=useState(true);

    // const onInputChange=(e)=>{
      //   setUser({...user,[e.target.name]:e.target.value})
      // };
      
      const onInputChange=(e)=>{
        setLoginData({...loginData,[e.target.name]:e.target.value})
      }
      
      const [msg,setMsg] = useState("");
      
      // const onSubmit= async (e)=>{
        //     e.preventDefault();
        //     // await axios.post("http://localhost:8080/user",user)
        //     navigate("/home")
        // };
    
      
      const  handlesubmit = async() => {

      try{
        const response = await axios.post("http://localhost:8081/login",loginData);
        console.log(response.data.message);
        localStorage.setItem('jwt',response.data.message)
        // setLoginstatus(response.data.status);
        console.log(response);

        if(response.data.status===true)
        {
            // setAuth(true);
            toast.success("Logged In");
            navigate("/home");
        }
        else
        {
          // alert(`wrong pass : ${response.data.message}`);
          // notify(response.data.message)
          // toast.success("Product Added in Cart Successfully"
          toast.error(response.data.message)
          navigate("/")
        }
      }      catch(error){
        toast.error(`login failed bro:${error}`);
        navigate("/")
      }
      
    }

    const onSubmit= (e)=>{
      e.preventDefault();
      console.log(loginData);
      handlesubmit();
    };

  return (
    <div style={{ 
    //   backgroundImage: `url(${log})`,
      // background:'url("chrome://global/skin/media/imagedoc-darknoise.png")',
      backgroundRepeat: 'no-repeat',
      backgroundSize: 'cover',
      height: '100vh',
      paddingTop: '50px',
      paddingBottom: '50px',
    }}>
    <div className="container align-items-center justify-content-center bg" >
        <div className='row p-3'>
          <div className='col-md-6 offset-md-3 border rounded p-3 mt-5 custom-shadow'>
            <h2 className='text-center m-4'>
            <svg xmlns="http://www.w3.org/2000/svg" width="40" height="40" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
              <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0"/>
              <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8m8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1"/>
            </svg></h2>
            <form onSubmit={(e)=>onSubmit(e)}>
        
            <div className='mb-3'>
              <label htmlFor='Email' className='form-label'>
                Enter Your Email
              </label>
              <input
              type={"text"}
              className="form-control"
              placeholder='Enter your Email'
              name="email"
              value={email}             
              onChange={(e)=>onInputChange(e)}
              />
            </div>
              {pop && toast.success("hello  welcome")}
            <div className='mb-3'>
              <label htmlFor='Password' className='form-label'>
                Enter Password
              </label>
              <input
              type={"password"}
              className="form-control"
              placeholder='Enter your password'
              name="password"
              value={password}
              onChange={(e)=>onInputChange(e)}
              />
            </div>
            {/* <ToastContainer/> */}
            <div className="d-flex justify-content-center"> {/* Center the button */}
              <button type="submit" className='btn btn-outline-info btn-primary' >Submit</button>
              {/* <button onClick={notify}>Make me a toast</button> */}
              <Toaster />
            </div>
            </form>
          </div>
        </div>
        </div>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
        <br></br>
    </div>
  )
}
