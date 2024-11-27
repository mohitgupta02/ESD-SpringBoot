import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { Link } from 'react-router-dom';
// import Navbar from '../src/layout/Navbar';
import Navbar from '../layout/Navbar';


export default function Viewdemo() {
  const [appliedStudents, setAppliedStudents] = useState([]);
  const [selectedStudents, setSelectedStudents] = useState([]);
  const [filteredStudents, setFilteredStudents] = useState([]);
  const [filters, setFilters] = useState({
    cgpa: '',
    domain: '',
    specialisation: ''
  });
  const [domains, setDomains] = useState([]);
  const [specialisations, setSpecialisations] = useState([]);
  const [showFilters, setShowFilters] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const token=localStorage.getItem('jwt');

        const response = await axios.get('http://localhost:8081/students',{
          headers: {
            Authorization: 'Bearer ' + token
          }
         });
        setAppliedStudents(response.data);
        setFilteredStudents(response.data);

        // Extract unique domains and specialisations for dropdown options
        const uniqueDomains = [...new Set(response.data.map(student => student.domain.program))];
        const uniqueSpecialisations = [...new Set(response.data.map(student => student.specialisation.name))];

        setDomains(uniqueDomains);
        setSpecialisations(uniqueSpecialisations);
      } catch (error) {
        console.error('Error fetching data:', error);
      }
    };

    fetchData();
  }, []);

  const handleFilterChange = (filterType, value) => {
    setFilters({ ...filters, [filterType]: value });
  };

  const handleFilterButtonClick = () => {
    setShowFilters(!showFilters);
  };

  const handleSelectStudent = (studentId) => {
    // Find the selected student from the applied students list
    const selectedStudent = appliedStudents.find(student => student.studentId === studentId);

    // Remove the selected student from the applied students list
    const updatedAppliedStudents = appliedStudents.filter(student => student.studentId !== studentId);

    // Add the selected student to the selected students list
    setSelectedStudents([...selectedStudents, selectedStudent]);

    // Update the filtered students list
    const updatedFilteredStudents = filteredStudents.filter(student => student.studentId !== studentId);
    setFilteredStudents(updatedFilteredStudents);
  };

  useEffect(() => {
    // Apply filters
    const filtered = appliedStudents.filter(student => {
      const matchCgpa = !filters.cgpa || parseFloat(student.cgpa) >= parseFloat(filters.cgpa);
      const matchDomain = !filters.domain || student.domain.program === filters.domain;
      const matchSpecialisation = !filters.specialisation || student.specialisation.name === filters.specialisation;

      return matchCgpa && matchDomain && matchSpecialisation;
    });

    setFilteredStudents(filtered);
  }, [filters, appliedStudents]);

  return (
    <div>
            <Navbar/>

      <div style={{ display: 'flex', justifyContent: 'flex-end', marginBottom: '10px' }}>
        <button className="btn btn-outline-success mx-2" onClick={handleFilterButtonClick}>
          {showFilters ? 'Hide Filters' : 'Show Filters'}
        </button>
      </div>

      {showFilters && (
        <div style={{ background: '#f0f0f0', padding: '15px', borderRadius: '8px', marginBottom: '20px' }}>
          <div style={{ marginBottom: '10px' }}>
            <label style={{ marginRight: '10px' }}>CGPA:</label>
            <input
              type="text"
              value={filters.cgpa}
              onChange={(e) => handleFilterChange('cgpa', e.target.value)}
            />
          </div>
          <div style={{ marginBottom: '10px' }}>
            <label style={{ marginRight: '10px' }}>Domain:</label>
            <select
              value={filters.domain}
              onChange={(e) => handleFilterChange('domain', e.target.value)}
            >
              <option value="">All</option>
              {domains.map((domain) => (
                <option key={domain} value={domain}>
                  {domain}
                </option>
              ))}
            </select>
          </div>
          <div>
            <label style={{ marginRight: '10px' }}>Specialisation:</label>
            <select
              value={filters.specialisation}
              onChange={(e) => handleFilterChange('specialisation', e.target.value)}
            >
              <option value="">All</option>
              {specialisations.map((specialisation) => (
                <option key={specialisation} value={specialisation}>
                  {specialisation}
                </option>
              ))}
            </select>
          </div>
        </div>
      )}

      <div className="container">
        <div className="py-4">
          <h2>Applied Student List</h2>
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
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
              {filteredStudents.map((student, index) => (
                <tr key={student.studentId}>
                  <th scope="row" key={index}>
                    {index + 1}
                  </th>
                  <td>{student.studentId}</td>
                  <td>{student.firstname}</td>
                  <td>{student.lastname}</td>
                  <td>{student.cgpa}</td>
                  <td>{student.emailId}</td>
                  <td>{student.rollNumber}</td>
                  <td>{student.specialisation.name}</td>
                  <td>{student.domain.program}</td>
                  <td>
                    <button
                      className="btn btn-success"
                      onClick={() => handleSelectStudent(student.studentId)}
                    >
                      Select
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>

        <div className="py-4">
          <h2>Selected Student List</h2>
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
              </tr>
            </thead>
            <tbody>
              {selectedStudents.map((student, index) => (
                <tr key={student.studentId}>
                  <th scope="row" key={index}>
                    {index + 1}
                  </th>
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
    </div>
  );
};
