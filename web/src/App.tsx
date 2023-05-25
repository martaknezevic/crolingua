import { BrowserRouter, Routes, Route } from "react-router-dom"
import './App.css'
import Home from './Home/Home'
import Login from './Login/Login'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="*" element={<p>Hmmm..... can't find this page. 404.</p>} />
      </Routes>
    </BrowserRouter>
  )
}

export default App