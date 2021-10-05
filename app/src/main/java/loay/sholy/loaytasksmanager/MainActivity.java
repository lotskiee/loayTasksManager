package loay.sholy.loaytasksmanager;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

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
        builder.setCancelable(false);
        builder.setPositiveButton("YES",this);
        builder.setNegativeButton("NO", (DialogInterface.OnClickListener) this);
        AlertDialog dialog=builder.create();
        dialog.show();
            Intent i = new Intent(getApplicationContext(), Sign_in_activity.class);
            startActivity(i);


        }
        return true;
    }

}