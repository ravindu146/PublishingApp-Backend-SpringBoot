package com.example.demo.UserController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;

@RestController
@CrossOrigin
@RequestMapping("api/v1/posts")
public class ImageUploadController {

    private final String uploadDir = "uploads/";

    @PostMapping("/upload-image")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile imageFile) {
        try {
            // Validate and process the image file, save it to the "uploads" folder
            if (!imageFile.isEmpty()) {
                String originalFilename = imageFile.getOriginalFilename();
                // String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
                String finalImageName = originalFilename;
                String imagePath = uploadDir + finalImageName; // Set the path to save the image

                // Save the image to the specified path
                Path targetPath = Path.of(imagePath);
                Files.copy(imageFile.getInputStream(), targetPath, StandardCopyOption.REPLACE_EXISTING);

                // Return the image name or path in the response
                HashMap<String, String> response = new HashMap<>();
                response.put("imageName", finalImageName);

                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.badRequest().body("Image file is empty.");
            }
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image.");
        }
    }
    
}
