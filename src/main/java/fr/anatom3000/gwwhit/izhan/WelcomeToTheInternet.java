public class WelcomeToTheInternet {
    public static void main(String[] args) {
        try {
            System.out.println("welcome to the internet");
            Thread.sleep(2000);

            System.out.println("have a look around de internet");
            Thread.sleep(2000);

            System.out.println("anything that comes true blah blah blah blah");
        } catch (InterruptedException e) {
            System.out.println("bruh");
        }
    }
}
