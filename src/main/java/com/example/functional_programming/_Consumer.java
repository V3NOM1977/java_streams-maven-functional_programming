package com.example.functional_programming;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    private static final Consumer<User> greetUserConsumer = user -> System.out.println("Hello " + user.getName());

    private static final BiConsumer<User, Boolean> greetUserWithAgeConsumer = (user, bool) -> System.out.println(
            "Hello " + user.getName() + ", " +
                    "your age is " + (bool ? user.getAge() : "**"));

    static class User {

        private final String username;

        private final int age;

        public User(String username, int age) {
            this.username = username;
            this.age = age;
        }

        public String getName() {
            return this.username;
        }

        public int getAge() {
            return this.age;
        }

    }

    public static void main(String[] args) {
        User user = new User("Rishabh Rawat", 23);

        greetUserConsumer.accept(user);

        System.out.println("---------------------------------------------------------------------------------");

        greetUserWithAgeConsumer.accept(user, false);
    }

}
