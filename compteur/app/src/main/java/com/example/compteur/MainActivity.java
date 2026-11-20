package com.example.compteur;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int count = 0;
    private TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
        }

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(48, 48, 48, 48);

        counterText = new TextView(this);
        counterText.setTextSize(72);
        counterText.setGravity(Gravity.CENTER);
        updateText();

        Button plus = new Button(this);
        plus.setText("+1");
        plus.setOnClickListener(v -> {
            count++;
            updateText();
        });

        Button reset = new Button(this);
        reset.setText("Reset");
        reset.setOnClickListener(v -> {
            count = 0;
            updateText();
        });

        ViewGroup.LayoutParams wrap = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        layout.addView(counterText, wrap);
        layout.addView(plus, wrap);
        layout.addView(reset, wrap);

        setContentView(layout);
    }

    private void updateText() {
        counterText.setText(String.valueOf(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count", count);
    }
}
