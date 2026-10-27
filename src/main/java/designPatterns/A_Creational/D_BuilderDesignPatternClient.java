package designPatterns.A_Creational;



class User {

    private final String name;
    private final String mobileNo;
    private final int age;
    private final String address;

    private User(Builder builder) {
        this.name = builder.name;
        this.mobileNo = builder.mobileNo;
        this.age = builder.age;
        this.address = builder.address;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {

        private String name;
        private String mobileNo;
        private int age;
        private String address;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            return new User(this);
        }


    }

}


public class D_BuilderDesignPatternClient {
    public static void main(String[] args) {

        User user = new User.Builder()
                .setName("Rahul")
                .setMobileNo("9876543210")
                .setAge(30)
                .setAddress("Jaipur, Rajasthan")
                .build();

        System.out.println(user);

    }
}
