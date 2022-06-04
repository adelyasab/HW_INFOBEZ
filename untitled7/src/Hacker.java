import java.math.BigInteger;

public class Hacker {
    private final BigInteger A;
    private final BigInteger B;
    private final BigInteger p;
    private final BigInteger g;

    public Hacker(BigInteger A, BigInteger B, BigInteger p, BigInteger g) {
        this.A = A;
        this.B = B;
        this.p = p;
        this.g = g;
    }

    public BigInteger getCrackedKey() {
        int crackedMessage = getCrackedMessage();
        return crackKey(B, crackedMessage);
    }

    public int getCrackedMessage() {
        int a = 1;

        int intP = p.intValue();

        while (a < intP && !g.pow(a).mod(p).equals(A)) {
            a++;
        }

        return a;
    }

    private BigInteger crackKey(BigInteger B, int a) {
        return B.pow(a).mod(p);
    }
}