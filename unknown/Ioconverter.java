import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.BufferedInputStream;
import java.util.*;
import org.apache.camel.Converter;
import java.io.ByteArrayInputStream;
@Converter(generateLoader = true)
public class Ioconverter {
    @Converter
    public static InputStream toInputStream(java.util.LinkedList list) {
        StringBuilder str = new StringBuilder();
        list.forEach(value -> {str.append(value);});
        return new ByteArrayInputStream(str.toString().getBytes());
    }
}