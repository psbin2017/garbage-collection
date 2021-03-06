package com.collection.gc.sample.enums.annontation;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExceptionTestSample {

    @Test
    public void exceptionTest_test() {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = ExceptionTestSample.class;

        for (Method m : testClass.getDeclaredMethods()) {
            if ( m.isAnnotationPresent(ExceptionTest.class) ) {
                System.out.println( m.getName() );
                tests++;
                try {
                    m.invoke(null);
                    System.out.println("테스트 실패 예외 미발생");
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    int oldPassed = passed;

                    Class<? extends Throwable>[] exeTypes = m.getAnnotation(ExceptionTest.class).value();
                    for (Class<? extends Throwable> exeType : exeTypes) {
                        if ( exeType.isInstance(exc) ) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.println("테스트 실패 다른 예외 발생");
                    }
                } catch (Exception exc) {
                    System.out.println("잘못 사용됨");
                }
            }
        }
    }

    @Test
    public void repeatableTest_test() {
        int tests = 0;
        int passed = 0;
        Class<?> testClass = ExceptionTestSample.class;

        for (Method m : testClass.getDeclaredMethods()) {
            if ( m.isAnnotationPresent(RepeatableTest.class)
                || m.isAnnotationPresent(RepeatableTestContainer.class) ) {
                System.out.println( m.getName() );
                tests++;
                try {
                    m.invoke(null);
                    System.out.println("테스트 실패 예외 미발생");
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    int oldPassed = passed;

                    RepeatableTest[] exeTests = m.getAnnotationsByType(RepeatableTest.class);
                    for (RepeatableTest exeTest : exeTests) {
                        if ( exeTest.value().isInstance(exc) ) {
                            passed++;
                            break;
                        }
                    }
                    if (passed == oldPassed) {
                        System.out.println("테스트 실패 다른 예외 발생");
                    }
                } catch (Exception exc) {
                    System.out.println("잘못 사용됨");
                }
            }
        }
    }

    @ExceptionTest(ArithmeticException.class)
    private static void m1() { // 성공 (ArithmeticException 발생)
        int i = 0;
        i = i / i;
    }

    @ExceptionTest(ArithmeticException.class)
    private static void m2() { // 실패 (다른 예외 발생)
        int[] a = new int[0];
        int i = a[1];
    }

    @ExceptionTest(ArithmeticException.class)
    private static void m3() { // 실패 (예외 미발생)

    }

    @ExceptionTest({ IndexOutOfBoundsException.class
            ,NullPointerException.class })
    private static void m4() { // 성공 (NullPointerException 발생)
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

    @RepeatableTest(IndexOutOfBoundsException.class)
    @RepeatableTest(NullPointerException.class)
    private static void m5() {// 성공 (NullPointerException 발생)
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

}
