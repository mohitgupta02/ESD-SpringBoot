import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css"
import Homepage from './pages/Homepage';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ViewOrg from './organisation/ViewOrg';
import Login from './pages/Login';
import { useState } from 'react';
import ViewStudent from './ViewStudent/ViewStudent';
import Viewdemo from './ViewStudent/Viewdemo';

function App() {
  const [isAuth,setAuth] = useState(false);
  return (
    <div className="App">
      <Router>
        

        <Routes>
            {/* <Route exact path="/" element={<Login setAuth={setAuth}/>}/> */}
            <Route exact path="/" element={<Login/>}/>
             {/* {isAuth && <Route exact path="/home" element={<Homepage/>}/>} */}
            <Route exact path="/home" element={<Homepage/>}/>
            {/* {isAuth &&<Route exact path="/viewdetail/:organisationId" element={<ViewOrg/>}/>} */}
            <Route exact path="/viewdetail/:organisationId" element={<ViewOrg/>}/>
            {/* {isAuth && <Route exact path="/viewstudent" element={<ViewStudent/>}/>} */}
            <Route exact path="/viewstudent" element={<ViewStudent/>}/>
            <Route exact path="/viewdemo" element={<Viewdemo/>}/>
            <Route path="*" element={<Login setAuth={setAuth}/>}/>
        </Routes>

      </Router>
     
    </div>
  );
}

export default App;
