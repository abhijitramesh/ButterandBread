package com.example.android.butterbread;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TimelineActivity extends AppCompatActivity {
    @BindView(R.id.Menu1)
    TextView _menu1;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_timeline);
        ButterKnife.bind(this);
        _menu1.setText("\n" +
                "  1.  Preheat oven to 190 C / Gas mark 5. Lightly grease a baking dish.\n" +
                "  2.  Mix together the sugar and cinnamon.\n" +
                "  3. Butter 5 slices of bread, cut in half.\n" +
                "  4. Layer the bread in the dish adding a handful of sultanas and the sugar mix as you go, covering each slice.\n" +
                "  5. Mix the milk and eggs together and whisk.\n" +
                "  6. Pour over the bread and leave to absorb for 10 minutes.\n" +
                "  7. Bake in the oven for 35 to 45 minutes, until the pudding is set and browned.\n");
    }
}
