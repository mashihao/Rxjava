package com.kds.rxjava

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.functions.Function
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {


        Observable.just(1, 2, 3)
            .map(object : Function<Int, String> {
                override fun apply(t: Int?): String {
                    return "fdsafd$t"
                }
            })
            .subscribe(object : Observer<String> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable?) {
                }

                override fun onNext(t: String?) {

                }

                override fun onError(e: Throwable?) {
                }

            })

    }
}