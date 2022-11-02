import org.apache.camel.Converter;

import java.util.Arrays;
import java.io.InputStream;
import java.util.LinkedList;
import java.io.ByteArrayInputStream;

@Converter
public class Exampleconverter {
     @Converter
    public static InputStream toInputStream(LinkedList elements) {
		String [] stringArray = new String[elements.size()];
		     for(int i =0; i < elements.size(); i++) {
				stringArray[i] = (String) elements.get(i);
			 }
        return new ByteArrayInputStream(Arrays.toString(stringArray).getBytes());
    }

}