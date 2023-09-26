import React, { useEffect, useState } from "react";
import OrderItem from "./Orders/OrderItem";

function OrderPage() {
  
    const [orders, setOrders] = useState([]); // State to store fetched orders

    useEffect(() => {
        // Fetch userId from local storage
        const userData = JSON.parse(localStorage.getItem("userData"));
        if (userData && userData.userId) {
            console.log("User ID:", userData.userId);
            // Fetch orders for the user
            fetch(`http://localhost:8080/orders/${userData.userId}`)
                .then(response => response.json())
                .then(data => {
                    setOrders(data); // Update the orders state with fetched data
                })
                .catch(error => {
                    console.error("Error fetching orders:", error);
                });
        } else {
            console.log("User ID not found in local storage");
        }
    }, []);
    return (
        <div className="container-fluid m-0">
            <br />
            <h1 className="container">Orders Page</h1>
            <hr />
            <div className="row p-4">
                
                <div className="col-lg-7 col-sm-4">
                    <ul className="nav nav-tabs" role="tablist">
                        <li className="nav-item">
                            <a className="nav-link active" data-bs-toggle="tab" href="#orders">All Orders</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" data-bs-toggle="tab" href="#dispatch">Not Yet Dispatched</a>
                        </li>
                        <li className="nav-item">
                            <a className="nav-link" data-bs-toggle="tab" href="#cancel">Cancelled</a>
                        </li>
                    </ul>

                    {/* <!-- Tab panes --> */}
                    <div className="tab-content">
                        <div id="orders" className="container tab-pane active"><br />
                            {
                            orders.map((order)=>{
                                <OrderItem key={order.id} order={order} />
                            })
                                

                            }
                        </div>
                        <div id="dispatch" className="container tab-pane fade"><br />
                            <br />
                            <p>Orders that are in-process and have to be dispatched and delivered soon</p>
                        </div>
                        <div id="cancel" className="container tab-pane fade"><br />
                            {/* <br> <!-- If cancelled orders = 0 --> */}
                            <p>No cancelled orders</p>
                            {/* <!-- Or else display order card as above --> */}
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default OrderPage;
