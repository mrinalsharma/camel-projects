import org.apache.camel.BindToRegistry;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@BindToRegistry("Customprocessor")
public class Customprocessor implements Processor {

  public void process(Exchange exchange) throws Exception {
      exchange.getIn().setBody("Hello world");
  }
}