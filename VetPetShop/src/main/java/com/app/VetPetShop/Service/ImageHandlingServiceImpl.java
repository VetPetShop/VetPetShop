package com.app.VetPetShop.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.app.VetPetShop.CustomExceptions.ResourceNotFoundException;
import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.Pojos.Pets;
import com.app.VetPetShop.Repositories.PetRepository;

@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {

	@Value("${content.upload.folder}")
	private String folderName;

	@Autowired
	PetRepository petRepo;

	@Autowired
	UriComponents uriComponents;

	@PostConstruct
	public void myInit() {
		System.out.println("in myInit " + folderName);
		File path = new File(folderName);
		if (!path.exists()) {
			System.out.println("creating images folder...");
			path.mkdirs();
		} else
			System.out.println("folder alrdy exists....");
	}

	@Override
	public ApiResponse uploadImage(Long petId, MultipartFile imageFile) throws IOException {
		Pets product = petRepo.findById(petId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid pet Id : Image Uploading failed!!!!!!!!"));
		String targetPath = folderName + File.separator + imageFile.getOriginalFilename();
		System.out.println(targetPath);
		Files.copy(imageFile.getInputStream(), Paths.get(targetPath), StandardCopyOption.REPLACE_EXISTING);

		String uriString = ServletUriComponentsBuilder.fromCurrentContextPath().path(folderName)
				.path(imageFile.getOriginalFilename()).toUriString();

		String uri = uriComponents.toUriString();

		System.out.println("img url " + uriString);
//		 save image path in DB
		product.setPetImages(targetPath);
		return new ApiResponse("Image Uploaded successfully!");
	}

	@Override
	public byte[] serveImage(Long petId) throws IOException {
		Pets pet = petRepo.findById(petId)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Pet :Image cannot be downloaded"));
		String path = pet.getPetImages();
		if (path == null)
			throw new ResourceNotFoundException("Image does not exist");

		return Files.readAllBytes(Paths.get(path));
	}

}
