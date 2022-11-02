import org.apache.camel.Converter;

import java.io.*;

@Converter
public class Exampleconverter {
     @Converter
    public static InputStream toInputStream(File file) throws FileNotFoundException {
        return new BufferedInputStream(new FileInputStream(file));
    }

}