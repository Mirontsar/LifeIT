package com.logic;

import com.messageObj.MessageType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.messageObj.MessageType.getMessageTypeObj;

public class TaxiDriver {
    private static ArrayBlockingQueue<MessageType> bq = new ArrayBlockingQueue<>(100);

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                generateUserRequests();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                distribRequests();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

    }

    private static void generateUserRequests() throws InterruptedException {
        Integer i = 1;
        // Генерируем сообщения от "клиентов"
        while (i < 1000) {
            bq.put(getMessageTypeObj(i++));
        }
    }

    private static void distribRequests() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Integer i = 1;
        while (true) {
            i++;
            if (i > 10) {
                i = 1;
            }
            pool.execute(new Driver(bq.take(), i));

        }
    }
}
