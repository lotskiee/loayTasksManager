package loay.sholy.loaytasksmanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;

//1. وضع فئة المازين
public class MainActivity extends AppCompatActivity implements DialogInterface.OnClickListener {

    private FloatingActionButton FloatingActionButton2;
    private SearchView svSearchTask;
    private ListView lvAllTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton2 = findViewById(R.id.floatingActionButton2);
        svSearchTask = findViewById(R.id.svSearch);
        lvAllTasks = findViewById(R.id.lvAllTasks);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.History) {
            Intent i = new Intent(getApplicationContext(), History_Activity.class);
            startActivity(i);

        }
        if (item.getItemId() == R.id.Settings)
        {
            Intent i= new Intent(getApplicationContext(),Settings_Activity.class);
            startActivity(i);
        }
        if (item.getItemId() == R.id.SignOut)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure?");
        builder.setCancelable(true);// تسكير الديالوج في ضغطة على ال "back" أو ما يشابه
              // listener 3.   add listener to the buttons
        builder.setPositiveButton("YES",  this);
        builder.setNegativeButton("NO",  this);
        AlertDialog dialog=builder.create();
        dialog.show();



        }
        return true;
    }

    /**
     * event handler
     * @param dialogInterface the active dialog
     * @param Which the button id which cause the event
     */

    // listener 2. implement method
    @Override
    public void onClick(DialogInterface dialogInterface, int Which) {
        // listener 4. react for each action
        if (Which==dialogInterface.BUTTON_POSITIVE)
        {
            Toast.makeText(getApplicationContext(), "Loging out", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
            // تسجيل الخروج
            FirebaseAuth auth=FirebaseAuth.getInstance();
            auth.signOut();
            finish();//to close the current activity
        }
        if (Which==dialogInterface.BUTTON_NEGATIVE)
        {
            Toast.makeText(getApplicationContext(), "Loging out canceled", Toast.LENGTH_SHORT).show();
            dialogInterface.cancel();
        }
    }
}