import java.io.IOException;

abstract class Context{

    public abstract void start() throws IOException;
    public abstract void searchSpot();
    public abstract void bookSpot(int number);
    public abstract void availableSpot();
    public abstract void registerUser();
    public abstract void loginUser();
    public abstract void confirm();
    public abstract void myAccount();

    public static void main(String[] args) throws IOException {
        
        new App().start();
    }
}