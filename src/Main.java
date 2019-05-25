import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static Shelf shelf;
    public static ShoppingCart cart;
    public static Scanner sc;

    public static void main(String[] args){
        initialize();
        introduction();
    }

    public static void initialize(){
        sc = new Scanner(System.in);
        cart = new ShoppingCart();
        loadInfo();
    }

    public static void loadShelf(String path){
        try {
            FileInputStream f = new FileInputStream(path);
            ObjectInputStream o = new ObjectInputStream(f);
            shelf = (Shelf) o.readObject();
            cart.cleanCart();
            o.close();
            f.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        if(shelf == null){
            shelf = new Shelf();
        }
    }

    public static void loadInfo(){
        System.out.println("Loading Shop Information...");
        loadShelf("src/shelf.ser");
        System.out.println("Information loaded");
    }

    public static void introduction(){
        System.out.println("========================================================================================");
        System.out.println("!!! Welcome to SSD-SHOP !!!");
        System.out.print("(A) Add item\n(B) Buy item\n(C) Config promotion\n(R) Remove item\n(E) Exit\nPlease insert the letter: ");
        String op = sc.next();
        if(op.equalsIgnoreCase("a")){
            addItem();
        }else if(op.equalsIgnoreCase("b")){
            buyItem();
        }else if(op.equalsIgnoreCase("c")){
            promotion();
        }else if(op.equalsIgnoreCase("r")){
            remove();
        }else if(op.equalsIgnoreCase("e")){
            System.exit(1);
        }else{
            introduction();
        }
    }

    public static void addItem(){
        System.out.println("Please insert the information about the item.");
        System.out.print("Name of item: ");
        String name = sc.next();
        System.out.print("Price of item: ");
        double price = sc.nextDouble();
        Item tmp = new Item(name, price, shelf.getSize()+1);
        System.out.printf("Do you want to add %s %.2f baht to the shelf?\n", name, price);
        System.out.print("(Y) Yes/ (N) No : ");
        if(sc.next().equalsIgnoreCase("y")){
            shelf.addItem(tmp);
        }else{
            System.out.println("Canceled");
        }
        loadInfo();
        introduction();
    }

    public static void buyItem(){
        System.out.println("---------------------------------------------item-list---------------------------------------------");
        shelf.printAllItem();
        do{
            System.out.print("insert the id: ");
            int id = sc.nextInt();
            if(id == 0) break;
            System.out.print("How much/many? ");
            int quan = sc.nextInt();
            cart.addItem(shelf.getItem(id), quan);
        }while(true);
        cart.printAll();
        double total = cart.getTotal();
        if(total == 0){
            introduction();
        }else{
            double cash = 0;
            while(true){
                System.out.printf("It is %.2f baht\nHow much do you pay? ", total);
                cash = sc.nextDouble();
                if(cash - total < 0){
                    System.out.println("Please pay more than total price!");
                }else break;
            }
            System.out.printf("Changes %.2f baht\nThank you for shopping!\n", cash - total);
            introduction();
        }
    }

    public static void promotion(){
        Promotion p = new NonPromotion();
        System.out.println("----------------------------------------item-list----------------------------------------");
        shelf.printAllItem();
        System.out.print("Insert the id that you want to modifies: ");
        int id = sc.nextInt();
        System.out.printf("Do you want to modifies %s?\n", shelf.getItem(id).getName());
        System.out.print("(Y) Yes/ (N) No : ");
        if(sc.next().equalsIgnoreCase("y")){
            System.out.println("Which promotion do you want to modifies to? ");
            System.out.print("(N) No Promotion\n(D) Discount Promotion\n(G) Get More Promotion\nPlease insert the letter: ");
            String op = sc.next();
            if(op.equalsIgnoreCase("n")){
                // do nothing
            }else if(op.equalsIgnoreCase("d")){
                System.out.print("How much percentage do you want to discount? ");
                int percent = sc.nextInt();
                System.out.print("What is a minimum buy to trigger the promotion? ");
                int condition = sc.nextInt();
                p = new DiscountPromotion(condition, percent);
            }else if(op.equalsIgnoreCase("g")){
                System.out.print("How many free amount do they get? ");
                int free = sc.nextInt();
                System.out.print("What is a minimum buy to trigger the promotion? ");
                int condition = sc.nextInt();
                p = new GetMorePromotion(condition, free);
            }else{
                System.out.println("Canceled");
                introduction();
            }
            shelf.getItem(id).setPromotion(p);
            shelf.saveShelf();
        }else{
            System.out.println("Canceled");
        }
        loadInfo();
        introduction();
    }

    public static void remove(){
        System.out.println("----------------------------------------item-list----------------------------------------");
        shelf.printAllItem();
        System.out.print("Insert the id that you want to delete: ");
        int id = sc.nextInt();
        shelf.removeItem(id);
        loadInfo();
        introduction();
    }
}
