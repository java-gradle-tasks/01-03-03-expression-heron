import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class TestSolution {

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
         sideA="3";
         sideB="2";
         sideC="2";
      } else {
         sideA="3";
         sideB="2";
         sideC="2";
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

      String expected="Haromszog teruletenek meghatarozasa!"+newLine;
      expected+="Adja meg a haromszog a oldalat:Adja meg a haromszog b oldalat:Adja meg a haromszog c oldalat:A haromszog terulete:2.0"+newLine;
      String actual=byteArrayOutputStream.toString();

      System.out.println("Elvart:"+newLine+expected);
      System.out.println("Aktualis:"+newLine+actual);

      boolean found=actual.contains(expected);

      Assertions.assertTrue(found,"Az eredményt nem jól határozta meg");
   }
}
