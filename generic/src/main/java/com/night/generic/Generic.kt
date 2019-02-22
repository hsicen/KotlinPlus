package com.night.generic

import kotlin.reflect.KClass

/**
 * <p>作者：Night  2019/2/22 16:33
 * <p>邮箱：codinghuang@163.com
 * <p>作用：
 * <p>描述：KotlinPlus
 */


//泛型类Zoom有一个泛型参数T，T没有任何界定，可以为任意类型
class Zoom<T>(t: T)

//泛型类ZoomUp有一个泛型参数T,T必须为Animal的子类
class ZoomUp<T : Animal>(t: T)

//泛型实化，保留泛型的运行时信息
inline fun <reified T : Any> create(): T? = Retrofit().create(T::class)

//T为Animal的子类，ZoomS<Dog>仍然为ZoomS<Animal>的子类
//协变：不能出现在函数的参数里，只能存在返回值位置上
class ZoomS<out T>(val t: T) {

    //fun adaption(t: T) {}  这种声名是错的

    fun release(): T {

        return t
    }
}


//T为Animal的子类，ZoomR<Animal>为ZoomR<Dog>的子类
//逆变：不能出现在函数的返回值上，只能出现在函数的参数里
class ZoomR<in T>(t: T) {

    //fun release(): T { }   这种声名是错的

    fun adaption(t: T) {

    }

}

//点形变： 将泛型类声名为不形变的，
// 在使用的时候加上out或者in，让其在使用的时候产生形变
class ZoomD<T>(val t: T) {

    fun adoption(t: T) {

        println("adaption: $t")
    }

    fun release(): T {

        return t
    }
}

fun function1(zoom: ZoomD<out Animal>) {

    val anima: Animal = zoom.release()
}

fun function2(zoom: ZoomD<in Animal>) {

    val dog = Dog()
    zoom.adoption(dog)
}


open class Animal

class Cat : Animal()

class Dog : Animal()


fun function(zoom: ZoomS<Animal>) {

    val animal = Animal()
}

fun main() {

    val anyZoom = Zoom(Any())
    val animalZoom = Zoom(Animal())
    val catZoom = Zoom(Cat())
    val dogZoom = Zoom(Dog())


    println("Any: $anyZoom")
    println("Animal: $animalZoom")
    println("Cat: $catZoom")
    println("Dog: $dogZoom")


    val animalUp = ZoomUp(Animal())
    val dogUp = ZoomUp(Dog())

    println("Animal: ${animalUp.javaClass}")
    println("Dog: ${dogUp.javaClass}")
    println(animalUp == dogUp)


    val dogZoomS = ZoomS(Dog())
    function(dogZoomS)

    val zoomD = ZoomD(Dog())
    function1(zoomD)

    val zoomD1 = ZoomD(Animal())
    function2(zoomD1)
}

class Retrofit {

    fun <T : Any> create(cls: KClass<T>): T? {
        val instance = cls.objectInstance

        return instance
    }
}

