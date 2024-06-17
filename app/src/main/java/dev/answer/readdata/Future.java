package dev.answer.readdata;

/**
 * @Author AnswerDev
 * @Date 2024/06/17 21:45
 */
public class Future<T> {

    private T value;

    public void complete(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
