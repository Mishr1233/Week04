package org.example.buffered_streams;


import java.io.*;
        import java.nio.file.*;

public class BufferedStreams {

    public static void main(String[] args) {
        String sourceFile = "input.txt";
        String destinationBuffered = "destination_buffered.txt";
        String destinationUnbuffered = "destination_unbuffered.txt";

        // Copy using Buffered Streams and measure time
        long startTime = System.nanoTime();
        copyFileBuffered(sourceFile, destinationBuffered);
        long endTime = System.nanoTime();
        long bufferedTime = endTime - startTime;
        System.out.println("Buffered Stream Copy Time: " + bufferedTime / 1_000_000.0 + " ms");

        // Copy using Unbuffered Streams and measure time
        startTime = System.nanoTime();
        copyFileUnbuffered(sourceFile, destinationUnbuffered);
        endTime = System.nanoTime();
        long unbufferedTime = endTime - startTime;
        System.out.println("Unbuffered Stream Copy Time: " + unbufferedTime / 1_000_000.0 + " ms");
    }

    // Method to copy using Buffered Streams
    public static void copyFileBuffered(String sourceFile, String destinationFile) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFile))) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied using Buffered Streams: " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to copy using Unbuffered Streams
    public static void copyFileUnbuffered(String sourceFile, String destinationFile) {
        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destinationFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied using Unbuffered Streams: " + destinationFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
