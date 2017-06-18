package com.example.android.quiztest1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.quiztest1.R;

import static android.R.attr.right;
import static android.R.id.input;
import static android.os.Build.VERSION_CODES.M;
import static android.widget.Toast.makeText;
import static com.example.android.quiztest1.R.id.inputName;
import static com.example.android.quiztest1.R.string.Q3A1;
import static com.example.android.quiztest1.R.string.answerOne;
import static com.example.android.quiztest1.R.string.answerThree;
import static com.example.android.quiztest1.R.string.answerTwo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitTest(View view) {
        int Correct = calculateCorrect();
        int Wrong = 5 - calculateCorrect();


        EditText inputName = (EditText) findViewById(R.id.inputName);
        String Name = inputName.getText().toString();

        String testMessage = testResults(Correct, Wrong, Name);

        displayMessage(testMessage);

    }

    private String testResults(int correct, int wrong, String inputName) {
        String testMessage = "Hello  " + inputName;
        testMessage += "\nTotal Correct: " + correct;
        testMessage += "\nTotal Wrong: " + wrong;
        testMessage += "\nThank You!";
        return testMessage;
    }


    private int calculateCorrect() {

        CheckBox answerOne = (CheckBox) findViewById(R.id.answerOne_checkbox);
        boolean isCorrectOne = answerOne.isChecked();

        CheckBox notRightTwo = (CheckBox) findViewById(R.id.answerTwo_checkbox);
        boolean notCorrectTwo = notRightTwo.isChecked();

        CheckBox notRightThree = (CheckBox) findViewById(R.id.answerThree_checkbox);
        boolean notCorrectThree = notRightThree.isChecked();

        EditText Q2A1 = (EditText) findViewById(R.id.Q2A1);
        String isCorrectTwo = Q2A1.getText().toString();

        RadioButton answerThree = (RadioButton) findViewById(R.id.Q3A1);
        boolean isCorrectThree = answerThree.isChecked();

        RadioButton answerFour = (RadioButton) findViewById(R.id.Q4A1);
        boolean isCorrectFour = answerFour.isChecked();

        RadioButton answerFive = (RadioButton) findViewById(R.id.Q5A3);
        boolean isCorrectFive = answerFive.isChecked();


        int numberOfQuestionsRight = 0;

        if (isCorrectOne && notCorrectTwo && !notCorrectThree) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        }

        if (isCorrectTwo.matches("network")) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        } else if (isCorrectTwo.matches("Network")) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        }
        if (isCorrectThree) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        }
        if (isCorrectFour) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        }
        if (isCorrectFive) {
            numberOfQuestionsRight = numberOfQuestionsRight + 1;
        }

        return numberOfQuestionsRight;
    }

    public void displayMessage(String message) {

        TextView testTextView = (TextView) findViewById(R.id.testResults);

        testTextView.setText(message);


        makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
