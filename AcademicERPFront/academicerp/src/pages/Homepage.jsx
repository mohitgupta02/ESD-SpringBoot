import React, { useEffect, useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom';
import Navbar from '../layout/Navbar';

export default function Homepage() {

    const [org,setOrg]=useState([]);  {/*object to store data*/}

    useEffect(()=>{                    {/*load info every time page loads */}
         loadOrg();
    },[]);  {/* if we do not give [](empty array) then it will run for infinte time */}

    const loadOrg = async () => {
      try {
          const token = localStorage.getItem('jwt');
          console.log(token);
          
          const result = await axios.get("http://localhost:8081/place", {
              headers: {
                  Authorization: `Bearer ${token}`
              }
          });
  
          setOrg(result.data);
      } catch (error) {
          console.error("Error fetching data:", error);
      }
  };
  


  return (

    <div className='container'>
        <Navbar/>

        <div className='py-4'>  {/*margin top*/}
        <table className="table border table-striped shadow">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">placement id</th>
      <th scope="col">profile</th>
      <th scope="col">description</th>
      <th scope="col">intake</th>
      <th scope="col">minimum grade</th>
      <th scope="col">Organisation name</th>
      <th scope="col">Organisation address</th>
      <th scope="col">Organisation id</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
        {org.map((organisation,index)=>(
            <tr key={organisation.organisation.organisationId}> 
                <th scope="row" key={index}>{index+1}</th>
                <td>{organisation.placementid}</td>
                <td>{organisation.profile}</td>
                <td>{organisation.description}</td>
                <td>{organisation.intake}</td>
                <td>{organisation.min_grade}</td>
                <td>{organisation.organisation.name}</td>
                <td>{organisation.organisation.address}</td>
                <td>{organisation.organisation.organisationId}</td>
                <td>
                  
                <Link
                    className="btn btn-primary mx-2"
                    to={`/viewdetail/${organisation.organisation.organisationId}`}
                  >
                    View
                  </Link>
                  
                  
                  {/* <botton className="btn btn-outline-primary mx-2">edit</botton>
                  <botton className="btn btn-outline-success mx-2">delete</botton> */}
                </td>
            </tr> 
            ))}


      
  </tbody>
</table>
        </div>
    </div>
  )
}
