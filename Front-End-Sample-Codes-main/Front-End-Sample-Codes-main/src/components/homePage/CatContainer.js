import React from "react";
import {Link} from "react-router-dom"

function CatContainer(){
    return(
        <div class="container-fluid catcontainer">
          <div class="row">

            
            <div class="column">
              <video width="100%" height="420px" muted autoplay controls>
                <source src="../Images/catvideo.mp4" type="video/mp4"/>
              </video>
            </div>


            <div class="column">
              <br/>
              <h1>Pet Cats</h1>
              <p>Cats are friendly and playful in nature; cats are connoisseurs of comfort. A kitten is the delight of a household. All day long a comedy is played out by an incomparable actor</p>
              <p>Interacting and playing with cat helps your mind relax making you forget about your worries.</p>
              <Link to="/pet/CAT"> --- &nbsp;&nbsp;&nbsp;Get a pet cat</Link>
          </div>

            <div class="column">
                <img src="../Images/cats/somalicat1.jpg" class="img-fluid" alt=""/>
            </div>

          </div>
        </div>
    )
}export default CatContainer;