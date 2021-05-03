package com.example.vintest;

public class Questions {
    public String questions[] = {
            "What is the size of char variable?",
            "Method Overriding is an example of",
            "Which of the following is a marker interface?"
    };

    public String choices[][] = {
            {"8 Bit", "32 Bit", "16 Bit", "64 Bit"},
            {"Static Binding.", "Dynamic Binding.", "Both of the above.", "None of the above."},
            {"serializable", "comparable", "cloneable", "None of the above."}
    };

    public String correctAnswer[] = {
            "16 Bit",
            "Dynamic Binding.",
            "serializable"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
