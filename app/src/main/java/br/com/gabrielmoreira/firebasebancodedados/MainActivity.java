package br.com.gabrielmoreira.firebasebancodedados;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //FirebaseApp.initializeApp(this);
        //firebaseDatabase = FirebaseDatabase.getInstance();
        //databaseReference = firebaseDatabase.getReference();
        //databaseReference.child("Pessoa").child("33569921808").setValue("Gabriel");
        //databaseReference.child("Pessoa").child("33569921888").setValue("Teste");
        //databaseReference.child("Pessoa").child("33569921899").setValue("Teste2");
        //databaseReference.child("Pessoa").child("33569921801").setValue("Gabriel11");
        //databaseReference.child("Pessoa").child("33569921882").setValue("Teste22");
        //databaseReference.child("Pessoa").child("33569921893").setValue("Teste233");


        FirebaseStorage storage = FirebaseStorage.getInstance();
        // Create a storage reference from our app
        //StorageReference storageRef = storage.getReference();

        // Create a child reference
        // imagesRef now points to "images"
        //StorageReference imagesRef = storageRef.child("images");

        // Child references can also take paths
        // spaceRef now points to "images/space.jpg
        // imagesRef still points to "images"
        //StorageReference spaceRef = storageRef.child("images/space.jpg");

        StorageReference storageRef = storage.getReference();
        //StorageReference montainRef = storageRef.child("teste.jpg");

        //StorageReference montainImageRef = storageRef.child("ApoliceVida/teste.jpg");


        Uri file = Uri.fromFile(new File("C:/Users/gabriel.moreira/Pictures/backgroundDefault.jpg"));
        StorageReference riversRef = storageRef.child("ApoliceVida/"+file.getLastPathSegment());
        UploadTask uploadTask = riversRef.putFile(file);

        // Register observers to listen for when the download is done or if it fails
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });




    }
}
