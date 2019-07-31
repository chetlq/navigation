package com.example.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link NestedFragment1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link NestedFragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NestedFragment1 extends Fragment {

    public NestedFragment1() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
//        NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
//        navController.popBackStack();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_nested_fragment1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
        Button button = (Button) view.findViewById(R.id.nested_button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                navController.navigate(R.id.action_nestedFragment1_to_nestedFragment2);

            }
        });
        requireActivity().getOnBackPressedDispatcher().addCallback(getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
//                        System.exit(0);

                        navController.popBackStack(R.id.action_nestedFragment1_to_nestedFragment2, false);
                    }
                });
    }
}