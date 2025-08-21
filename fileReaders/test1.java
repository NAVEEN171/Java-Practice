
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class test1 {

   public static void ReadSafely(String fileName) {
      try (FileReader fr = new FileReader(fileName)) {
         int character;
         while ((character = fr.read()) != -1) {
            System.out.println(fr.read());
            // System.out.println(character);
         }
      } catch (FileNotFoundException e) {
         System.out.println(e.getMessage());

      } catch (IOException e) {
         System.out.println(e.getMessage());
      } catch (Exception e) {
         System.out.println(e.getMessage());

      }

   }

   public static void main(String[] args) {
      final String fileName = "./fileReaders/sample.txt";
      test1 t1 = new test1();
      t1.ReadSafely(fileName);
   }
}
