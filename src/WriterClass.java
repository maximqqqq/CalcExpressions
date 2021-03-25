import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriterClass {
    private String exp;

    public void methodWriter(String str1, Double str2) {
        this.exp = str2.toString();
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)))) {
            out.println(str1 + " = " + exp);
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
