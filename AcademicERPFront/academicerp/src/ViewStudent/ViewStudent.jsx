import React, { useEffect, useState } from 'react'
import axios from 'axios';
import Navbar from '../layout/Navbar';


export default function ViewStudent() {

const StudentList = () => {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8081/students');
        setStudents(response.data);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []); // Empty dependency array means this effect will run once when the component mounts

  return (
    <div className='container'>
            <Navbar/>

        <div className='py-4'>  {/*margin top*/}
        <table className="table border table-striped shadow">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">student id</th>
      <th scope="col">first name</th>
      <th scope="col">last name</th>
      <th scope="col">cgpa</th>
      <th scope="col">email</th>
      <th scope="col">roll number</th>
      <th scope="col">specialisation</th>
      <th scope="col">domain</th>
      <th scope="col">Action</th>
    </tr>
  </thead>
        <tbody>
          {students.map((student,index) => (
            <tr key={student.studentId}>
                <th scope="row" key={index}>{index+1}</th>
              <td>{student.studentId}</td>
              <td>{student.firstname}</td>
              <td>{student.lastname}</td>
              <td>{student.cgpa}</td>
              <td>{student.emailId}</td>
              <td>{student.rollNumber}</td>
              <td>{student.specialisation.name}</td>
              <td>{student.domain.program}</td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
    </div>
  );
};
return <StudentList />;
}
// export default StudentList;
