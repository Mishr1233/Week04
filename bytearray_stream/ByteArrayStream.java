package org.example.bytearray_stream;

import java.io.*;
import java.nio.file.*;

public class ByteArrayStream {
    public static void main(String[] args) {

        String originalImagePath = "original_image.webp";
        String newImagePath = "new_image.webp";

        try {
            //Read the image file into a byte array
            byte[] imageBytes = Files.readAllBytes(Paths.get(originalImagePath));

            //convert the byte array back into an image and write it to a new file
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
                 ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

                int byteData;
                while ((byteData = bais.read()) != -1) {
                    baos.write(byteData);
                }

                // Step 3: Write the byte array to the new image file
                try (FileOutputStream fos = new FileOutputStream(newImagePath)) {
                    baos.writeTo(fos);
                }

                System.out.println("Image successfully written to " + newImagePath);

            } catch (IOException e) {
                System.out.println("Error during byte array processing: " + e.getMessage());
            }

            // Verify that the new image is identical to the original
            if (compareImages(originalImagePath, newImagePath)) {
                System.out.println("The new image is identical to the original image.");
            } else {
                System.out.println("The new image is NOT identical to the original image.");
            }

        } catch (IOException e) {
            System.out.println("Error reading the original image: " + e.getMessage());
        }
    }

    // Method to compare two images byte by byte
    public static boolean compareImages(String originalImagePath, String newImagePath) {
        try {
            byte[] originalImageBytes = Files.readAllBytes(Paths.get(originalImagePath));
            byte[] newImageBytes = Files.readAllBytes(Paths.get(newImagePath));

            return java.util.Arrays.equals(originalImageBytes, newImageBytes);
        } catch (IOException e) {
            System.out.println("Error comparing images: " + e.getMessage());
            return false;
        }
    }
}
