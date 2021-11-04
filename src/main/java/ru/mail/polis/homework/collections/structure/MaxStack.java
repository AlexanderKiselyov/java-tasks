package ru.mail.polis.homework.collections.structure;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Задание оценивается в 2 балла.
 * Надо расширить стандартный класс Stack методом getMaxValue().
 * Этот метод должен возвращать какое максимальное значение сейчас
 * храниться в Stack. Отрабатывать метод должен за О(1).
 */
public class MaxStack extends Stack<Integer> {
    private final Stack<Integer> maxValue = new Stack<>();

    @Override
    public Integer push(Integer value) {
        if (value != null && (maxValue.isEmpty() || value >= getMaxValue())) {
            maxValue.push(value);
        }
        return super.push(value);
    }

    @Override
    public Integer pop() {
        if (super.peek().equals(getMaxValue())) {
            maxValue.pop();
        }
        return super.pop();
    }

    public Integer getMaxValue() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return maxValue.peek();
    }
}
