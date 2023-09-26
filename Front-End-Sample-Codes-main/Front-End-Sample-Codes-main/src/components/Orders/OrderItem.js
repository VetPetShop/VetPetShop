import React from "react";

function OrderItem() {
    return (
        <div className="card" style={{ width: "auto" }}>
            <div className="row no-gutters">
                <div className="col-12 col-sm-5 col-lg-5">
                    <img className="card-img" src="../Images/dogs/dog11.jpg" style={{ height: "100%", width: "100%", padding: "2px" }} alt="" />
                </div>
                <div className="col-sm-7">
                    <div className="card-body">
                        <h5 className="card-title">Cat</h5>
                        <p className="card-text">Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis, aliquam. Eum reprehenderit aspernatur nostrum laudantium est?</p>
                        {/* <a href="#">Delete</a> | <a href="#">Share</a> */}
                        {/* <div className="btn-group m-2 btn-sm btn-group-toggle" data-toggle="buttons">
                            <label className="btn btn-sm btn-light">
                                <a href="#" className="qty">+</a>
                            </label>
                            <label className="btn btn-sm btn-secondary">
                                qty
                            </label>
                            <label className="btn btn-sm btn-light">
                                <a href="#" className="qty">-</a>
                            </label>
                        </div> */}
                    </div>
                </div>
            </div>
        </div>
    );
}

export default OrderItem;
