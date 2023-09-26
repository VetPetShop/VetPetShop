package com.app.VetPetShop.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.app.VetPetShop.DTO.ApiResponse;

public interface ImageHandlingService {

	ApiResponse uploadImage(Long petId, MultipartFile imageFile) throws IOException;

	byte[] serveImage(Long petId) throws IOException;
	
}
