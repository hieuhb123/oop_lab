
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

    public float totalCost(){
        float total = 0;
        for(int i = 0 ; i < qtyOrdered ; i++)
            total = total + itemOrdered[i].getCost();
        return total;
    }
}