package com.an2t.beforetestonlyjava.add;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.an2t.beforetestonlyjava.db.AppDatabase;
import com.an2t.beforetestonlyjava.R;
import com.an2t.beforetestonlyjava.User;

public class AddUserActivity extends AppCompatActivity {


    private EditText in_username;
    private EditText in_email;
    private Button btn_add_user;

    public static AppDatabase mDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);


        mDb = Room
                .databaseBuilder(getApplicationContext(), AppDatabase.class, "user_db")
                .allowMainThreadQueries()
                .build();

        in_email = findViewById(R.id.in_email);
        in_username = findViewById(R.id.in_username);
        btn_add_user =  findViewById(R.id.btn_add_user);

        btn_add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = in_email.getText().toString();
                String username = in_username.getText().toString();

                User u = new User();
                u.setEmail(email);
                u.setName(username);

                mDb.userDao().addUser(u);

                Toast.makeText(AddUserActivity.this, "User Added Successfully", Toast.LENGTH_SHORT).show();
                in_email.setText("");
                in_username.setText("");
                in_username.requestFocus();



            }
        });

    }
}
