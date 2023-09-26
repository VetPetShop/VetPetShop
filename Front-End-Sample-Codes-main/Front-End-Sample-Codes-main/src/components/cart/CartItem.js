import React from "react";
import { useEffect, useState } from "react";

function CartItem(props) {
    const [itemData, setItemData] = useState({});
    const userData = JSON.parse(localStorage.getItem("userData"));
    const userId = userData.userId;
    const itemId = props.itemId


    useEffect(() => {
        // Fetch data for the specific item using the itemId
        fetch(`http://localhost:8080/cart/item/${itemId}`)
          .then(response => response.json())
          .then(data => {
            setItemData(data);
          })
          .catch(error => {
            console.error('Error fetching item data:', error);
          });
      }, [itemId]);

      // Function to delete the item from the cart
  function deleteItem() {
    console.log(userId);
    console.log(itemId);
    
    fetch(`http://localhost:8080/cart/${userId}/item/delete/${itemId}`, {
      method: "DELETE",
    })
      .then((response) => response.json())
      .then((data) => {
        // Handle the response, e.g., update the UI or show a success message
        console.log("Item deleted from cart:", data);
        alert("DELETED FROM CART")

        // You may want to trigger a refresh of the cart after deletion.
      })
      .catch((error) => {
        console.error("Error deleting item from cart:", error);
      });
  }
    return (
        <div className="form-check my-3">
            {/* <input className="form-check-input" type="checkbox" value="" id="flexCheckDefault" /> */}
            <div className="card" style={{ width: "auto" }}>
                <div className="row no-gutters">
                    <div className="col-12 col-sm-5 col-lg-5">
                        <img className="card-img" src="../Images/dogs/dog11.jpg" style={{ height: "100%", width: "100%", padding: "2px" }} alt="" />
                    </div>
                    <div className="col-sm-7">
                        <div className="card-body">
                        <h5 className="card-title">{itemId}</h5>
                        <h5 className="card-title">{itemData.breedName}</h5>
                        <h5 className="card-title">Gender :{itemData.gender}</h5>
                        <h5 className="card-title">Colour : {itemData.petColour}</h5>
                        <h5 className="card-title">Price : {itemData.price}</h5>
                        <h5 className="card-title">Description : {itemData.description}</h5>

                            
                            <button onClick={deleteItem}>Delete</button>
                            
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default CartItem;
