package com.developlee.elklog4j.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Lensen
 * @desc
 * @since 2018/9/7 11:37
 */
@Service
public class PrintLog {

    private static final Logger logger = LoggerFactory.getLogger(PrintLog.class);

    @Scheduled(fixedRate = 5000)
    public void printLogFiveSecond() {
        logger.info("Print Logger Info Five Seconds Once Time");
    }

    public static void main(String[] args) {
        int i = 100;
        int b = 256;
        System.out.println(i % b + "----" + i / b);
        byte[] buf = new byte[12];
        byte[] bytes = new byte[]{1, 3, 4, 5, 6};
        System.arraycopy(bytes, 0, buf, 0, bytes.length);
        for (int j = 0; j < buf.length; j++) {
            System.out.println(buf[j]);
        }
    }
}
