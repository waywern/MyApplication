package com.waywern.myapplication;

import android.support.v7.app.AppCompatActivity;
    import android.os.Bundle;
import android.util.Log;
import android.view.View;
    import android.widget.Button;
    import android.widget.TextView;
    import android.widget.Toast;

    public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Button mPreviouseButton;
    private TextView mQuestionTextView;
    private TrueFalse[] mQuestionBank = new TrueFalse[] {
                    new TrueFalse(R.string.question_oceans, true),
                    new TrueFalse(R.string.question_mideast, false),
                    new TrueFalse(R.string.question_africa, false),
                    new TrueFalse(R.string.question_americas, true),
                    new TrueFalse(R.string.question_asia, true),
            };
    private int mCurrentIndex = 0;
    private String TAG = "MainActivity";

            @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_main);

        mTrueButton = (Button)findViewById(R.id.true_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        checkAnswer(true);
                    }
            });

        mFalseButton = (Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        checkAnswer(false);
                    }
            });

        mQuestionTextView = (TextView)findViewById(R.id.question_textView);
        updatequestion();

        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                        mCurrentIndex = (mCurrentIndex  + 1) % mQuestionBank.length;
                        updatequestion();
                    }
            });
        mPreviouseButton  = (Button)findViewById(R.id.previouse_button);
        mPreviouseButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(mCurrentIndex == 0)
                    mCurrentIndex = mQuestionBank.length-1;
                else
                    mCurrentIndex = mCurrentIndex  - 1;
                updatequestion();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }
    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    public void updatequestion() {
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);
    }
    public void checkAnswer(boolean answer)
    {
        int pointer_to_text;
        if(answer == mQuestionBank[mCurrentIndex].isAnswer())
                pointer_to_text = R.string.correct_toast;
        else
            pointer_to_text = R.string.incorrect_toast;
        Toast.makeText(MainActivity.this, pointer_to_text, Toast.LENGTH_SHORT).show();
    }
}
