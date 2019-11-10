package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonDobas;
    private ImageView imageViewJatekos, imageViewGep;
    private TextView textViewEredmeny;
    private int jatekosDobas, gepDobas, jatekosPont, gepPont;
    private AlertDialog alertDialog;
    private AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                jatekosDobas = random.nextInt(7);
                gepDobas = random.nextInt(7);
                switch (jatekosDobas)
                {
                    case 1:
                        imageViewJatekos.setImageResource(R.drawable.kocka1);
                        jatekosDobas = 1;
                        break;
                    case 2:
                        imageViewJatekos.setImageResource(R.drawable.kocka2);
                        jatekosDobas = 2;
                        break;
                    case 3:
                        imageViewJatekos.setImageResource(R.drawable.kocka3);
                        jatekosDobas = 3;
                        break;
                    case 4:
                        imageViewJatekos.setImageResource(R.drawable.kocka4);
                        jatekosDobas = 4;
                        break;
                    case 5:
                        imageViewJatekos.setImageResource(R.drawable.kocka5);
                        jatekosDobas = 5;
                        break;
                    case 6:
                        imageViewJatekos.setImageResource(R.drawable.kocka6);
                        jatekosDobas = 6;
                        break;
                }

                switch (gepDobas)
                {
                    case 1:
                        imageViewGep.setImageResource(R.drawable.kocka1);
                        gepDobas = 1;
                        break;
                    case 2:
                        imageViewGep.setImageResource(R.drawable.kocka2);
                        gepDobas = 2;
                        break;
                    case 3:
                        imageViewGep.setImageResource(R.drawable.kocka3);
                        gepDobas = 3;
                        break;
                    case 4:
                        imageViewGep.setImageResource(R.drawable.kocka4);
                        gepDobas = 4;
                        break;
                    case 5:
                        imageViewGep.setImageResource(R.drawable.kocka5);
                        gepDobas = 5;
                        break;
                    case 6:
                        imageViewGep.setImageResource(R.drawable.kocka6);
                        gepDobas = 6;
                        break;
                }
                if (jatekosDobas>gepDobas)
                {
                    jatekosPont++;
                    if (jatekosPont == 3)
                    {
                        //Üzenet beállítás
                        alertDialogBuilder.setMessage("Játékos nyert! Akarsz újat dobni?");
                        //alertDialot értékadás
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                if (jatekosDobas<gepDobas)
                {
                    gepPont++;
                    if (gepPont == 3)
                    {
                        //Üzenet beállítás
                        alertDialogBuilder.setMessage("Gép nyert! Akarsz újat dobni?");
                        //alertDialot értékadás
                        alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }
                }
                textViewEredmeny.setText("Eredmény:" + jatekosPont + "-" + gepPont);

            }
        });
    }

    public void init()
    {
        buttonDobas = findViewById(R.id.buttonDobas);
        imageViewJatekos = findViewById(R.id.imageViewJatekos);
        imageViewGep = findViewById(R.id.imageViewGep);
        textViewEredmeny = findViewById(R.id.textViewEredmeny);
        jatekosDobas = 0;
        gepDobas = 0;
        jatekosPont = 0;
        gepPont = 0;

        alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        //Pozitív gomb elhelyezése =jobb oldali gomb
        alertDialogBuilder.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        //Negatív gomb elhelyezése =bal oldali gomb
        alertDialogBuilder.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                jatekosDobas = 0;
                gepDobas = 0;
                jatekosPont = 0;
                gepPont = 0;
                textViewEredmeny.setText("Eredmény:");
            }
        });
        //kilépés a dialogbox-ból
        alertDialogBuilder.setCancelable(false);
        //alertDialot értékadás
        alertDialog = alertDialogBuilder.create();

    }
}
