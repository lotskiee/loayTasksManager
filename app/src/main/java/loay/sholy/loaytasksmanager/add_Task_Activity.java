package loay.sholy.loaytasksmanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import loay.sholy.loaytasksmanager.data.MyTask;

public class add_Task_Activity extends AppCompatActivity {

    private Spinner spnAddTask;
    private Button btnSave;
    private ImageView imgAdd;
    private TextInputEditText etTitle,etSubject;
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
        sbTask=findViewById(R.id.sbTask);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }
    private void validate()
    {
        String title=etTitle.getText().toString();
        String subject=etSubject.getText().toString();
        int progress = sbTask.getProgress();
        String importance=spnAddTask.getSelectedItem().toString();
        boolean isOk=true;
        if (title.length()==0)
        {
            etTitle.setError("must enter subject");
            isOk=false;
        }
        if (isOk)
        {
            MyTask myTask=new MyTask();
            myTask.setTitle(title);
            myTask.setSubject(subject);

            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            myTask.setOwner(uid);

            FirebaseDatabase db=FirebaseDatabase.getInstance();
            DatabaseReference ref = db.getReference();
            String key=ref.child("my tasks").push().getKey();
            myTask.setKey(key);
            //

            ref.child("my tasks").child(uid).child(key).setValue(myTask).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(getApplicationContext(), "Add successful", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Add not successful", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

}