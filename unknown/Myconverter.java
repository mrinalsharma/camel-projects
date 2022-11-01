import org.apache.camel.Converter;
import java.io.InputStream.class;
import java.util.LinkedList.class;
import java.io.ByteArrayInputStream;
@Converter
public class MyConverter {

    @Converter
    public static InputStream catToDog(LinkedList cat) {
    	return new java.io.ByteArrayInputStream("My Hello World".getBytes());;
    }  
}