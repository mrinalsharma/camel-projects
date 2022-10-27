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
import org.jboss.logging.Logger;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.enterprise.event.Observes;
@Singleton @Named("myconverter")
public class Ioconverter {
     private static final Logger LOG = Logger.getLogger(Ioconverter.class);
    CamelContext context;

    @Inject 
    Ioconverter(CamelContext contex) {
        this.context = context;
    }

    void startup(@Observes StartupEvent event) { 
        LOG.info("The application is starting...");
    }

    @PostConstruct
    public void init() {
        LOG.info("Adding converter");
        context.getTypeConverterRegistry().addTypeConverter(java.io.InputStream.class, java.util.LinkedList.class, new MyConverter());
    }

    static class MyConverter extends TypeConverterSupport {
        public <T> T convertTo(Class<T> type, Object value) {
            // converter from value to the MyOrder bean
            return (T) new java.io.ByteArrayInputStream("My Hello World".getBytes());
        }
        public <T> T convertTo(Class<T> type, Exchange exchange, Object value) {
            // this method with the Exchange parameter will be preferd by Camel to invoke
            // this allows you to fetch information from the exchange during convertions
            // such as an encoding parameter or the likes
            return convertTo(type, value);
        }
        public <T> T mandatoryConvertTo(Class<T> type, Object value) {
            return convertTo(type, value);
        }
        public <T> T mandatoryConvertTo(Class<T> type, Exchange exchange, Object value) {
            return convertTo(type, value);
        }
    }
}