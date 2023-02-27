package pk;

import java.util.logging.Logger;
import java.util.*;



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
