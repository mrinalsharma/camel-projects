import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.*;
import org.apache.camel.Converter;

@Converter(generateLoader = true)
public class Ioconverter {
    @Converter
    public static InputStream toInputStream(java.util.LinkedList list) {
        StringBuilder str = new StringBuilder();
        list.forEach(value -> {str.append(value);});
        return new BufferedInputStream(str.getBytes());
    }
}