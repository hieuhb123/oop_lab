package cart;
import media.DigitalVideoDisc;
public class Cart {
    public static final int MAX_NUMBER_ODERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ODERED];
    private int qtyOrdered = 0;
    
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        itemOrdered[0] = disc;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if(this.qtyOrdered < MAX_NUMBER_ODERED){
            itemOrdered[qtyOrdered] = disc;
            this.qtyOrdered++;
        }
        else 
            removeDigitalVideoDisc(disc);
        System.out.println("The disc has been added");
        if(qtyOrdered >= MAX_NUMBER_ODERED - 2) System.out.println("The cart is almost full");
    }

    public double totalCost(){
        double total = 0;
        for(int i = 0 ; i < qtyOrdered ; i++)
            total = total + itemOrdered[i].getCost();
        return total;
    }

    public void print(){
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for(int i = 0 ; i < qtyOrdered ; i++){
            System.out.println(Integer.toString(i+1) + ".DVD-" + this.itemOrdered[i].getTitle() + "-"+ this.itemOrdered[i].getCategory() + "-"+ this.itemOrdered[i].getDirector() + "-"+ this.itemOrdered[i].getLength());
        }
        System.out.println("Total cost:" + totalCost());
        System.out.println("***************************************************");
    }
    public String search(String title){
        for(int i = 0; i < qtyOrdered; i++)
            if(itemOrdered[i].isMatch(title)) return Integer.toString(i+1);
        return "no match is found";
    }
}