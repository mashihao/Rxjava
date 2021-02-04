package com.kds.rxjava;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleEmitter;
import io.reactivex.rxjava3.core.SingleOnSubscribe;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Function;

/**
 * @author : 马世豪
 * time : 2/4/21 16
 * email : ma_shihao@yeah.net
 * des :
 */
public class Test {


    @org.junit.Test
    public void test(){


        Single.create(new SingleOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Throwable {
                emitter.onSuccess("123");

            }
        })
                .flatMap(new Function<String, SingleSource<String>>() {
                    @Override
                    public SingleSource<String> apply(String s) throws Throwable {
                        return Single.create(new SingleOnSubscribe<String>() {
                            @Override
                            public void subscribe(@NonNull SingleEmitter<String> emitter) throws Throwable {
                                emitter.onSuccess(s+"-----");
                            }
                        });
                    }
                })
                .subscribe(new BiConsumer<String, Throwable>() {
                    @Override
                    public void accept(String s, Throwable throwable) throws Throwable {
                        System.out.println(s);
                    }
                });

    }
}
