package com.example.ihsan;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OnBoardingFragment4 extends Fragment {
ImageView imageView;
Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = (ViewGroup) inflater.inflate(R.layout.fragment_on_boarding4,container,false);
        button = root.findViewById(R.id.start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tovar();
            }
        });
        return root;
    }
    public void tovar(){
        Intent intent = new Intent(getActivity(),MainActivity.class);
        startActivity(intent);
    }

}
