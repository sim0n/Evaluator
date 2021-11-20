package dev.sim0n.evaluator.manager;

import dev.sim0n.evaluator.Main;
import dev.sim0n.evaluator.test.Test;
import dev.sim0n.evaluator.test.impl.annotation.AnnotationTest;
import dev.sim0n.evaluator.test.impl.exception.OpaqueConditionTest;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestManager {
    private static final List<Class<? extends Test>> TEST_CLASSES = Arrays.asList(
            AnnotationTest.class,
            OpaqueConditionTest.class
    );

    private final List<Test> tests = new ArrayList<>();

    public TestManager() {
        TEST_CLASSES.forEach(clazz -> {
            try {
                tests.add(clazz.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        Main.LOG.println(String.format("Loaded %d tests", tests.size()));
    }

    public void handleTests() {
        tests.forEach(Test::handle);
    }
}
