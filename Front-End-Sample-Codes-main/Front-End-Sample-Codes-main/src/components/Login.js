import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router";
import AddPetForm from "./addPet/AddPetForm";

function Login() {
  const [userName, setUserName] = useState("");
  const [password, setPassword] = useState("");
  const [userData, setUserData] = useState(null);
  const navigate = useNavigate();

  function handleLogin(e) {
    e.preventDefault();

    fetch('http://localhost:8080/users/login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ userName, password }),
    })
      .then((response) => {
        if (response.ok) {
          return response.json();
        } else {
          throw new Error('Login failed');
        }
      })
      .then((userData) => {
        localStorage.setItem('userData', JSON.stringify(userData));
        setUserData(userData);

        navigate("/");
        window.location.reload();
      })
      .catch((error) => {
        console.error('Login failed:', error);
      });
  }

  return (
    <div className="container d-flex justify-content-center align-items-center vh-100">
      <div className="card p-4">
        <h2 className="text-center mb-4">Login</h2>
        <form onSubmit={handleLogin}>
          <div className="mb-3">
            <label htmlFor="email" className="form-label">Email</label>
            <input
              type="email"
              className="form-control"
              id="email"
              value={userName}
              onChange={(e) => setUserName(e.target.value)}
              required
            />
          </div>
          <div className="mb-3">
            <label htmlFor="password" className="form-label">Password</label>
            <input
              type="password"
              className="form-control"
              id="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit" className="btn btn-primary w-100">Login</button>
        </form>
      </div>
    </div>
  );
}

export default Login;
