import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {
        "classpath:base-application.properties"
})

public class CartManagementEntryPoint {
  public static void main(String[] args) {
    SpringApplication.run(CartManagementEntryPoint.class, args);
  }
}
