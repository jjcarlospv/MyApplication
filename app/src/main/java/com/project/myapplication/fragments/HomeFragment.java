package com.project.myapplication.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.project.myapplication.R;

public class HomeFragment extends Fragment {

    private View view;
    private Button btn1;
    private homeInterface homeInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btn1 = view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getActivity(), "Hola from HomeFragment", Toast.LENGTH_SHORT).show();
                if(homeInterface != null)
                    homeInterface.getData();
            }
        });
    }

    public interface homeInterface{
        void getData();
    }

    public void setHomeInterface(HomeFragment.homeInterface homeInterface) {
        this.homeInterface = homeInterface;
    }
}
