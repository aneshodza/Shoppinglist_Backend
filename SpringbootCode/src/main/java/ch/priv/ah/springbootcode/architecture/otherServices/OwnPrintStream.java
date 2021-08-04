package ch.priv.ah.springbootcode.architecture.otherServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.LocalDateTime;


/**
 * @class: OwnPrintStream
 * @author: Anes Hodza
 * @version: 31.07.2021
 **/

public class OwnPrintStream extends PrintStream {
    public OwnPrintStream(OutputStream out) throws FileNotFoundException {
        super(out);
        System.setOut(new PrintStream("../callslog.log"));
    }

    @Override
    public void println(String string) {
        LocalDateTime dateTime = LocalDateTime.now();
        super.println(
                "[" +
                    dateTime.getDayOfMonth() + "." + dateTime.getMonthValue() + "." + dateTime.getYear() + " " +
                    dateTime.getHour() + ":" + dateTime.getMinute() + ":" + dateTime.getSecond() +
                "] " + string
        );
    }
}
