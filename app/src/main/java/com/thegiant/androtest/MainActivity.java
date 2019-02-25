package com.thegiant.androtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnMin,btnPlus,btnOrder,btnReset;
    private CheckBox cbCream,cbChoco;
    private TextView quantity;
    private int cofffee=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMin=findViewById(R.id.btn_down);
        btnPlus=findViewById(R.id.btn_up);
        btnOrder=findViewById(R.id.btn_order);
        btnReset=findViewById(R.id.btn_reset);

        cbChoco=findViewById(R.id.cb_choco);
        cbCream=findViewById(R.id.cb_cream);

        quantity=findViewById(R.id.tv_quantity);

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cbChoco.setEnabled(false);
                cbCream.setEnabled(false);
                quantity.setText("0");

            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(quantity.getText().toString());
                cofffee=cofffee*i;

                if (cbCream.isChecked()&&cbChoco.isChecked()){
                    cofffee=cofffee*i*10;
                }

                if (cbCream.isChecked()||cbChoco.isChecked()){
                    cofffee=cofffee*i*5;
                }

                Toast.makeText(MainActivity.this, "You ordered "+quantity.getText().toString()+" Coffee!" +
                                "\nYour cost is"+String.valueOf(cofffee)
                        , Toast.LENGTH_SHORT).show();
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(quantity.getText().toString());
                i++;
                quantity.setText(String.valueOf(i));

            }
        });

        btnMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i=Integer.parseInt(quantity.getText().toString());
                i--;
                quantity.setText(String.valueOf(i));
            }
        });
    }
}
