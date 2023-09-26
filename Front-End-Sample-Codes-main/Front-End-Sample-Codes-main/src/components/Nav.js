import React from 'react';
import { Link } from 'react-router-dom';

function Nav() {
    const user = JSON.parse(localStorage.getItem('userData'));
    const isLoggedIn = !!localStorage.getItem("userData");
    const handleSubmit=(e)=>{
        e.preventDefault();
    }
    return (
        <nav className="navbar navbar-expand-lg">
            <div className="container-fluid">
                {/* logo */}
                <Link to="/">
                    <img src={process.env.PUBLIC_URL + '/Images/VetPetShop_logo.png'} className="logo img-fluid" alt="Responsive" />
                    </Link>
                {/* Rest of the navigation */}
                <form className="searchbox d-lg-flex me-auto" role="search" onSubmit={handleSubmit}>
                    <input className="form-control" type="search" placeholder="Search pets" aria-label="Search" />
                    <button className="btn btn-outline-success" type="submit">Search</button>
                </form>
                <div className="collapse navbar-collapse justify-content-end" id="navbarSupportedContent">
                    <ul className="navbar-nav mb-2 mb-lg-0">
                        {/* <li className="nav-item">
                            <Link className="nav-link headernav" to="/ConsultDoctor">Consult Doctor</Link>
                        </li> */}
                        {isLoggedIn ? (
                            <>
                            <li className="nav-item">
                            <Link className="nav-link headernav" to="/SellPet">Sell Pet</Link>
                        </li>
                            <li className="nav-item">
                            <Link className="nav-link headernav" to="/Orders">Orders</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link headernav" to="/Cart">
                                Cart
                                <img src={process.env.PUBLIC_URL + '/Images/cart.png'} className="cartimg" alt="Cart" />
                            </Link>
                        </li>
                        <li className="nav-item">
                            <Link type='button' className="nav-link headernav" to="/Logout">Log out</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link headernav" to="">Hello {user.firstName}</Link>
                        </li>
                        </>
                        ):(
                            <>
                            <li className="nav-item">
                            <Link className="nav-link headernav" to="/Login">Login</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link headernav" to="/SignUp">Sign-Up</Link>
                        </li>
                        </>
                        )
                        
                        }
                        
                        
                    </ul>
                </div>
            </div>
        </nav>
    );
}
export default Nav;
