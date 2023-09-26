package com.app.VetPetShop.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.VetPetShop.Service.ImageHandlingService;
import com.app.VetPetShop.Service.PetService;

@RestController
@RequestMapping("/images")
public class ImageHandlingController {

	@Autowired
	ImageHandlingService imageHandlingService;

	@Autowired
	PetService petService;

	@PostMapping(value = "/upload-image/{petId}", consumes = "multipart/form-data")
	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
			@PathVariable Long petId) throws IOException {
		System.out.println("in upload img " + petId + " " + imageFile.getOriginalFilename());
		return new ResponseEntity<>(imageHandlingService.uploadImage(petId, imageFile), HttpStatus.CREATED);
	}

	@GetMapping(value = "/get-image/{petId}", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long petId) throws IOException {
		System.out.println("in serve img " + petId);
		return new ResponseEntity<>(imageHandlingService.serveImage(petId), HttpStatus.OK);
	}

}
