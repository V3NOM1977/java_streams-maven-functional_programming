package com.example.functional_interfaces;

import java.util.Optional;

public class _Optional {

    static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public static void main(String[] args) {
        Optional.ofNullable(new User("Rishabh Rawat"))
                .ifPresent(user -> System.out.println(user.getName()));

        System.out.println("---------------------------------------------------------------------------------");

        Optional.ofNullable("henlo@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println(email),
                        () -> System.out.println("empty email"));
    }

}
