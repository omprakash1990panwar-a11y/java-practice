package designPatterns.C_Behavioural;

// Command Interface
interface Command {
    void execute();
}

// Concrete Command for turning a device ON
class TurnOnCommand implements Command {
    private Device device;

    public TurnOnCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOn();
    }
}

// Concrete Command for turning a device OFF
class TurnOffCommand implements Command {
    private Device device;

    public TurnOffCommand(Device device) {
        this.device = device;
    }

    @Override
    public void execute() {
        device.turnOff();
    }
}

// Concrete Command for adjusting Stereo volume
class AdjustVolumeCommand implements Command {
    private Stereo stereo;

    public AdjustVolumeCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.adjustVolume();
    }
}

// Concrete Command for changing TV channel
class ChangeChannelCommand implements Command {
    private TV tv;

    public ChangeChannelCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.changeChannel();
    }
}

// Receiver Interface
interface Device {
    void turnOn();
    void turnOff();
}

// Concrete Receiver: TV
class TV implements Device {
    @Override
    public void turnOn() {
        System.out.println("TV is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("TV is now off");
    }

    public void changeChannel() {
        System.out.println("Channel changed");
    }
}

// Concrete Receiver: Stereo
class Stereo implements Device {
    @Override
    public void turnOn() {
        System.out.println("Stereo is now on");
    }

    @Override
    public void turnOff() {
        System.out.println("Stereo is now off");
    }

    public void adjustVolume() {
        System.out.println("Volume adjusted");
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command assigned");
        }
    }
}

// Main Class
public class F_CommandPatternClient {
    public static void main(String[] args) {

        // Create receivers
        TV tv = new TV();
        Stereo stereo = new Stereo();

        // Create commands
        Command turnOnTV = new TurnOnCommand(tv);
        Command turnOffTV = new TurnOffCommand(tv);

        Command adjustVolume = new AdjustVolumeCommand(stereo);
        Command changeChannel = new ChangeChannelCommand(tv);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        remote.setCommand(turnOnTV);
        remote.pressButton();

        remote.setCommand(adjustVolume);
        remote.pressButton();

        remote.setCommand(changeChannel);
        remote.pressButton();

        remote.setCommand(turnOffTV);
        remote.pressButton();
    }
}