import React from "react";
import { Link } from "react-router-dom";

function Third() {
    return (
        <div className="container-fluid">
            <div className="row row-cols-2 row-cols-lg-5 quotecards">

                <div className="col petdesc p-2">
                    <div>
                        <br />
                        <p>Animals are such agreeable friends; they ask no questions; they pass no criticisms</p>
                        <p>Having a pet in your life makes your life happier</p>
                    </div>
                </div>

                <div className="col shopnow">
                    <div>
                        <img src={process.env.PUBLIC_URL + '/Images/dogs/dog4.jpg'} className="img-fluid shopnowimage" alt="" />
                        <Link to="/pet/DOG">
                        <div className="shopnowbtn">
                            <button  className="btn">Shop Now</button>
                        </div>
                        </Link>
                    </div>
                </div>

                <div className="col shopnow">
                    <div>
                        <img src={process.env.PUBLIC_URL + '/Images/cats/persiancat3.jpg'} className="img-fluid shopnowimage" alt="" />
                        <Link to="/pet/CAT">
                        <div className="shopnowbtn">
                            <button  className="btn">Shop Now</button>
                        </div>
                        </Link>
                    </div>
                </div>

                <div className="col shopnow">
                    <div>
                        <img src={process.env.PUBLIC_URL + '/Images/Rabbits/americanrabbit.jpg'} className="img-fluid shopnowimage" alt="" />
                        <Link to="/pet/RABBIT">
                        <div className="shopnowbtn">

                            <button className="btn">Shop Now</button>
                        </div>
                        </Link>
                    </div>
                </div>

                <div className="col p-2 petdesc">
                    <br />
                    <div>
                        <p>Pets are humanizing. They remind us we have an obligation and responsibility to preserve and nurture and care for all life</p>
                        <p>Pets are one of the most beautiful gifts we have</p>
                    </div>
                </div>

            </div>
        </div>
    );
}

export default Third;
