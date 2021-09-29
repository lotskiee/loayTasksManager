package loay.sholy.loaytasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
        FloatingActionButton2=findViewById(R.id.floatingActionButton2);
        svSearchTask=findViewById(R.id.svSearch);
        lvAllTasks=findViewById(R.id.lvAllTasks);
    }
}