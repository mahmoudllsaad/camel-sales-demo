package order;

import java.io.InputStream;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class distributeOrderDSL {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		CamelContext context = new DefaultCamelContext();
		try {
			context.addRoutes(new RouteBuilder() {
				
				@Override
				public void configure() throws Exception {
					
					from("direct:DistributeOrderDSL").split(xpath("//order[@product='soaps']/items"))
					
					.to("file:src/main/resources/order/");
					
				}
			});

			context.start();
			
			ProducerTemplate orderProducerTemplate = context.createProducerTemplate();

			InputStream orderInputStream = new orderInputStream("order.xml").getInputStream();

			orderProducerTemplate.sendBody("direct:DistributeOrderDSL", orderInputStream);

		} finally {
			context.stop();
		}

	}

}
