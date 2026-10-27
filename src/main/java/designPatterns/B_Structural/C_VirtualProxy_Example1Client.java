package designPatterns.B_Structural;

/**
 Virtual Proxy Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it. It is used to create expensive objects on demand, manage access to them, and add additional functionality without modifying the original object.
 Protected Proxy Pattern is a structural design pattern that provides controlled access to an object by using a proxy class. It is used to restrict access to certain methods or properties of an object, allowing only authorized clients to interact with it.
 Remote Proxy Pattern is a structural design pattern that provides a local representative for an object that resides in a different address space. It is used to enable communication between clients and remote objects, allowing clients to interact with remote objects as if they were local.
 * **/

interface Video {
    public void play() throws InterruptedException;
}

class Movies implements Video {

    private String filename;

    public Movies(String filename) throws InterruptedException {
        this.filename = filename;
        // Simulate loading the video from the server when the object is created using contractor.
        // This means the video is loaded immediately, even if we never play it.
        // Loading the video without actually using it is an unnecessary operation.
        // This is one of the main disadvantages of using the Proxy pattern.
        loadVideo();
    }

    private void loadVideo() throws InterruptedException {
        {
            System.out.println("Loading video from Server: " + filename);
            Thread.sleep(4000);
        }

    }

    @Override
    public void play() throws InterruptedException {
        System.out.println("Playing video from Server: " + filename);
    }
}

class MoviesProxy implements Video{

    private String filename;
    private Video video;

    // Constructor does not load the play method until the play method is called.
    // This is the main advantage of using Proxy pattern.
    public MoviesProxy(String filename) {
        this.filename = filename;
        System.out.println("Loading video from Proxy");
    }

    // The play method is called when the user wants to play the video.
    @Override
    public void play() throws InterruptedException {
        if (video == null) {
            video = new Movies(filename);
        }
        video.play();
        System.out.println("Playing movie from Proxy");
    }
}

public class C_VirtualProxy_Example1Client {
    public static void main(String[] args) throws InterruptedException {

        long timeStart = System.currentTimeMillis();

        Video video = new MoviesProxy("King.mp4");
        Video video2 = new MoviesProxy("Golmal.mp4");
        Video video3 = new MoviesProxy("Welcome.mp4");

        video.play();
        video2.play();
        video3.play();

        long timeEnd = System.currentTimeMillis();
        System.out.println("Time taken: " + (timeEnd - timeStart) + " ms");
    }
}
