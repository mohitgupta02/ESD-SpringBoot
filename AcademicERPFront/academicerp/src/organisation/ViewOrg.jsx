import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
// Import FontAwesome icons
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faEye } from '@fortawesome/free-solid-svg-icons';
import Navbar from '../layout/Navbar';



export default function ViewOrg() {

  const [org,setOrg]=useState({
    name:"",
    profile:"",
    description:"",
    intake:"",
    min_grade:"",
    organisatonId:""
  });

  const {organisationId}=useParams();
  useEffect(()=>{
    loadOrg();
  },[]);

  const loadOrg = async ()=>{
      const token=localStorage.getItem('jwt');
      const result = await axios.get(`http://localhost:8081/place/${organisationId}`,{
        headers: {
          Authorization: 'Bearer ' + token
        }
       });
    console.log(result.data);
    setOrg(result.data);
  };

  return (

    <div className="container">
      <Navbar/>
      <div className="row">
        <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
          <h2 className="text-center m-4">organisation Details</h2>
          <div className="card">
            <div className="card-header">
                Details of Organisation:
                <ul className="list-group list-group-flush">

                    <li className="list-group-item">
                        <b>Name:</b>
                        {org.name}

                    </li>
                    
                    
                    <li className="list-group-item">
                        <b>Organisation_id:</b>
                        {org.organisationId}

                    </li>
                    
                </ul>
            </div>
          </div>

          
          <div className="d-flex justify-content-between mt-3">
            <Link className="btn btn-outline-success" to={"/home"}>
              Back
            </Link>
            <Link className="btn btn-outline-primary" to={"/viewdemo"}>
              <FontAwesomeIcon icon={faEye} className="mr-2" />
              View Students
            </Link>
          </div>
          </div>
        </div>
    </div>
  )
}
