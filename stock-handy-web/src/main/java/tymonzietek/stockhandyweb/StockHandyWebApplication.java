package tymonzietek.stockhandyweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan({"tymonzietek.stockhandyweb", "tymonzietek.stockhandydata"})
public class StockHandyWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockHandyWebApplication.class, args);
	}

}
