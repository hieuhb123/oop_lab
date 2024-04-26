import store.Store;
import disc.DigitalVideoDisc;
public class StoreTest {
    public static void main(String[] args){
        Store store = new Store();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",  "Roger aler", 87, 19.95f);
        store.addDVD(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star war", "Science Fiction", "George Lucas", 87, 24.95f);
        store.addDVD(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addDVD(dvd3);
        
    }
}
