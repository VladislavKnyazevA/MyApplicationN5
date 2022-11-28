package com.vladislavknyazev.myapplicationn5;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vladislavknyazev.myapplicationn4.R;

import java.util.zip.Inflater;

public class FragmentOne extends Fragment implements View.OnClickListener {

    public EditText etNum1;
    public EditText etNum2;

    public Button btnAdd;
    public Button btnSub;
    public Button btnMul;
    public Button btnDiv;
    public Button btnRad;
    public Button btnFract;

    public TextView tvResult;

    public String oper = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        etNum1 = (EditText) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.etNum1);
        etNum2 = (EditText) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.etNum2);

        btnAdd = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnAdd);
        btnSub = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnSub);
        btnMul = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnMul);
        btnDiv = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnDiv);
        btnRad = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnRad);
        btnFract = (Button) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.btnFract);

        tvResult = (TextView) inflater.inflate(R.layout.fragment_one, container, false).findViewById(R.id.tvResult);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnRad.setOnClickListener(this);
        btnFract.setOnClickListener(this);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = Navigation.findNavController(view);
        Button button = view.findViewById(R.id.btnNext);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_fragmentOne_to_fragmentTwo);
            }
        });
    }

    @Override
    public void onClick(View view) {
        double num1 = 0;
        double num2 = 0;
        double result = 0;

        if (TextUtils.isEmpty(etNum1.getText().toString())
                || TextUtils.isEmpty(etNum2.getText().toString())) {
            return;
        }

        num1 = Float.parseFloat(etNum1.getText().toString());
        num2 = Float.parseFloat(etNum2.getText().toString());

        switch (view.getId()) {
            case R.id.btnAdd:
                Toast.makeText(getActivity(), "Long pressing", Toast.LENGTH_SHORT).show();
                oper = "+";
                result = num1 + num2;
                tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                break;
            case R.id.btnSub:
                oper = "-";
                result = num1 - num2;
                tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                break;
            case R.id.btnMul:
                oper = "*";
                result = num1 * num2;
                tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                break;
            case R.id.btnDiv:
                oper = "/";
                result = num1 / num2;
                tvResult.setText(num1 + " " + oper + " " + num2 + " = " + result);
                break;
            case R.id.btnRad:
                oper = "√";
                result = Math.sqrt(num1);
                tvResult.setText(oper + " = " + result);
                break;
            case R.id.btnFract:
                oper = "1/x";
                result = 1 / num1;
                tvResult.setText( oper + " = " + result);
                break;
            default:
                break;
        }
    }
}