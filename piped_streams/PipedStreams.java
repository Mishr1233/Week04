package org.example.piped_streams;

import java.io.*;

class PipedWriter extends Thread {
    private PipedOutputStream pipedOutputStream;

    public PipedWriter(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    @Override
    public void run() {
        try {
            String[] data = {"Hello", "from", "the", "PipedOutputStream", "thread!"};
            for (String str : data) {
                pipedOutputStream.write(str.getBytes());
                pipedOutputStream.write("\n".getBytes());
                Thread.sleep(1000);
            }
            pipedOutputStream.close();  //close the output stream when done
        } catch (IOException | InterruptedException e) {
            System.out.println("Error in PipedWriter: " + e.getMessage());
        }
    }
}

class PipedReader extends Thread {
    private PipedInputStream pipedInputStream;

    public PipedReader(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    @Override
    public void run() {
        try {
            int byteData;
            StringBuilder sb = new StringBuilder();
            while ((byteData = pipedInputStream.read()) != -1) {
                sb.append((char) byteData);
            }
            System.out.println("Data received from writer thread: \n" + sb.toString());
        } catch (IOException e) {
            System.out.println("Error in PipedReader: " + e.getMessage());
        }
    }
}

public class PipedStreams {
    public static void main(String[] args) {
        try {
            //create the PipedOutputStream and PipedInputStream
            PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);

            //Create and start the writer thread
            PipedWriter writer = new PipedWriter(pipedOutputStream);
            writer.start();

            //create and start the reader thread
            PipedReader reader = new PipedReader(pipedInputStream);
            reader.start();

            //Wait for both threads to finish
            writer.join();
            reader.join();

        } catch (IOException | InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
