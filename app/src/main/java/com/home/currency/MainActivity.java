package com.home.currency;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText ed_ntd;
    private TextView jpd;
    private TextView usd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed_ntd = findViewById(R.id.ed_ntd);
        usd = findViewById(R.id.us_doller);
        jpd = findViewById(R.id.jp_doller);

    }


    public void result(View view){   //onclick時傳入值的規範，需傳入View view

        Intent intent = new Intent(this, resultActivity.class);
        startActivity(intent);

        //alert dialog對話框
        /*result.setText(getString(R.string.your_bmi_is)+bmi);
        new AlertDialog.Builder(this)
                .setTitle(R.string.bmi)
                .setMessage(getString(R.string.your_bmi_is)+bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {  //對話框按鈕
                    @Override
                    public void onClick(DialogInterface dialog, int which) {   //匿名類別(原本listen是null)
                        edHeight.setText("");
                        edWeight.setText("");
                    }
                })
                .show();*/
    }
    public void change(View view){

        String ntd = ed_ntd.getText().toString();
        float n = Float.parseFloat(ntd);
        float usc = n / 30.9f;
        float jpc = n / 0.27f;
        if (n > 0f) {
            new AlertDialog.Builder(this)
                    .setTitle(R.string.result)
                    .setMessage(getString(R.string.us) + "  "+usc +"\n"+getString(R.string.jp)+"   "+jpc)
                    .setPositiveButton(R.string.ok, null)
                    .show();
            jpd.setText("" + jpc);
            usd.setText("" + usc);
        }
        if(n<=0f){
            new AlertDialog.Builder(this)
                    .setTitle(R.string.problem)
                    .setMessage(R.string.please_enter_ntd_amout)
                    .setPositiveButton(R.string.ok,null)
                    .show();
        }
    }
}
