import org.apache.camel.Converter;
import java.io.InputStream;
import java.util.LinkedList;
import java.io.ByteArrayInputStream;
@Converter
public class Myconverter {

    @Converter
    public static InputStream catToDog(LinkedList cat) {
    	return new java.io.ByteArrayInputStream("My Hello World".getBytes());;
    }  
}