package com.example.myapplicationfragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IFragment {
    private FragmentManager manager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
    }

    public void addA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.newFragment, fragmentA, "fragA");
        transaction.commit();

    }

    public void addB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.newFragment, fragmentB, "fragB");
        transaction.commit();
    }

    public void removeA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A is not created", Toast.LENGTH_LONG).show();
        }

    }

    public void replaceBwithA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.newFragment, fragmentA, "fragA");
        transaction.commit();
    }

    public void hideB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();

        if (fragmentB != null) {
            transaction.hide(fragmentB);
            transaction.commit();
        } else {
            Toast.makeText(this, "не создан фрагмент Б", Toast.LENGTH_LONG).show();
        }
    }

    public void showB(View view) {
        FragmentB fragmentB = (FragmentB) manager.findFragmentByTag("fragB");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentB != null) {
            transaction.show(fragmentB);
            transaction.commit();
        } else {
            Toast.makeText(this, "не создан фрагмент Б", Toast.LENGTH_LONG).show();
        }
    }

    public void attachA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.attach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "не создан фргамент А", Toast.LENGTH_LONG).show();
        }
    }

    public void deAttachA(View view) {
        FragmentA fragmentA = (FragmentA) manager.findFragmentByTag("fragA");
        FragmentTransaction transaction = manager.beginTransaction();
        if (fragmentA != null) {
            transaction.detach(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A bulunamadı", Toast.LENGTH_LONG).show();
        }
    }
}


//    @Override
//    public void hideFragment() {
//        TextFragment textFragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragmentText);
//        transaction = fragmentManager.beginTransaction();
//        if(textFragment!=null){
//            transaction.hide(textFragment);
//            transaction.commit();}
//    }




