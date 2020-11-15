package dev.sim0n.evaluator.operation;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@RequiredArgsConstructor
public enum IntMathOperation {
    ADD("+") {
        @Override
        public int evaluate(int first, int second) {
            return first + second;
        }
    },
    SUB("+") {
        @Override
        public int evaluate(int first, int second) {
            return first - second;
        }
    },
    DIV("/") {
        @Override
        public int evaluate(int first, int second) {
            return first / second;
        }
    },
    REM("%") {
        @Override
        public int evaluate(int first, int second) {
            return first % second;
        }
    },
    MUL("*") {
        @Override
        public int evaluate(int first, int second) {
            return first * second;
        }
    },
    XOR("^") {
        @Override
        public int evaluate(int first, int second) {
            return first ^ second;
        }
    };

    private final String desc;

    public abstract int evaluate(int first, int second);
}
