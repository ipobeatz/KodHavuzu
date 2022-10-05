package com.ibrahimcakir.kodhavuzu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.ibrahimcakir.kodhavuzu.Model.QuestionsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class TestScreen extends AppCompatActivity {

    EditText question;
    EditText aText;
    EditText bText;
    EditText cText;
    EditText dText;
    JSONArray jsonArray;

    RadioButton aRadio;
    RadioButton bRadio;
    RadioButton cRadio;
    RadioButton dRadio;

    int currentQuestion = 1;
    int previousQuestion = 1;
    TextView questionNumber;
    CardView nextQuestions, saveButton, backButton;
    String selectedOption = "";
    ArrayList<QuestionsModel> ques;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_test_screen);

        aRadio = findViewById(R.id.aRadio);
        bRadio = findViewById(R.id.bRadio);
        cRadio = findViewById(R.id.cRadio);
        dRadio = findViewById(R.id.dRadio);
        aText = findViewById(R.id.aText);
        bText = findViewById(R.id.bText);
        cText = findViewById(R.id.cText);
        dText = findViewById(R.id.dText);

        question = findViewById(R.id.questionView);
        currentQuestion = 1;
        questionNumber = findViewById(R.id.questionNumber);
        nextQuestions = findViewById(R.id.nextQuestions);
        saveButton = findViewById(R.id.saveButton);
        backButton = findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (previousQuestion > 1) {
                    previousQuestion--;
                    setAllData(previousQuestion);
                }
                if (previousQuestion == 1)
                    backButton.setVisibility(View.INVISIBLE);

                Toast.makeText(TestScreen.this, String.valueOf(previousQuestion), Toast.LENGTH_SHORT).show();
            }
        });


        nextQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (previousQuestion != currentQuestion) {
                    previousQuestion++;
                    if (previousQuestion != currentQuestion)
                        setAllData(previousQuestion);
                    else {
                        clearAllData();
                        questionNumber.setText(String.valueOf(currentQuestion));
                    }
                    if (previousQuestion > 1)
                        backButton.setVisibility(View.VISIBLE);
                }
            }
        });

        boolean cont = getEnteredQuestionsValue();
        if (cont) {
            previousQuestion++;
            currentQuestion++;
            Toast.makeText(TestScreen.this, "QUESTION " + currentQuestion, Toast.LENGTH_SHORT).show();
            questionNumber.setText(String.valueOf(currentQuestion));
            clearAllData();
            backButton.setVisibility(View.VISIBLE);
        }

    }

    public void setAllData(int position) {
        clearAllData();
        QuestionsModel question1 = new QuestionsModel();
        question1 = ques.get(position-1);
        questionNumber.setText(String.valueOf(question1.getId()));
        question.setText(question1.getQuestion());
        aText.setText(question1.getOpt_A());
        bText.setText(question1.getOpt_B());
        cText.setText(question1.getOpt_C());
        dText.setText(question1.getOpt_D());
        switch (question1.getAnswer()){
            case "A":
                aRadio.setChecked(true);
                break;
            case "B":
                bRadio.setChecked(true);
                break;
            case "C":
                cRadio.setChecked(true);
                break;
            case "D":
                dRadio.setChecked(true);
                break;
        }
    }



    private void clearAllData() {

        aRadio.setChecked(false);
        bRadio.setChecked(false);
        cRadio.setChecked(false);
        dRadio.setChecked(false);
        aText.setText(null);
        bText.setText(null);
        cText.setText(null);
        dText.setText(null);
        question.setText(null);
        selectedOption = "";
    }

    private boolean getEnteredQuestionsValue() {
        boolean cont = false;
        if (TextUtils.isEmpty(question.getText().toString().trim())) {
            question.setError("Please fill in a question");
        } else if (TextUtils.isEmpty(aText.getText().toString().trim())) {
            aText.setError("Please fill in option A");
        } else if (TextUtils.isEmpty(bText.getText().toString().trim())) {
            bText.setError("Please fill in option B");
        } else if (TextUtils.isEmpty(cText.getText().toString().trim())) {
            cText.setError("Please fill in option C");
        } else if (TextUtils.isEmpty(dText.getText().toString().trim())) {
            dText.setError("Please fill in option D");
        } else if (selectedOption.equals("")) {
            Toast.makeText(this, "Please select the correct answer", Toast.LENGTH_SHORT).show();
        } else {
            QuestionsModel quest = new QuestionsModel();
            quest.setId(currentQuestion);
            quest.setQuestion(question.getText().toString());
            quest.setOpt_A(aText.getText().toString());
            quest.setOpt_B(bText.getText().toString());
            quest.setOpt_C(cText.getText().toString());
            quest.setOpt_D(dText.getText().toString());
            quest.setAnswer(selectedOption);
            ques.add(quest);
            cont = true;

            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("answer", selectedOption);
                jsonObject.put("opt_A", aText.getText().toString().trim());
                jsonObject.put("opt_B", bText.getText().toString().trim());
                jsonObject.put("opt_C", cText.getText().toString().trim());
                jsonObject.put("opt_D", dText.getText().toString().trim());
                jsonObject.put("question", question.getText().toString().trim());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            jsonArray.put(jsonObject);
        }
        return cont;
    }

    public void updateData(int position) {
        QuestionsModel question1 = new QuestionsModel();
        question1 = ques.get(position-1);
    }
            }
