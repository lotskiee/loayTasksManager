package loay.sholy.loaytasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

public class History_Activity extends AppCompatActivity {

    private ListView lstHistory;
    private SearchView svSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        lstHistory=findViewById(R.id.lstHistory);
        svSearch=findViewById(R.id.svSearch);
    }
}