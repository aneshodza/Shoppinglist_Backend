package ch.priv.ah.springbootcode;

import ch.priv.ah.springbootcode.architecture.otherServices.OwnPrintStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


@SpringBootApplication
public class SpringbootCodeApplication {

    public static void main(String[] args) /*throws FileNotFoundException*/ {
        SpringApplication.run(SpringbootCodeApplication.class, args);
//        System.setOut(new OwnPrintStream(new FileOutputStream("../callslog.log")));
//        System.out.println("Start of the log file");
//        System.out.println("");
    }

}
