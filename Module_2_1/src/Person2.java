public class Person2 {
    private String name, lastName;

    public Person2(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void introduce() {
        System.out.println("Hello! My name is " + name + " " + lastName);
    }

    @Override
    public String toString() {
        return "Hello! My name is " + name + " " + lastName;
    }
}
