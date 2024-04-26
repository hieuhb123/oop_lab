package store;
import disc.DigitalVideoDisc;
public class Store {
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[20];
    private int quanity = 0;
    public void addDVD(DigitalVideoDisc digitalVideoDisc){
        this.itemsInStore[quanity] = digitalVideoDisc;
        this.quanity++;
    }

    public void removeDVD(DigitalVideoDisc digitalVideoDisc){
        int index = 19;
        for(int i = 0; i < quanity; i++){
            if(itemsInStore[i].isMatch(digitalVideoDisc.getTitle())){
                index = i;
                break;
            }
        }
        for(int i = index; i < quanity - 1; i++){
            itemsInStore[i] = itemsInStore[i+1];
        }
    }
    public void print(){
        System.out.println("***********************Store***********************");
        System.out.println("Items: ");
        for(int i = 0 ; i < quanity ; i++){
            System.out.println(Integer.toString(i+1) + ".DVD-" + this.itemsInStore[i].getTitle() + "-"+ this.itemsInStore[i].getCategory() + "-"+ this.itemsInStore[i].getDirector() + "-"+ this.itemsInStore[i].getLength());
        }
        System.out.println("***************************************************");
    }
}
