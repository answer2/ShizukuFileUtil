package dev.answer.readdata;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.log);

    }

    public void load(View v) {
        if (Exec.checkPermission(10086)) {
            // For Test
            ShizukuFileUtil.write("/sdcard/Android/data/test.txt", "just for test");
            text.setText( ShizukuFileUtil.exist("/sdcard/Android/data/com.mojang.minecraftpe/")+"   " +ShizukuFileUtil.read("/sdcard/Android/data/test.txt"));
        } else {
            Log.d("logg", "errro: run shizuku fail!!!!");
        }
    }

    

}
