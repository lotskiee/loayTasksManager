package loay.sholy.loaytasksmanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash_Screen_Activity extends AppCompatActivity {

    private ImageView imgSplash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imgSplash=findViewById(R.id.imgSplash);
        // thread#1
        Thread th=new Thread(){
            //thread#2
            @Override
            public void run() {
                // هنا المقطع الذي سيعمل بالتزامن مع مقاطع اخرى
                //thread#3
                int ms =3*1000;
                try {
                    sleep(ms);
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));// transfers from splash screen to main activity page.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //thread#4
        th.start();
    }
}