import React from "react";
import { Link } from "react-router-dom";

function Footer() {
  return (
    <div className="container-fluid p-0 bg-light">
      <footer className="py-5">
        <div className="row">
          <div className="col-6 col-md-2 mb-3">
            <h5>VetPetShop</h5>
            <ul className="nav flex-column">
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-1 text-muted">Who we are</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-1 text-muted">Terms & Conditions</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-1 text-muted">Features</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-1 text-muted">We respect your Privacy</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-1 text-muted">Returns & Refunds Policy</Link>
              </li>
            </ul>
          </div>

          <div className="col-6 col-md-2 mb-3">
            <h5>Payments & Orders</h5>
            <ul className="nav flex-column">
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Track your Orders</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Shipping details</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Cancellations</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Returns</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">FAQs</Link>
              </li>
            </ul>
          </div>

          <div className="col-6 col-md-2 mb-3">
            <h5>Help & Service</h5>
            <ul className="nav flex-column">
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Home</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">Contact Us</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">About Us</Link>
              </li>
              <li className="nav-item mb-2">
                <Link to="" className="nav-link p-0 text-muted">FAQs</Link>
              </li>
            </ul>
          </div>

          <div className="col-md-4 offset-md-1 mb-3">
            <form>
              <h5>Subscribe to our newsletter</h5>
              <p>Monthly digest of what's new and exciting from us.</p>
              <div className="d-flex flex-column flex-sm-row w-100 gap-2">
                <label htmlFor="newsletter1" className="visually-hidden">Email address</label>
                <input
                  id="newsletter1"
                  type="text"
                  className="form-control"
                  placeholder="Email address"
                />
                <button className="btn btn-primary" type="button">Subscribe</button>
              </div>
            </form>
          </div>
        </div>
        <hr className="m-0" />
        <p className="text-secondary" style={{ float: "right" }}>© 2023 www.VetPetShop.com, Inc. All rights reserved</p>
      </footer>
    </div>
  );
}

export default Footer;
