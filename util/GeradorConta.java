package util;
import java.util.Random;
public class GeradorConta {
    public static String gerarNumero() {
       return String.format("%05d", new Random().nextInt(100000));
    }
    
}
