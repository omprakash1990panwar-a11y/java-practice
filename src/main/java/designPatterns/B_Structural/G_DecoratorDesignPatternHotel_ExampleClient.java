package designPatterns.B_Structural;



interface Room {
    String getDescription();
    double getCost();
}

class BasicRoom implements Room {

    @Override
    public String getDescription() {
        return "Basic Room";
    }

    @Override
    public double getCost() {
        return 100.0;
    }
}

abstract class RoomDecorator implements Room {

    Room room;

    public RoomDecorator(Room room) {
        this.room = room;
    }
}


class ExtraBedRoom extends RoomDecorator{

    public ExtraBedRoom(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + ", with Extra Bed";
    }

    @Override
    public double getCost() {
        return room.getCost() + 40.0;
    }
}


class MiniBarRoom extends RoomDecorator{

    public MiniBarRoom(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + ", with Mini Bar";
    }

    @Override
    public double getCost() {
        return room.getCost() + 30.0;
    }
}

class BreakFastRoom extends RoomDecorator {

    public BreakFastRoom(Room room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return room.getDescription() + ", with Breakfast";
    }

    @Override
    public double getCost() {
        return room.getCost() + 50.0;
    }
}

public class G_DecoratorDesignPatternHotel_ExampleClient {
    public static void main(String[] args) {

        // A base room without any additional features basic price alrady set to 100.0
        Room basicRoom = new BasicRoom();
        System.out.println("Basic Room: " + basicRoom.getDescription() + ", Cost: " + basicRoom.getCost());


        Room breakfastRoom = new BreakFastRoom(basicRoom);
        System.out.println("Breakfast Room: " + breakfastRoom.getDescription() + ", Cost: " + breakfastRoom.getCost());

        Room miniBarRoom = new MiniBarRoom(breakfastRoom);
        System.out.println("Mini Bar Room: " + miniBarRoom.getDescription() + ", Cost: " + miniBarRoom.getCost());

        Room basicRoomWithBar = new MiniBarRoom(new BreakFastRoom(new BasicRoom()));
        System.out.println("Mini Bar Room: " + basicRoomWithBar.getDescription() + ", Cost: " + basicRoomWithBar.getCost());

        Room basicRoomWithMini = new MiniBarRoom((new BasicRoom()));
        System.out.println("Mini Bar Room: " + basicRoomWithMini.getDescription() + ", Cost: " + basicRoomWithMini.getCost());

    }
}
