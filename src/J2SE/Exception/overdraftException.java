package J2SE.Exception;

public class overdraftException extends Exception{
    private double deficit;
    public overdraftException(String message,double deficit){
        super(message);
        this.deficit=deficit;
    }
    public double getDeficit(){
        return this.deficit;
    }
}
