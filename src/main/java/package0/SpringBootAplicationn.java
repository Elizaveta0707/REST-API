package package0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.*"})


@EntityScan

@SpringBootApplication
public class SpringBootAplicationn
{
    public static void main(String[] args) {
        SpringApplication.run(SpringBootAplicationn.class);
    }
}
