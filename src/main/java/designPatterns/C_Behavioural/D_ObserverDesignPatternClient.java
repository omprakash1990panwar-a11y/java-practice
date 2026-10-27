package designPatterns.C_Behavioural;



import java.util.ArrayList;
import java.util.List;

interface Subscriber{
    void update(TheCoderChannel channel);
}

class YoutubeSubscriber implements Subscriber {
    private String name;
    private int id;

    public YoutubeSubscriber(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void update(TheCoderChannel channel) {
        System.out.println("uploaded video" + "Title: " + channel.getVideoTitle() + "fileName "
                + channel.getVideoFileName() + " Received notification by " + name+ " Id : "+ id);
    }
}


class InstagramSubscriber implements Subscriber {
    private String name;
    private int id;

    public InstagramSubscriber(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void update(TheCoderChannel channel) {
        System.out.println("uploaded video" + "Title: " + channel.getVideoTitle() + "fileName "
                + channel.getVideoFileName() + " Received notification by " + name+ " Id : "+ id);
    }
}

class TheCoderChannel {

    private String videoTitle;
    private String videoFileName;
    List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber sub)
    {
        subscribers.remove(sub);

    }

    public void notifyAllSubscribers() {
        subscribers.stream().forEach(youtubeSubscriber -> {
            youtubeSubscriber.update(this);
        });
    }

    public void uploadVideo(String videoTitle,String videoFileName){
        this.videoFileName =videoFileName;
        this.videoTitle=videoTitle;
        System.out.println("New Video has been uploaded");
        notifyAllSubscribers();
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoFileName() {
        return videoFileName;
    }
}




public class D_ObserverDesignPatternClient {
    public static void main(String[] args) {

        YoutubeSubscriber chman = new YoutubeSubscriber("Chaman Youtube",1);
        YoutubeSubscriber naman = new YoutubeSubscriber("naman Youtube",2);
        YoutubeSubscriber kamal = new YoutubeSubscriber("kamal Youtube",3);

        TheCoderChannel theCoderChannel = new TheCoderChannel();
        theCoderChannel.subscribe(chman);
        theCoderChannel.subscribe(naman);
        theCoderChannel.subscribe(kamal);

        theCoderChannel.unsubscribe(kamal);


        InstagramSubscriber instagram1 = new InstagramSubscriber("chman Instagram",1);
        InstagramSubscriber instagram2 = new InstagramSubscriber("chman Instagram",2);
        InstagramSubscriber instagram3 = new InstagramSubscriber("chman Instagram",3);


        theCoderChannel.subscribe(instagram1);
        theCoderChannel.subscribe(instagram2);
        theCoderChannel.subscribe(instagram3);


        theCoderChannel.uploadVideo("Oversver Design Pattern ", "http:\\\\Observer\\Designa.Mp4");

    }
}
