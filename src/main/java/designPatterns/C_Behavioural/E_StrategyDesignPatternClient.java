package designPatterns.C_Behavioural;


interface EncryptionStrategy {
    void encrypt();
}

interface CompressionStrategy {
    void compress();
}

abstract class Notification {

    EncryptionStrategy encryptionStrategy;
    CompressionStrategy compressionStrategy;

    public Notification(EncryptionStrategy encryptionStrategy, CompressionStrategy compressionStrategy) {
        this.encryptionStrategy = encryptionStrategy;
        this.compressionStrategy = compressionStrategy;
    }
    void encrypt()
    {
        encryptionStrategy.encrypt();
    }

    void compress()
    {
        compressionStrategy.compress();
    }

    abstract void send();
}

class AESEncryptionStrategy implements EncryptionStrategy {
    @Override
    public void encrypt() {
        System.out.println("AES Encrypting");
    }
}

class RSAEncryptionStrategy implements EncryptionStrategy {
    @Override
    public void encrypt() {
        System.out.println("RSA Encrypting");
    }
}

class NoEncryptionStrategy implements EncryptionStrategy {
    @Override
    public void encrypt() {
        System.out.println("No Encryption");
    }
}

class ZIP implements CompressionStrategy {
    @Override
    public void compress() {
        System.out.println("ZIP Compressing");
    }
}

class GZIP implements CompressionStrategy {
    @Override
    public void compress() {
        System.out.println("GZIP Compressing");
    }
}

class NoCompression implements CompressionStrategy {
    @Override
    public void compress() {
        System.out.println("No Compression");
    }
}

class Push extends Notification {
    public Push(EncryptionStrategy encryptionStrategy, CompressionStrategy compressionStrategy) {
        super(encryptionStrategy, compressionStrategy);
    }
    @Override
    public void send() {
        System.out.println("Sending Push Notification");
    }
}

class SMS extends Notification {
    public SMS(EncryptionStrategy encryptionStrategy, CompressionStrategy compressionStrategy) {
        super(encryptionStrategy, compressionStrategy);
    }

    @Override
    public void send() {
        System.out.println("Sending SMS");
    }

}

class Email extends Notification {
    public Email(EncryptionStrategy encryptionStrategy, CompressionStrategy compressionStrategy) {
        super(encryptionStrategy, compressionStrategy);
    }

    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}


public class E_StrategyDesignPatternClient {

    public static void main(String[] args) {

        Notification push = new Push(new AESEncryptionStrategy(), new ZIP());
        push.compress();
        push.encrypt();
        push.send();

        Notification sms = new SMS(new RSAEncryptionStrategy(), new GZIP());
        sms.compress();
        sms.encrypt();
        sms.send();

        Notification email = new Email(new AESEncryptionStrategy(), new ZIP());
        email.compress();
        email.encrypt();
        email.send();

        Notification noCompressionEmail = new Email(new NoEncryptionStrategy(), new NoCompression());
        noCompressionEmail.compress();
        noCompressionEmail.encrypt();
        noCompressionEmail.send();


    }
}
