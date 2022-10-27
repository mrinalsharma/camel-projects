import javax.inject.Inject;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.stream.Collectors;
import java.util.List;
import org.apache.camel.CamelContext;
import java.io.InputStream;
import org.apache.camel.TypeConverter;
import java.io.ByteArrayInputStream;
import java.util.LinkedList;
import org.apache.camel.Exchange;
import org.apache.camel.support.TypeConverterSupport;
@ApplicationScoped
public class Ioconverter {

    @Inject
    CamelContext context;

    @PostConstruct
    public void init() {
        return context.getTypeConverterRegistry().addTypeConverter(java.util.LinkedList.class, java.io.InputStream.class, new MyConverter());
    }

    static class MyConverter extends TypeConverterSupport {
        @overide
        public <T> T convertTo(Class<T> type, Object value) {
            // converter from value to the MyOrder bean
            return (T) new java.io.ByteArrayInputStream("My Hello World".getBytes());
        }
        @overide
        public <T> T convertTo(Class<T> type, Exchange exchange, Object value) {
            // this method with the Exchange parameter will be preferd by Camel to invoke
            // this allows you to fetch information from the exchange during convertions
            // such as an encoding parameter or the likes
            return convertTo(type, value);
        }
        @overide
        public <T> T mandatoryConvertTo(Class<T> type, Object value) {
            return convertTo(type, value);
        }
        @overide
        public <T> T mandatoryConvertTo(Class<T> type, Exchange exchange, Object value) {
            return convertTo(type, value);
        }
    }
}