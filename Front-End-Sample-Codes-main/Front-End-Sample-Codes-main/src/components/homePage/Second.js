import React from "react";

function Second() {
    return (
        <div id="petscarousel" className="carousel slide" data-bs-ride="carousel">
            <div className="carousel-inner">
                <div className="carousel-item active" data-bs-interval="4000">
                    <img src={process.env.PUBLIC_URL + '/Images/dogs/dogcard.jpg'} alt="..." />
                </div>
                <div className="carousel-item" data-bs-interval="2000">
                    <img src={process.env.PUBLIC_URL + '/Images/cats/catcard2.jpg'} alt="..." />
                </div>
                <div className="carousel-item" data-bs-interval="2000">
                    <img src={process.env.PUBLIC_URL + '/Images/Birds/birdsgroup1.jpg'} alt="..." />
                </div>
            </div>
            <button className="carousel-control-prev" type="button" data-bs-target="#petscarousel" data-bs-slide="prev">
                <span className="carousel-control-prev-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Previous</span>
            </button>
            <button className="carousel-control-next" type="button" data-bs-target="#petscarousel" data-bs-slide="next">
                <span className="carousel-control-next-icon" aria-hidden="true"></span>
                <span className="visually-hidden">Next</span>
            </button>
        </div>
    );
}

export default Second;
