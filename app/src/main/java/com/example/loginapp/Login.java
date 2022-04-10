package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
 private EditText email;
 private EditText password;
 private Button button;
    private String Email;
    private String Password;
    private TextView textViewcreateOne;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email=findViewById(R.id.editTextTextEmailAddress2);
        password=findViewById(R.id.editTextTextPassword3);
        mAuth= FirebaseAuth.getInstance();
      button=findViewById(R.id.button5);
      textViewcreateOne=findViewById(R.id.textView18);

      textViewcreateOne.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent=new Intent(Login.this, MainActivity.class);
              startActivity(intent);
          }
      });
        textViewcreateOne.setText(Html.fromHtml("<font color='blue'><u>Create One</u></font>"));


      button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String EMAIL=email.getText().toString();
                String PASS=password.getText().toString();
                Email=getIntent().getStringExtra("email");
                Password=getIntent().getStringExtra("password");
                if(Email.equals(EMAIL) && Password.equals(PASS)){
                  Intent intent=new Intent(Login.this, Dashboard.class);
                  startActivity(intent);
                   finish();}
                else{
                    Toast.makeText(Login.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

//       String EMAIL=email.getText().toString();
//       String PASS=password.getText().toString();
//       Email=getIntent().getStringExtra("email");
//       Password=getIntent().getStringExtra("password");
//       if(EMAIL.equals(Email) && PASS.equals(Password)){
//             login();
//           mAuth.signInWithEmailAndPassword(Email,Password)
//                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                       @Override
//                       public void onComplete(@NonNull Task<AuthResult> task) {
//                           if (task.isSuccessful()) {
//                               // Sign in success, update UI with the signed-in user's information
//
//                               FirebaseUser user = mAuth.getCurrentUser();
//                               user=task.getResult().getUser();
//                           } else {
//                               // If sign in fails, display a message to the user.
//
//                               Toast.makeText(Login.this, "Authentication failed.",
//                                       Toast.LENGTH_SHORT).show();
////                               updateUI(null);
//                           }
//                       }
//                   });
//             Intent intent=new Intent(Login.this, Dashboard.class);
//             startActivity(intent);
//           }
//       else {
//           Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show();
//       }
//       }
//
//    private void login() {
//
////        public void onStart()   {
//            super.onStart();
//            FirebaseUser currentUser = mAuth.getCurrentUser();
//            if(currentUser != null){
//                currentUser.reload();
//            }
//
//
//    }
}}

