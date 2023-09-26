import React, { useState} from "react";
import { useNavigate } from "react-router";
// import { useHistory } from "react-router-dom";
function SignUp() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [address, setAddress] = useState("");
    const [dob, setDob] = useState("");
    const [phoneNumber, setPhoneNumber] = useState("");
    const [gender, setGender] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [passwordError, setPasswordError] = useState("");
    const navigate = useNavigate();
    // const [signUpSuccess,setSignUpSuccess]=useState(false)
    // const history = useHistory();

    const handleSignUp = async (e) => {
        e.preventDefault();
    
        // Add validation and error handling as needed
        if (password !== confirmPassword) {
          setPasswordError("Passwords do not match");
          return;
        }
    
        // Create the user object to send to the API
        const user = {
          email,
          password,
          firstName,
          lastName,
          address,
          dob,
          phoneNumber,
          gender,
        };
    
        try {
          const response = await fetch("http://localhost:8080/users/newuser", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
            },
            body: JSON.stringify(user),
          });
    
          if (response.ok) {
            console.log("Signup successful");
            alert("Signup successful");
                
                navigate("/Login")
            
            
          } else {
            console.error("Signup error");
          }
          
        }
         catch (error) {
          console.error("Network error", error);
          
        }
        
      };

    return (
        <div className="d-flex container justify-content-center">
            <div className="card p-4">
                <h2 className="text-center mb-4">Sign Up</h2>
                <form onSubmit={handleSignUp}>
                    <div className="mb-3">
                        <label htmlFor="firstName" className="form-label">First Name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="firstName"
                            value={firstName}
                            onChange={(e) => setFirstName(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="lastName" className="form-label">Last Name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="lastName"
                            value={lastName}
                            onChange={(e) => setLastName(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="email" className="form-label">Email</label>
                        <input
                            type="email"
                            className="form-control"
                            id="email"
                            value={email}
                            onChange={(e) => setEmail(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="phoneNumber" className="form-label">Phone Number</label>
                        <input
                            type="tel"
                            className="form-control"
                            id="phoneNumber"
                            value={phoneNumber}
                            onChange={(e) => setPhoneNumber(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="address" className="form-label">Address (Optional)</label>
                        <input
                            type="text"
                            className="form-control"
                            id="address"
                            value={address}
                            onChange={(e) => setAddress(e.target.value)}
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="gender" className="form-label">Gender</label>
                        <input
                            type="text"
                            className="form-control"
                            id="gender"
                            value={gender}
                            onChange={(e) => setGender(e.target.value)}
                            required
                        />
                    </div>
                    <div className="mb-3">
                        <label htmlFor="dob" className="form-label">Date of Birth</label>
                        <input
                            type="date"
                            className="form-control"
                            id="dob"
                            value={dob}
                            onChange={(e) => setDob(e.target.value)}
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
                    <div className="mb-3">
                        <label htmlFor="confirmPassword" className="form-label">Confirm Password</label>
                        <input
                            type="password"
                            className="form-control"
                            id="confirmPassword"
                            value={confirmPassword}
                            onChange={(e) => setConfirmPassword(e.target.value)}
                            required
                        />
                        {passwordError && <p className="text-danger">{passwordError}</p>}
                    </div>
                    <button type="submit" className="btn btn-primary w-100">Sign Up</button>
                </form>
            </div>
        </div>
    );
}

export default SignUp;
