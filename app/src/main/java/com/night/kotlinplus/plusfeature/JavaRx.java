package com.night.kotlinplus.plusfeature;

import android.annotation.SuppressLint;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

/**
 * <p>作者：Night  2019/1/6 11:12
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */
public class JavaRx {

    @SuppressLint("CheckResult")
    public static void main(String[] args) {

        final String[] a = new String[]{"4", "0", "7", "i", "f", "w", "0", "9"};
        final Integer[] index = new Integer[]{5, 3, 9, 4, 8, 3, 1, 9, 2, 1, 7};

        Observable.just(index)
                .flatMap(new Function<Integer[], ObservableSource<Integer>>() {
                    @Override
                    public ObservableSource<Integer> apply(Integer[] integers) {
                        return Observable.fromArray(integers);
                    }
                })
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) {
                        return integer < a.length;
                    }
                }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return a[integer];
            }
        }).reduce(new BiFunction<String, String, String>() {
            @Override
            public String apply(String s, String s2) {
                return s + s2;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("密码是：" + s);
            }
        });
    }
}
