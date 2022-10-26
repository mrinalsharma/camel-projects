import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton @Named("CustomProcessor")
public class Customprocessor implements Processor {

  public void process(Exchange exchange) throws Exception {
      exchange.getIn().setBody("Hello world");
  }
}