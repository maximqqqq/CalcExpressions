import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderClass {
    private String str = "";
    CalculatorImpl calculator;
    WriterClass writerClass = new WriterClass();

    public void readAddList() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))) {
            while ((str = bufferedReader.readLine()) != null) {
//                System.out.println(str.replaceAll("\\s", "").replaceAll("", " ").trim());
                calculator = new CalculatorImpl(str.replaceAll("\\s", "").replaceAll("", " ").trim());
                writerClass.methodWriter(str.replaceAll("\\s",""), calculator.calculate());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
