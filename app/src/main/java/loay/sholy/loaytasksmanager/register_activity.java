package loay.sholy.loaytasksmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register_activity extends AppCompatActivity {


    private TextInputEditText etConfirmpassword,etGmail,etPassword,etLastname,etFirstname;
    private Button btnCreate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etLastname=findViewById(R.id.etLastname);
        etFirstname=findViewById(R.id.etFirstname);
        etPassword=findViewById(R.id.etPassword);
        etGmail=findViewById(R.id.etGmail);
        etConfirmpassword=findViewById(R.id.etConfirmpassword);
        btnCreate=findViewById(R.id.btnCreate);

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    private void validate() {
        String email = etGmail.getText().toString();
        String pass1= etPassword.getText().toString();
        String pass2= etConfirmpassword.getText().toString();
        String firstname = etFirstname.getText().toString();
        String lastname= etLastname.getText().toString();

        boolean isOk=true;
        if(email.length()<5|| email.indexOf("@")<=0){
            etGmail.setError("wrong email syntax");
            isOk=false;
        }
        if (pass1.length()<8){
            etPassword.setError("at least 8 chars");
            isOk=false;
        }
        if (pass1.equals(pass2)==false){
            etConfirmpassword.setError("not equal passwords");
        }
        if (firstname.length()==0){
            etFirstname.setError("must enter full name");
            isOk=false;
        }
        if (lastname.length()==0){
            etLastname.setError("must enter full last name");
            isOk=false;
        }
        if (isOk)  //isOk==true
        {
          createAccount(email,pass1);
        }

    }
    private void createAccount(String email,String pass1){
        FirebaseAuth auth=FirebaseAuth.getInstance();
        // request //wait for response
        auth.createUserWithEmailAndPassword(email,pass1).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()==true){
                    finish();
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
                else {
                    // dialog
                    Toast.makeText(getApplicationContext(), "Error create account"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}