import java.util.Arrays;

public class Bookstore{
    ReadingMaterial[] rm = new ReadingMaterial[0];

    public Bookstore(ReadingMaterial[] reads){
        rm = reads;
    }

    public void buy(String title) throws OutOfStockException {
        for(int i = 0; i < rm.length; i++){
            if(rm[i].title.equals(title)){
                try{
                    rm[i].buy();
                    return;
                }
                catch (OutOfStockException ose) {
                }
            }
        }
        throw new OutOfStockException();        
    }

    /*****
     * Prints the reading material array
     ******/
    public void printAll(){
        for(int i = 0; i < rm.length; i++){
            System.out.println(rm[i].toString());
        }
    }

    /*****
     *Sorts the array
     ******/
    public void sort(){
        Arrays.sort(rm); 
    }
}