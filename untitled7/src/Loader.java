import java.math.BigInteger;

public class Loader {
    public static void main(String[] args) {
        Hellman diffieHellman = new Hellman();

        Hacker hacker = new Hacker(
                diffieHellman.getA(),
                diffieHellman.getB(),
                diffieHellman.getP(),
                diffieHellman.getG()
        );

        BigInteger crackedKey = hacker.getCrackedKey();
        System.out.println("Key: " + crackedKey + "; Сracked? " + diffieHellman.isKeyCracked(crackedKey));
    }
}