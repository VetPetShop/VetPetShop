import React from "react";
import Second from "./homePage/Second"
import Third from "./homePage/Third";
import Fourth from "./homePage/Fourth";
import DogContainer from "./homePage/DogContainer";
import CatContainer from "./homePage/CatContainer";
import ShopByCategory from "./homePage/ShopByCategory"
function HomePage(){
    return(
    <div>
    <Second/>
    <Third/>
    <Fourth/>
    <DogContainer/>
    <CatContainer/>
    <ShopByCategory/>
    </div>
    )
    
}export default HomePage;