public class Book extends ReadingMaterial{

    public String author;

    public Book(String title, String author, double cost, int quantity){
        this.author = author;
        this.title = title;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String toString(){
        return author + ", " + title + ": $" + cost;
    }
}


