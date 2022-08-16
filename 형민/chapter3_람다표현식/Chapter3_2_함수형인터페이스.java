package chapter3_람다표현식;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Chapter3_2_함수형인터페이스 {

    public String processFile(BufferedReaderProcessor processor) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader("data.txt"));
            return processor.process(br);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String oneLine = processFile((BufferedReader br) -> br.readLine());
    String twoLine = processFile((BufferedReader br) -> br.readLine());
}
