package dev.answer.readdata;

/**
 * @Author AnswerDev
 * @Date 2024/06/17 21:45
 */
public class Future<T> {

    private T value;

    public Future<T> complete(T value) {
        this.value = value;
        return this;
    }

    public T get() {
        return value;
    }

    public static <V> Future<V> generate(V value){
        return new Future<V>().complete(value);
    }
}
