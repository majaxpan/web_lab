package mk.ukim.finki.web_lab_b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class WebLabBApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebLabBApplication.class, args);
    }

}
