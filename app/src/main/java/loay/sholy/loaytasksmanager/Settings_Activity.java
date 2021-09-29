package loay.sholy.loaytasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Settings_Activity extends AppCompatActivity {

    private RadioGroup rgEndedTasks;
    private RadioButton radiobtn_delete,radiobtn2_cross_line,radiobtn3_move_to_end;
    private Button btnClean,btn2_Signout;
    private TextView tvEnded,tvSign;
    private ToggleButton btnonoff;
    private Switch swKeephistory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        rgEndedTasks=findViewById(R.id.rgEndedTasks);
        radiobtn_delete=findViewById(R.id.radiobtn_delete);
        radiobtn2_cross_line=findViewById(R.id.radiobtn2_cross_line);
        radiobtn3_move_to_end=findViewById(R.id.radiobtn3_move_to_end);
        btnClean=findViewById(R.id.btnClean);
        btn2_Signout=findViewById(R.id.btn2_Signout);
        tvEnded=findViewById(R.id.tvEnded);
        tvSign=findViewById(R.id.tvsign);
        btnonoff=findViewById(R.id.btnonoff);
        swKeephistory=findViewById(R.id.swKeephistory);
    }
}