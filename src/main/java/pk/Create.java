package pk;

public class Create{
    long number;
    String name;
    String email;
    Create next;

    Create(String name, long number, String email){
        this.name = name;
        this.email = email;
        this.number = number;
    }
}

