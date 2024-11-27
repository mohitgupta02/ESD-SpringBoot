import React from 'react'
import { Link } from 'react-router-dom'

export default function Navbar() {
  return (
    <div>

<nav className="navbar navbar-expand-lg navbar-dark bg-primary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">
        Admin Logged in
    </a>
    <button
     className="navbar-toggler" type="button"
     data-bs-toggle="collapse" 
     data-bs-target="#navbarSupportedContent" 
     aria-controls="navbarSupportedContent" 
     aria-expanded="false" 
     aria-label="Toggle navigation"
     >
      <span className="navbar-toggler-icon"></span>
    </button>

    <Link className="btn btn-danger my-2" to={"/"}>Logout</Link>
  </div>
</nav>

    </div>
  )
}
