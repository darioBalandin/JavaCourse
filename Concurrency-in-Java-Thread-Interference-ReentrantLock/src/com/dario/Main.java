package com.dario;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

import static com.dario.Main.EOF;

public class Main {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();


        //Creamos un thread pool manager que gestiona la creacion de nuevos hilos.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer producer = new MyProducer(buffer, ThreadColor.ANSI_YELLOW, bufferLock);
        MyConsumer consumer1 = new MyConsumer(buffer, ThreadColor.ANSI_PURPLE, bufferLock);
        MyConsumer consumer2 = new MyConsumer(buffer, ThreadColor.ANSI_RED, bufferLock);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        //callable es como runnable pero retornando algo
        //Si el thread pool es mayor que los 3 execute que tenemos previos, el callable se ejecutara antes de que ellos terminen

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "This is the String we return from callable";
            }
        });


        try {
            System.out.println(future.get());

        } catch (ExecutionException e) {
            System.out.println("Soming wrong");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }


        //Hay que llamar shutdown para terminar todos los hilos
        executorService.shutdown();
    }
}

class MyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }

    }
}

class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {

        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter is : " + counter);
                    counter = 0;
                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }

                } finally {
                    bufferLock.unlock();
                }

            } else {
                counter++;
            }

        }
    }
}
