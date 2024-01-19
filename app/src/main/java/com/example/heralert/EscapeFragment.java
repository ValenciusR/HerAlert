package com.example.heralert;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EscapeFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class EscapeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Escape> escapeArrayList;
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EscapeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EscapeFragment newInstance(String param1, String param2) {
        EscapeFragment fragment = new EscapeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public EscapeFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        escapeArrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_escape, container, false);
        escapeArrayList.add(new Escape("What should a woman do if she finds herself alone in the company of a stranger male as she prepares to enter a deserted parking garage at night?", "Expert says: Walk confidently towards your destination, and if you feel uneasy, press your car's panic button. The loud alarm may deter any potential threats.", R.drawable.home));
        escapeArrayList.add(new Escape("What to do if a stranger approaches a woman while she is jogging alone in a quiet park?", "Expert says: Change your route and head towards a more populated area. Predators often avoid places with more people, reducing the risk of an attack.", R.drawable.shopping));
        escapeArrayList.add(new Escape("tips2", "By checking these aspects, you should be able to identify the issue. If the problem persists, you might want to provide more details about the ExcapeAdapter and excape classes so that I can offer more specific assistance.", R.drawable.home));
        escapeArrayList.add(new Escape("tips3", "By checking these aspects, you should be able to identify the issue. If the problem persists, you might want to provide more details about the ExcapeAdapter and excape classes so that I can offer more specific assistance.", R.drawable.home));
        escapeArrayList.add(new Escape("ti3", "By checking these aspects, you should be able to identify the issue. If the problem persists, you might want to provide more details about the ExcapeAdapter and excape classes so that I can offer more specific assistance.", R.drawable.shopping));
        escapeArrayList.add(new Escape("ti3", "By checking these aspects, you should be able to identify the issue. If the problem persists, you might want to provide more details about the ExcapeAdapter and excape classes so that I can offer more specific assistance.", R.drawable.home));
        escapeArrayList.add(new Escape("end of", "By checking these aspects, you should be able to identify the issue. If the problem persists, you might want to provide more details about the ExcapeAdapter and excape classes so that I can offer more specific assistance.", R.drawable.shopping));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEscape);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new EscapeAdapter(view.getContext(), escapeArrayList));
        return  view;
    }
}