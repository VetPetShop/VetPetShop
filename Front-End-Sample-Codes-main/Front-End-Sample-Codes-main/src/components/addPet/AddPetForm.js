import React, { useEffect, useState } from 'react';
import "./addPetForm.css"

function AddPetForm() {
  
  const [description, setDescription] = useState('');
  const [petAge, setPetAge] = useState(0);
  const [gender, setGender] = useState('M');
  const [height, setHeight] = useState(0);
  const [weight, setWeight] = useState(0);
  const [breedName, setBreedName] = useState('');
  // const [sellerFirstName, setSellerFirstName] = useState('');
  // const [sellerLastName, setSellerLastName] = useState('');
  const [petColor, setPetColor] = useState('');
  const [medicalDetails, setMedicalDetails] = useState('');
  const [price, setPrice] = useState(0);
  const [email, setEmail] = useState('');

  // useEffect(() => {
   
  //   setUserEmail(props.emaill);
  // }, []);
  

  const handleSubmit = async (event) => {
    event.preventDefault();

    const petData = {
      description,
      petAge,
      gender,
      height,
      weight,
      breedName,
      email,
      petColor,
      medicalDetails,
      price
    };
    console.log(petData);
    try {
      const response = await fetch('http://localhost:8080/pets/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(petData)
      });

      if (response.ok) {
        console.log('Pet data submitted successfully');
      } else {
        console.error('Error submitting pet data');
      }
    } catch (error) {
      console.error('An error occurred:', error);
    }
  };

  return (
    <div className="containerAddPet">
      <h1>Add Pet Details</h1>

      <form id="addPetForm" onSubmit={handleSubmit}>
        <label htmlFor="description">Description:</label>
        <textarea
          id="description"
          name="description"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
          required
        />
        
        <label htmlFor="petAge">Pet Age:</label>
        <input
          type="number"
          id="petAge"
          name="petAge"
          value={petAge}
          onChange={(e) => setPetAge(parseInt(e.target.value, 10))}
          required
        />
        
        <label htmlFor="gender">Gender:</label>
        <select
          id="gender"
          name="gender"
          value={gender}
          onChange={(e) => setGender(e.target.value)}
        >
          <option value="M">Male</option>
          <option value="F">Female</option>
          
        </select>
        
        <label htmlFor="height">Height:</label>
        <input
          type="number"
          id="height"
          name="height"
          value={height}
          onChange={(e) => setHeight(parseInt(e.target.value, 10))}
          required
        />
        
        <label htmlFor="weight">Weight:</label>
        <input
          type="number"
          id="weight"
          name="weight"
          value={weight}
          onChange={(e) => setWeight(parseInt(e.target.value, 10))}
          required
        />
        
        <label htmlFor="breed">Breed Name:</label>
        <input
          type="text"
          id="breed"
          name="breed"
          value={breedName}
          onChange={(e) => setBreedName(e.target.value)}
          required
        />
        
        {/* <label htmlFor="sellerFirstName">Seller First Name:</label>
        <input
          type="text"
          id="sellerFirstName"
          name="sellerFirstName"
          value={sellerFirstName}
          onChange={(e) => setSellerFirstName(e.target.value)}
          required
        />
        
        <label htmlFor="sellerLastName">Seller Last Name:</label>
        <input
          type="text"
          id="sellerLastName"
          name="sellerLastName"
          value={sellerLastName}
          onChange={(e) => setSellerLastName(e.target.value)}
          required
        /> */}
        
        <label htmlFor="petColor">Pet Color:</label>
        <input
          type="text"
          id="petColor"
          name="petColor"
          value={petColor}
          onChange={(e) => setPetColor(e.target.value)}
          required
        />
        
        <label htmlFor="medicalDetails">Medical Details:</label>
        <textarea
          id="medicalDetails"
          name="medicalDetails"
          value={medicalDetails}
          onChange={(e) => setMedicalDetails(e.target.value)}
          required
        />
        
        <label htmlFor="price">Price:</label>
        <input
          type="number"
          id="price"
          name="price"
          value={price}
          onChange={(e) => setPrice(parseInt(e.target.value, 10))}
          required
        />
         <label htmlFor="email">Email Id:</label>
        <input
          type="text"
          id="email"
          name="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        
        <button type="submit" id="submitButton">Add Pet</button>
      </form>
    </div>
  );
}

export default AddPetForm;
