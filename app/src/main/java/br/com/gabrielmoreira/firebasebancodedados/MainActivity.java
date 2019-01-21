package br.com.gabrielmoreira.firebasebancodedados;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        databaseReference.child("Pessoa").child("33569921808").setValue("Gabriel");
        databaseReference.child("Pessoa").child("33569921888").setValue("Teste");
        databaseReference.child("Pessoa").child("33569921899").setValue("Teste2");
        databaseReference.child("Pessoa").child("33569921801").setValue("Gabriel11");
        databaseReference.child("Pessoa").child("33569921882").setValue("Teste22");
        databaseReference.child("Pessoa").child("33569921893").setValue("Teste233");

    }
}
