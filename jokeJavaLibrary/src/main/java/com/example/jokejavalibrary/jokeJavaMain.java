package com.example.jokejavalibrary;

public class jokeJavaMain {

    public String tellaJoke (){
        double x = Math.random() * 100;
        if (x < 33) return "Why are frogs always so happy? They eat what ever bugs them";
        else if (x > 66) return "What is the difference between a snowman and a snowwoman?\n" +
                "Snowballs.";
        else return "I was making Russian tea. Unfortunately I cannot fish the teabag out of the vodka bottle\n";
    }
}
