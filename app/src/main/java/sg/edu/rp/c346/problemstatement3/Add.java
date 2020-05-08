package sg.edu.rp.c346.problemstatement3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.ArrayList;

public class Add extends AppCompatActivity {
    int requestCodeForAddModule = 3;
    TextView week;
    Button submit;
    RadioGroup grade;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        submit = findViewById(R.id.buttonSubmit);
        grade = findViewById(R.id.RadioGroupGrade);
        week = findViewById(R.id.textViewWeek);

        Intent i = getIntent();
        final modules a = (modules) i.getSerializableExtra("module");
        final ArrayList<String> b = a.getDg();
        week.setText("Week " + (b.size() + 1));

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int gradeId = grade.getCheckedRadioButtonId();
                rb = findViewById(gradeId);
                String grade = rb.getText().toString();
                Intent intent = new Intent(Add.this, Info.class);
                ArrayList<String> b = a.getDg();
                b.add(grade);
                a.setDg(b);
                intent.putExtra("module", a);
                startActivityForResult(intent, requestCodeForAddModule);
            }
        });
    }
}
