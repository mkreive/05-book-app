package lt.javau5.bookapp.configurations;

import lt.javau5.bookapp.services.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration implements ApplicationRunner {

    private static final Logger log = LoggerFactory.getLogger(MyConfiguration.class);

    @Autowired
    BookService service;

    @Override
    public void run(ApplicationArguments args) {
        String msg = service.seedBooks() ? "Product added" : "Product not added";
        log.info(msg);
    }
}