import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Shelf implements Serializable {
    private List<Item> shelf;

    public Shelf(){
        this.shelf = new ArrayList<>();
    }

    public void addItem(Item item){
        this.shelf.add(item);
        System.out.println("Item added");
        saveShelf();
    }

    public Item getItem(int id){
        for(Item d: shelf){
            if(id == d.getId())
            return d;
        }
        System.out.println("Failed to get item. (There aren't any item use that id.)");
        return null;
    }

    public void removeItem(int id){
        for(Item d: shelf){
            if(id == d.getId()){
                shelf.remove(d);
                System.out.println("Remove Successful.");
                saveShelf();
                return;
            }
        }
        System.out.println("Failed to get item. (There aren't any item use that id.)");
        return;
    }

    public void printAllItem(){
        for(Item d: shelf){
            System.out.println(d);
        }
        System.out.println("---------------------------------------------------------------------------------------------------");
    }

    public int getSize(){
        return shelf.size();
    }

    public void saveShelf(){
        try {
            FileOutputStream f = new FileOutputStream("src/shelf.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(this);
            o.close();
            f.close();
            System.out.println("Save shelf successful.");
        } catch (FileNotFoundException e) {
            System.out.println("Failed to locate file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
