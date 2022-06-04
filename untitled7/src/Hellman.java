import java.math.BigInteger;
import java.util.Random;

public class Hellman {
    private static final Random random = new Random();
    private final BigInteger p;
    private final BigInteger g;

    private final BigInteger A;
    private final BigInteger B;
    private final BigInteger secretKey;

    private int generateRandomSimpleInt() {
        int n = random.nextInt(900) + 100;
        while (!isSimple(n)) {
            n = random.nextInt(900) + 100;
        }

        return n;
    }

    private boolean isSimple(int n) {
        for (int i = 2; i < n - 1; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public Hellman() {
        p = BigInteger.valueOf(generateRandomSimpleInt());
        g = new BigInteger(String.valueOf(p)).subtract(BigInteger.ONE);

        int a = random.nextInt(900) + 100;
        int b = random.nextInt(900) + 100;

        A = g.pow(a).mod(p);
        B = g.pow(b).mod(p);

        secretKey = A.pow(b).mod(p);
    }

    public BigInteger getP() {
        return p;
    }

    public BigInteger getA() {
        return A;
    }

    public BigInteger getB() {
        return B;
    }

    public BigInteger getG() {
        return g;
    }

    public boolean isKeyCracked(BigInteger key) {
        return secretKey.equals(key);
    }
}