package com.dario;

import java.util.Random;
import java.util.concurrent.*;

import static com.dario.Main.EOF;

public class MainWithArrayBlockingQueue {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(6);


        //Creamos un thread pool manager que gestiona la creacion de nuevos hilos.
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        MyProducer2 producer = new MyProducer2(buffer, ThreadColor.ANSI_YELLOW);
        MyConsumer2 consumer1 = new MyConsumer2(buffer, ThreadColor.ANSI_PURPLE);
        MyConsumer2 consumer2 = new MyConsumer2(buffer, ThreadColor.ANSI_RED);

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

class MyProducer2 implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducer2(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = {"1", "2", "3", "4", "5"};

        for (String num : nums) {
            try {
                System.out.println(color + "Adding..." + num);

                buffer.put(num);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting....");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {

            System.out.println("interrupted");
        }

    }
}

class MyConsumer2 implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumer2(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }


    public void run() {
        while (true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }

                    //tenemos que sincronizar porque entre buffer.isEmpty() y buffer.peek() otro hilo podría borrar el ultimo elemento y dar un nullPointer Excp
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.take());
                    }

                } catch (InterruptedException e) {

                    System.out.println("Interrupted");
                }
            }


        }
    }
}
