import html.HTMLCodeGenerator;
import html.HTMLGenerator;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Long startTime = System.currentTimeMillis();

        HTMLCodeGenerator generator = new HTMLCodeGenerator();
        HTMLGenerator htmlGenerator = new HTMLGenerator();

        String html = (generator.devolverMagnitudes("102"));

        String uri = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"resources";
        Long finishTime = (System.currentTimeMillis()-startTime)/1000;
        htmlGenerator.htmlGenerator("102",html,uri,finishTime);
    }
}
