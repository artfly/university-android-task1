package io.github.noveo.artfly.task1.app;

/**
 * Created by arty on 23.02.16.
 */
public class SubmitEvent {
    public final String name;
    public final String surname;
    public final String age;

    public SubmitEvent(String name, String surname, String age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
