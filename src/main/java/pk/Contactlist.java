package pk;
import java.util.logging.Logger;
class Contactlist{
    private static final Logger LOGGER =  Logger.getLogger("InfoLogging");
    Create head;
    public void add(String name, long number, String email){
        Create newContact = new Create(name,number,email);
        if(this.head == null){
            this.head = newContact;
        }
        else{
            Create current = this.head;
            while(current.next!=null){
                current = current.next;
            }
            current.next = newContact;
        }
    }
    public void remove(){
        Create current = this.head;
        Create previous = current;
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
            Create current = this.head;
            Create previous = current;
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
            Create current = this.head;
            Create previous = current;
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
        Create current = this.head;
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
        Create current = this.head;
        StringBuilder s = new StringBuilder("");
        while(current!=null){
            s.append("\n"+current.name+" -- "+current.email+" -- "+current.number+"\n");
            current = current.next;
        }
        String str = ""+s;
        LOGGER.info(str);
    }

}
