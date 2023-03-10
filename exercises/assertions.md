# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In class, we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The reason why this assertion fails is that the result of the multiplication is not exactly equal to 1.2, because floating numbers are not infinitely precise. 
   The correct way to check this is to use `assertEquals` with a delta value. For example, `assertEquals(1.2, 3 * .4, 0.0001)`.
2. `assertEquals` checks if two objects are equal, while `assertSame` checks if two objects are the same. 
   For example,
   ```java
   String s1 = new String("Hello");
   String s2 = new String("Hello");
   assertEquals(s1, s2); // true
   assertSame(s1, s2); // false
   ```
3. As the Javadoc described, the function `fail()` is to be used to fail a test without a failure message. The Javadoc also said that this function is designed for legacy code and it would be
   better to use the variant `fail(String, Throwable)`.
   
   An example of this usage could be:

   ```java
   void someFunc(int arg) {
     if (arg < 0) 
       throw new RuntimeException();
     ...
   }
   
   @Test void testSomeFunc() {
     ...
     someFunc(-2);
     fail();
   }
   ```

4. In JUnit 4, the expected exception was specified in the `@Test` annotation, which is not very readable. 
   In JUnit 5, the expected exception is specified in the assertion method, which is more readable. 
   Also, the assertion method can be used in a lambda expression, which is not possible with the `@Test` annotation.
