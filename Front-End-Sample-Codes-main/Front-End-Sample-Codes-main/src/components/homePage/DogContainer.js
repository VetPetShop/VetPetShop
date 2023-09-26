import React from "react";
import {Link} from "react-router-dom"

function DogContainer() {
    return (
        <div className="container-fluid dogcontainer">
            <div className="row">
                <div className="column">
                    <img src="../Images/dogs/dog2.jpg" className="img-fluid h-80 w-100" alt="" />
                </div>


                <div className="column h-80 w-40">
                    <br />
                    <h1>Pet Dogs</h1>
                    <p>
                        Dogs make for the best friends, and it's only right that we celebrate them for all the joy and love they've given us.
                    </p>
                    <p>
                        Interacting and playing with dogs helps your mind relax making you forget about your worries.
                    </p>
                    <Link to="/pet/DOG"> --- &nbsp;&nbsp;&nbsp;Get a pet dog</Link>
                </div>


                <div className="column">
                    <video width="100%" height="400px" muted autoPlay controls>
                        <source src="../Images/dogvideo.mp4" type="video/mp4" />
                    </video>
                </div>
            </div>
        </div>
    );
}

export default DogContainer;
