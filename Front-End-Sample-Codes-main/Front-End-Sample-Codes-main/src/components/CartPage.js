import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import CartItem from "./cart/CartItem";

function CartPage() {
    const [cartData, setCartData] = useState([]);
    const [totalPrice, setTotalPrice] = useState(0);


    useEffect(() => {
      // Retrieve userId from userData in localStorage
      const userData = JSON.parse(localStorage.getItem('userData'));
      const userId = userData.userId; // Assuming the structure is userData.userId
  
      // Fetch cart data for the user
      fetch(`http://localhost:8080/cart/${userId}`)
        .then(response => response.json())
        .then(data => {
          setCartData(data);
        //   // Calculate the total price when cartData is updated
        // const calculatedTotalPrice = data.reduce((total, item) => {
        //   // Parse item price as a float (assuming it's a string)
        //   const itemPrice = parseFloat(item.itemData.price);
          
        //   // Check if itemPrice is a valid number before adding
        //   if (!isNaN(itemPrice)) {
        //     return total + itemPrice;
        //   }
        //   return total;
        // },0);
        // setTotalPrice(calculatedTotalPrice);
        
        })
        .catch(error => {
          console.error('Error fetching cart data:', error);
        });
    }, []);
    
    
    return (
        <div>
            <h1 className="container">CART</h1>
            <hr />
            <div className="container-fluid">
                <div className="row">
                    

                    <div className="col-8 px-5">
                    {cartData.map(item => (
              <CartItem
                
                itemId={item.itemId}
      
              />
                ))}


                    </div>



                    <div className="col-lg-4">
                        



                        <div className="container text-center py-3 bg-light">
                            {/* <!-- For 2 selected items --> */}
                            <h4>Items selected</h4>
                            <h6>TOTAL PRICE : {totalPrice}</h6>
                            <Link to="/Buy" className="btn px-4 bg-warning">Proceed to buy</Link>
                        </div>



                    </div>
                </div>
            </div>
            <br />

            
        </div>
    );
}

export default CartPage;
