package Thread.myCompletavleFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author dell
 */
public class Test {
    public static void main(String[]args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t没有返回值");
        });
        completableFuture.get();

        CompletableFuture<Integer> completableFuture2=CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t有返回值");
            int age=10/0;

            return 1024;
        });

        System.out.println(completableFuture2.whenComplete((t,u)->{
          System.out.println("StartCapture  StartCapture"+t);
          System.out.println("u  \t"+u);
        }).exceptionally(f->{
            System.out.println("exception "+f.getMessage());
            return 444;
        }).get());


    }
}
