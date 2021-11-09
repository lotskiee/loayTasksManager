package loay.sholy.loaytasksmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class Splash_Screen_Activity extends AppCompatActivity {

    private ImageView imgSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imgSplash=findViewById(R.id.imgSplash);
        Thread th=new Thread(){
            @Override
            public void run() {
                int i=3*1000;
                try {
                    sleep(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}