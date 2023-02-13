package pk;

import java.util.logging.Logger;
import java.util.*;
class create{
    long number;
    String name;
    String email;
    create next;

    create(String name, long number, String email){
        this.name = name;
        this.email = email;
        this.number = number;
    }
}

class Contactlist{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    create head;
    public void add(String name, long number, String email){
        create newContact = new create(name,number,email);
        if(this.head == null){
            this.head = newContact;
        }
        else{
            create current = this.head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newContact;
        }
    }
    public void remove(){
        create current = this.head;
        create previous = current;
        while(current.next!=null){
            previous = current;
            current = current.next;
        }
        previous.next = null;
    }
    public void remove(long number){
        if(this.head.number == number){
            this.head = this.head.next;
        }
        else{
            create current = this.head;
            create previous = current;
            while(current.number!=number){
                if(current.next!=null){
                    previous = current;
                    current = current.next;
                }
                
            }
            previous.next = current.next;
        }
        
    }
    public void remove(String number){
        if(this.head.name.equals(number)){
            this.head = this.head.next;
        }
        else{
            create current = this.head;
            create previous = current;
            while(!current.name.equals(number)){
                if(current.next!=null){
                    previous = current;
                    current = current.next;
                }  
            }
            previous.next = current.next;
        }
    }
    public void search(String name){
        create current = this.head;
        if(this.head != null){
            while(current!=null){
                if(current.name.equalsIgnoreCase(name)){
                    String s = current.name+", "+current.number+", "+current.email;
                    LOGGER.info(s);
                }
                current = current.next;
            }
        }
    }

    public void print(){
        create current = this.head;
        StringBuilder s = new StringBuilder("");
        while(current!=null){
            s.append("\n"+current.name+" -- "+current.email+" -- "+current.number+"\n");
            current = current.next;
        }
        String str = ""+s;
        LOGGER.info(str);
    }

}

public class Contacts {
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    public static void main(String[] args){
        Contactlist l =new Contactlist();
        Scanner sc = new Scanner(System.in);
        int n = 0;
        do{
            LOGGER.info("1.Add Contact 2.Search 3.Remove Contact 4.view 5.Exit");
            int ch = sc.nextInt();
            if(ch == 1){
                LOGGER.info("Enter number: ");
                long number = sc.nextLong();
                LOGGER.info("Enter name: ");
                String name = sc.next();
                LOGGER.info("Enter email: ");
                String email = sc.next();
                l.add(name, number, email);
            }
            else if(ch == 2){
                LOGGER.info("Enter name");
                String ch1 = sc.next();
                l.search(ch1);
            }
            else if(ch == 3){
                LOGGER.info("1.Remove last 2.Remove number 3.Remove name");
                int ch1 = sc.nextInt();
                if(ch1 == 1){
                    l.remove();
                }
                else if(ch1 == 2){
                    LOGGER.info("Enter number: ");
                    long num = sc.nextLong();
                    l.remove(num);
                }
                else if(ch1 == 3){
                    LOGGER.info("Enter name: ");
                    String num = sc.next();
                    l.remove(num);
                }
                
            }
            else if(ch == 4){
                l.print();
            }
            else if(ch == 5){
                n = 1;
            }
        }while(n == 0);
    }
}
