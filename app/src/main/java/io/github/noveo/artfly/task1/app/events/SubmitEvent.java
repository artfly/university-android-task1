package io.github.noveo.artfly.task1.app.events;

public class SubmitEvent {
    public final CharSequence name;
    public final CharSequence surname;
    public final CharSequence age;

    public SubmitEvent(CharSequence name, CharSequence surname, CharSequence age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

}
