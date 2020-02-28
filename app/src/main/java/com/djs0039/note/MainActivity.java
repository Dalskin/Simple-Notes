package com.djs0039.note;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Context;


public class MainActivity extends AppCompatActivity {

    Button btnSave;

    EditText txtID;

    LinearLayout viewNotes;

    Context noteContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteContext = this;
        txtID = findViewById(R.id.txtID);
        viewNotes = findViewById(R.id.viewNotes);

        btnSave = findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final LinearLayout note = new LinearLayout(noteContext);
                EditText newNote = new EditText(noteContext);
                note.setOrientation(LinearLayout.VERTICAL);

                newNote.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newNote.setGravity(Gravity.CENTER);
                newNote.setText(txtID.getText());
                note.addView(newNote);
                viewNotes.addView(note);

                Button btnDelete = new Button(noteContext);
                btnDelete.setText("Delete");
                note.addView(btnDelete);

                btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                        public void onClick(View v){
                    viewNotes.removeView(note);
                }
            });
                txtID.setText("");
            }
        });

    }
}
