package loay.sholy.loaytasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class add_Task_Activity extends AppCompatActivity {

    private Spinner spnAddTask;
    private Button btnSave;
    private ImageView imgAdd;
    private TextInputLayout etSubject;
    private TextInputEditText etTitle;
    private SeekBar sbTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        spnAddTask=findViewById(R.id.spnAddTask);
        btnSave=findViewById(R.id.btnSave);
        imgAdd=findViewById(R.id.imgAdd);
        etSubject=findViewById(R.id.etSubject);
        etTitle=findViewById(R.id.etTitle);
        sbTask=findViewById(R.id.sbTask);//
    }
}