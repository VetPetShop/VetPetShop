import React from "react";
import { Link } from "react-router-dom";

function ProductItem(props) {
  function addToCart() {
    const userData = JSON.parse(localStorage.getItem('userData'));
    const userId = userData.userId;

    const petId = props.petId;
    
    const url = `http://localhost:8080/cart/${userId}/item/add/${petId}`;

    fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json', 
      },
      body: JSON.stringify({
        // You can add additional data in the body if needed
      }),
    })
      .then(response => response.json())
      .then(data => {
        console.log(data);
        alert("ADDED INTO CART") // Handle the response from the backend if needed
      })
      .catch(error => {
        console.error('Error adding item to cart:', error);
      });
  }
    
    
    
    
    
    
  
  
  return (
    <div className="col-lg-4 col-md-6 mb-4">
      <div className="card">
        <Link to="/PetPage">
          <img src={props.image} className="card-img-top" alt="Golden Retriever" />
          <div className="card-body">
            <h5 className="card-title">{props.name}</h5>
            <p className="card-text">Gender: {props.gender}</p>
            <p className="card-text">Age: {props.age}</p>
            <p className="card-text">INFO : {props.info}</p>
            <p className="card-text">Price: {props.price}</p>
          </div>
        </Link>
        <div>
          <button type="button" className="btn btn-primary btn-block" onClick={addToCart}>Add to Cart</button>
        </div>
      </div>
    </div>
  );
}

export default ProductItem;
