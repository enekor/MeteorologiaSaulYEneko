import funcional.HTMLCodeGenerator;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {

        HTMLCodeGenerator generator = new HTMLCodeGenerator();
        System.out.println(generator.devolverMagnitudes("102"));
    }
}
