/**
 * Fanhub.cn
 * Copyright (c) 2014-2018 All Rights Reserved.
 */
package cn.fanhub;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chengfan
 * @version $Id: FluxTest.java, v 0.1 2018年03月07日 下午11:07 chengfan Exp $
 */
public class FluxTest {

    @Test
    public void test1() throws InterruptedException {
        Flux.just("aaa", "bbb").subscribe(System.out::println);
        System.out.println("----");
        Flux.fromArray(new Integer[] {1, 2, 3}).subscribe(System.out::println);
        System.out.println("----");
        Flux.empty().subscribe(System.out::println);
        System.out.println("----");
        Flux.range(1, 10).subscribe(System.out::println);
        System.out.println("----");
        Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
        System.out.println("----");
        Flux.intervalMillis(1000).subscribe(System.out::println);
        Thread.sleep(2000);
    }

    @Test
    public void test2() {
        Flux.generate(sink -> {
            sink.next("Hello");
            sink.complete();
        }).subscribe(System.out::println);


        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink) -> {
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10) {
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }
    @Test
    public void test3() {
        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }

    @Test
    public void test4() {
        Flux.merge(Flux.intervalMillis(0, 100).take(5), Flux.intervalMillis(50, 100).take(5))
                .toStream()
                .forEach(System.out::println);
    }

}