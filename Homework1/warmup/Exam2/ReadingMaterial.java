public abstract class ReadingMaterial implements Comparable {
    public String title;
    public double cost;
    public int quantity;

    public ReadingMaterial(){}

    public ReadingMaterial(String title, double cost, int quantity){
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getTitle(){
        return title;
    }
    
    public double getCost(){
        return cost;
    }

    public int getQuantity(){
        return quantity;
    }

    public void buy() throws OutOfStockException{
        if (quantity <= 0){
            throw new OutOfStockException();
        }
        else{
            quantity = quantity - 1;
        }
    }

    /**
     * Makes sure that everything that extends reading material has a toString
     **/
    public abstract String toString();
   
    /**
     * implements the sort meathod
     ***/
    public int compareTo(Object o){
        /*if( this.cost > o.getCost()){
            return 1;
        }
        else if(this.cost == o.getCost()){
            return 0;
        }
        else {
            return -1;
            }*/
        return 0;
    }
}