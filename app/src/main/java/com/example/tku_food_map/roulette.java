package com.example.tku_food_map;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class roulette extends AppCompatActivity {

    private String[] favorList = {"便當","義大利麵","漢堡","速食","火鍋","水餃","早餐店", "飯卷", "便利商店"};
    private boolean[] checkedList = new boolean[favorList.length];
    int[] textViewId = new int[] {R.id.Green, R.id.DarkBlue, R.id.Orange, R.id.Gray, R.id.Yellow, R.id.LiteBlue};
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_roulette);

        final boolean[] tmp = new boolean[favorList.length];
        System.arraycopy(checkedList, 0, tmp, 0, checkedList.length);

        Button btnSpin = findViewById(R.id.btn_spin);
        ImageButton btnBack = findViewById(R.id.btnBack);
        ImageView imgWheel = findViewById(R.id.img_wheel);
        TextView foodName = findViewById(R.id.tv_eatWhat);
        Button btn = findViewById(R.id.favorList);
        LayoutInflater layoutInflater = LayoutInflater.from(roulette.this);
        View list = layoutInflater.inflate(R.layout.list, null);

        AlertDialog dialog = new AlertDialog.Builder(roulette.this)
                .setTitle("請選擇最想吃的6種食物 :")
                .setMultiChoiceItems(favorList, tmp, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                        if (b){
                            a++;
                        }else
                            a--;
                    }
                })
                .setPositiveButton("確定變更", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int j = 0;
                        System.arraycopy(tmp, 0, checkedList, 0, tmp.length);
                        for (int ii = 0; ii < favorList.length; ii++) {
                            if (checkedList[ii] && j < 6) {
                                TextView msg = findViewById(textViewId[j]);
                                msg.setText(favorList[ii]);
                                j++;
                            }
                        }
                        Toast.makeText(roulette.this, "儲存變更!",Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                }).show();
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int stop = (int)(Math.random() * 360);
                Animation amSpin = new RotateAnimation(0f, stop + 3600,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
                amSpin.setDuration(3000);
                amSpin.setFillAfter(true);

                imgWheel.startAnimation(amSpin);

                if (stop % 360 <= 60){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.Gray);
                            String msg = t.getText().toString();
                            foodName.setText("吃"+ msg );
                        }
                    },3000);
                }
                else if (stop % 360 > 60 && stop % 360 <= 120){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.Orange);
                            String msg = t.getText().toString();
                            foodName.setText("吃"+ msg );
                        }
                    },3000);
                }
                else if (stop % 360 > 120 && stop % 360 <= 180){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.DarkBlue);
                            String msg = t.getText().toString();
                            foodName.setText("吃" + msg);

                        }
                    },3000);
                }
                else if (stop % 360 > 180 && stop % 360 <= 240){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.Green);
                            String msg = t.getText().toString();
                            foodName.setText("吃"+ msg);

                        }
                    },3000);
                }
                else if (stop % 360 > 240 && stop % 360 <= 300){
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.LiteBlue);
                            String msg = t.getText().toString();
                            foodName.setText("吃"+msg);

                        }
                    },3000);
                }
                else
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            TextView t = findViewById(R.id.Yellow);
                            String msg = t.getText().toString();
                            foodName.setText("吃"+ msg );

                        }
                    },3000);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMA = new Intent(roulette.this, MainActivity.class);
                startActivity(goMA);
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });
    }
}