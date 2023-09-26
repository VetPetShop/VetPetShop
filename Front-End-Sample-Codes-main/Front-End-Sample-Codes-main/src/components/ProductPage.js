import React, { useEffect, useState } from "react";
import ProductItem from "./product/ProductItem";
import {useParams} from "react-router-dom"

function ProductPage(){
  const {categoryName} = useParams();
  const [products,setProducts]=useState([]);
  const [images, setImages] = useState({});
  useEffect(()=>{

    fetch(`http://localhost:8080/pets/category/${categoryName}`)
      .then(response => response.json())
      .then(data => {
       
        setProducts(data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });

  },[categoryName])
  useEffect(() => {
    
    products.forEach(product => {
      fetch(`http://localhost:8080/images/get-image/${product.petId}`)
        .then(response => response.blob()) 
        .then(imageBlob => {
          setImages(prevImages => ({
            ...prevImages,
            [product.petId]: URL.createObjectURL(imageBlob),
          }));
        })
        .catch(error => {
          console.error('Error fetching image:', error);
        });
    });
  }, [products]);
    return(
        <div>
            <header class="bg-light text-center py-4">
    <h1 class="display-4">{categoryName}</h1>
    <p class="lead">Find your perfect furry friend!</p>  
  </header>

  <section class="container py-5">
    <div class="row">
      
    {products.map(product => (
          <ProductItem
          petId={product.petId}
          name={product.breedName}
          image={images[product.petId]}
          gender={product.gender}
          age={product.petAge}
          info ={product.medicalDetails}
          price={product.price}
          />
        ))}
      
    </div>
  </section>
        </div>
    );
}export default ProductPage;