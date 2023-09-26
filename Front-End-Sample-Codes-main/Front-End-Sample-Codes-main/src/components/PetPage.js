import React from "react";
import {Link} from "react-router-dom";
import {useState} from "react";
import "./petspage.css";
// import { response } from "express";

function PetPage() {
    const [slideIndex, setSlideIndex] = useState(1);
    // const [petData,setPetData]=useState(null);


    const currentSlide = (n) => {
        showSlides(n);
    };

    const showSlides = (n) => {
        let i;
        const slides = document.getElementsByClassName("mySlides");
        const dots = document.getElementsByClassName("demo");
        
        if (n > slides.length) {
            n = 1;
        }
        if (n < 1) {
            n = slides.length;
        }
        
        for (i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }
        
        for (i = 0; i < dots.length; i++) {
            dots[i].className = dots[i].className.replace(" active", "");
        }
        
        slides[n - 1].style.display = "block";
        dots[n - 1].className += " active";
        
        setSlideIndex(n);
    }

        // useEffect(()=>{
          
        //     fetch("http://localhost:/getPet")
        //     .then(response=>response.json())
        //     .then(data=>setPetData(data))
        //     .catch(error => console.error("error fetchnf pet data :",error));

        //     if(!petData){
        //         return <div>Loading.....</div>
        //     }

        // })
 





    return (
        <div>
            <h2 style={{ textAlign: "center", margin: "30px 10px" }}>Pet page</h2>

            <div className="container-fluid">
                <div className="row">
                    <div className="col-1">
                        <div className="row">
                            <img className="demo cursor" src="../Images/dogs/dog2.jpg" onClick={() => currentSlide(1)} alt="The Woods" />
                        </div>
                        <div className="row">
                            <img className="demo cursor" src="../Images/dogs/dog8.jpg" onClick={() => currentSlide(2)} alt="Cinque Terre" />
                        </div>
                        <div className="row">
                            <img className="demo cursor" src="../Images/dogs/dog2.jpg" onClick={() => currentSlide(3)} alt="Mountains and fjords" />
                        </div>
                        <div className="row">
                            <img className="demo cursor" src="../Images/dogs/dog8.jpg" onClick={() => currentSlide(4)} alt="Northern Lights" />
                        </div>
                    </div><br />
                    <div className="col-5">
                        <div className="mySlides">
                            <img src="../Images/dogs/dog2.jpg" alt="Dog Slide 1"className="image" />
                        </div>

                        <div className="mySlides">
                            <img src="../Images/dogs/dog8.jpg" alt="Dog Slide 2" className="image"/>
                        </div>

                        <div className="mySlides">
                            <img src="../Images/dogs/dog2.jpg" alt="Dog Slide 3" className="image"/>
                        </div>

                        <div className="mySlides">
                            <img src="../Images/dogs/dog8.jpg" alt="Dog Slide 4"className="image" />
                        </div>
                    </div>
                    <div className="col-6">
                        <h2>Nikon Z6 II Mirrorless Camera Z 24-70mm Lens with Additional Battery, Optical Zoom, Black</h2>
                        <div className="star-rating">
                            <label htmlFor="Rating">Ratings</label><br />
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star checked"></span>
                            <span className="fa fa-star"></span>
                            <Link to=""style={{ float: "right", marginRight: "40px" }} >Write a review</Link>
                        </div>
                        <hr />
                        <span>M.R.P.:</span><span className="px-5 fa fa-inr"> 1,76,000</span><br />
                        <span className="text-danger">-20%</span><s className="px-3 fa fa-inr"> 1,76,000 </s> <span className="display-6 px-5 fa fa-inr"> 1,40,800</span>
                        <h5>Inclusive of taxes</h5>
                        <h4 className="text-danger mb-0">Offers :</h4>
                        <h5>EMI starts at ₹8,498. No Cost EMI available <Link to="">EMI options</Link></h5>
                        <hr />
                        <div className="dtls">
                            <label htmlFor="breed"><b>Breed</b></label>
                            <label className="primedetails" htmlFor="">German Shepherd</label>
                            <br />
                            <label htmlFor="Gender"><b>Gender</b></label>
                            <label className="primedetails" htmlFor="">Male</label>
                            <br />
                            <label htmlFor="Colour"><b>Colour</b></label>
                            <label className="primedetails" htmlFor="">Black-Brown</label>
                            <br />
                            <label htmlFor="Age"><b>Age</b></label><label className="primedetails" htmlFor="">9 Months</label>
                        </div>
                        <hr />
                        <div className="description">
                            Lorem, ipsum dolor sit amet consectetur adipisicing elit. <br />Rerum vel esse eum! Voluptates quos ipsam consequuntur recusandae, <br />cum aliquid iure incidunt iusto nam consequatur, magnam pariatur expedita, eius fugit omnis! <br />
                            Lorem ipsum dolor sit amet consectetur adipisicing elit. Sint, itaque? Nihil totam, ratione quae quaerat pariatur, ea iste amet ducimus ut autem, omnis sint? <br /> Facere deserunt incidunt sint quam corrupti!
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default PetPage;
