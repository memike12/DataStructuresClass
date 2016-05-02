public class Magazine extends ReadingMaterial{

    public Magazine(String title, double cost, int quantity){
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String toString(){
        return title + ": $" + cost;
    }
       
    public int compareTo(Object o){
        /* if( this.cost > (Magazine)o.cost){
            return 1;
        }
        else if(this.cost == (Magazine)o.cost){
            return 0;
        }
        else {
            return -1;
            }*/
        return 0;
    }
}