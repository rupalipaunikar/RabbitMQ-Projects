package com.rbmq.demo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;

public class Main {
    public Main() throws Exception{

        QueueConsumer consumer = new QueueConsumer("queue1");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();

        Producer producer = new Producer("queue1");

        for (int i = 0; i < 1000000; i++) {
            HashMap message = new HashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            System.out.println("Message Number "+ i +" sent.");
        }
    }

    /**
     * @param args
     * @throws SQLException
     * @throws IOException
     */
    public static void main(String[] args) throws Exception{
        new Main();
    }
}
