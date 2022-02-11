import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestOneDigitRoundedArea2 {

   @Test
   public void test() {
      String newLine="";
      if (System.getProperty("os.name").startsWith("Windows")) {
         newLine="\r\n";
      } else {
         newLine="\n";
      }

      String sideA="";
      String sideB="";
      String sideC="";

      if (System.getProperty("os.name").startsWith("Windows")) {
         sideA="3,467892";
         sideB="2,1267349";
         sideC="3,4343454";
      } else {
         sideA="3.467892";
         sideB="2.1267349";
         sideC="3.4343454";
      }

      InputStream stdin = System.in;
      String input=sideA+newLine+sideB+newLine+sideC+newLine;

      System.setIn(new ByteArrayInputStream(input.getBytes()));
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(byteArrayOutputStream);
      PrintStream stdout = System.out;
      System.setOut(ps);

      MyTriangle.main(new String[0]);

      System.setIn(stdin);
      System.setOut(stdout);

      String expected="A haromszog terulete:3.5";
      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      boolean found=actual.contains(expected);

      Assertions.assertTrue(found,"Az eredményt nem jól határozta meg");
   }
}
