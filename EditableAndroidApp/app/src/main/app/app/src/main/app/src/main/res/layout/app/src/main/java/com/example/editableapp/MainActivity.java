package com.example.editableapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private EditText etEdit;
    private Button btnEdit;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
        etEdit = findViewById(R.id.etEdit);
        btnEdit = findViewById(R.id.btnEdit);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleEditMode();
            }
        });
    }

    private void toggleEditMode() {
        if (isEditMode) {
            // Save the edited text
            String newText = etEdit.getText().toString();
            tvDisplay.setText(newText);

            // Switch to view mode
            etEdit.setVisibility(View.GONE);
            tvDisplay.setVisibility(View.VISIBLE);
            btnEdit.setText("Edit");
        } else {
            // Switch to edit mode
            etEdit.setText(tvDisplay.getText().toString());
            etEdit.setVisibility(View.VISIBLE);
            tvDisplay.setVisibility(View.GONE);
            btnEdit.setText("Save");
        }
        isEditMode = !isEditMode;
    }
}
