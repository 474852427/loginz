package com.example.wlw.qqlogin;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LoginActivity extends AppCompatActivity {

public static final class Data {
    public static final String[][] USER =

            {
                    {
                            "1001", "111", "0"
                    },
                    {
                            "1002", "111", "1"
                    },
                    {
                            "1003", "111", "2"
                    }
            };

}





    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button=(Button)findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number=((EditText)findViewById(R.id.user)).getText().toString();
                String pwd=((EditText)findViewById(R.id.pwd)).getText().toString();
                String index="";
                boolean flag=false;
                for (int i = 0; i<Data.USER.length; i++){
if (number.equals(Data.USER[i][0])){
    if (pwd.equals(Data.USER[i][1])){

        index=Data.USER[i][2];
        flag=true;
        break;
    }

}

                }
                if (flag){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    Bundle bundle=new Bundle();
                    bundle.putInt("index",Integer.parseInt(index));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }else {
                    Toast toast=Toast.makeText(LoginActivity.this,"账号或密码有误",Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM,0,0);
                    toast.show();
                }
            }
        });




    }
}
