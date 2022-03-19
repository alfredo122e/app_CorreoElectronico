package com.example.correoelectronico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText et_para, et_message, et_title;
    Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_para=findViewById(R.id.et_para);
        et_message=findViewById(R.id.et_message);
        et_title=findViewById(R.id.et_title);
        bt_send=findViewById(R.id.bt_send);



        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent (Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{et_para.getText().toString().trim()});
                intent.putExtra(Intent.EXTRA_SUBJECT,et_title.getText().toString().trim());
                intent.putExtra(Intent.EXTRA_TEXT,et_message.getText().toString().trim());

                startActivity(intent.createChooser(intent,"Elija un proveedor de correo"));
            }
        });
    }
}