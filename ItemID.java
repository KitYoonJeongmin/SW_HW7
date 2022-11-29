package 과제7;

import java.util.Objects;

public class ItemID {
    private int id;
    ItemID(int itemID){this.id = itemID;}
    public int getID() {return this.id;}

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;    
        if(o == null || getClass() != o.getClass()) return false;
        
        ItemID other = (ItemID)o;
        
        return other.id == id;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id); 
    }
}
