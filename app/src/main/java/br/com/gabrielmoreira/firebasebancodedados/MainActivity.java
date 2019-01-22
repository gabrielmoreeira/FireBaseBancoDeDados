package br.com.gabrielmoreira.firebasebancodedados;

import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatabase = FirebaseDatabase.getInstance().getReference();

        //writeNewUser("38690876847","Haline Bazan Pereira Moreira","haline@tste.com.br");

        /**
         * Método abaixo passa a chave o nome do filho que precis alterar e o valor que novo
         */
        mDatabase.child("users").child("33569921808").child("username").setValue("Heber Pereira");


//        FirebaseApp.initializeApp(this);
//        firebaseDatabase = FirebaseDatabase.getInstance();
//        databaseReference = firebaseDatabase.getReference();
//
//
//        databaseReference.child("Pessoa").child("33569921808").setValue("Gabriel");
//        databaseReference.child("Pessoa").child("33569921888").setValue("Teste");
//        databaseReference.child("Pessoa").child("33569921899").setValue("Teste2");
//        databaseReference.child("Pessoa").child("33569921801").setValue("Gabriel11");
//        databaseReference.child("Pessoa").child("33569921882").setValue("Teste22");
//        databaseReference.child("Pessoa").child("33569921893").setValue("Teste233");

    }

    private void writeNewUser(String userId, String name , String email){

        User user = new User(name,email);

        mDatabase.child("users").child(userId).setValue(user);

    }




}
