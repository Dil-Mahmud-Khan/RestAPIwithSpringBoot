package com.api.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.helper.FileUploadHelper;

@RestController
public class FileUploadController {
	
	@Autowired
	private FileUploadHelper fileUploadHelper;
	

	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
//		System.out.println(file.getName());
//		System.out.println(file.getContentType());
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		
		try {
		
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request problem");
		}
		
		if(file.getContentType().equals("JPG")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Image format probelm");
		}
		
		
		//fileUpload
		
		boolean f=fileUploadHelper.uploadFile(file);
		if(f) {
			//return ResponseEntity.ok("File Uploaded");
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
			
		}
				
	}
	catch(Exception exception) {
		exception.printStackTrace();
	}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error in file Uploading");
		
		
	}
}
