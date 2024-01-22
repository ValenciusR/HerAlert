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
 * Use the {@link SelfDefenseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelfDefenseFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<SelfDefense> selfDefenses;
    private String mParam1;
    private String mParam2;


    public SelfDefenseFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelfDefenseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelfDefenseFragment newInstance(String param1, String param2) {
        SelfDefenseFragment fragment = new SelfDefenseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        selfDefenses = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_self_defense, container, false);
        selfDefenses.add(new SelfDefense( "Self-defense training provides women with the skills and techniques needed to protect themselves from potential threats and physical harm, enhancing overall personal safety.", R.drawable.selfdefense1));
        selfDefenses.add(new SelfDefense("Learning self-defense builds confidence and self-assurance. Knowing that you have the ability to defend yourself if necessary contributes to a stronger sense of empowerment.u", R.drawable.selfdefense2));
        selfDefenses.add(new SelfDefense("Self-defense training emphasizes situational awareness and the ability to recognize and avoid potentially dangerous situations", R.drawable.selfdefense3));
        selfDefenses.add(new SelfDefense( "Many self-defense techniques involve physical activity, contributing to improved overall fitness. Regular practice enhances strength, flexibility, and stamina, promoting a healthy lifestyle.", R.drawable.selfdefense4));
        selfDefenses.add(new SelfDefense("Self-defense training teaches mental and emotional resilience, helping women stay calm and focused in stressful situations. ", R.drawable.selfdefense5));
        selfDefenses.add(new SelfDefense("The ability to defend oneself fosters independence and a sense of empowerment. Women who know self-defense are less likely to feel vulnerable and more capable of navigating the world on their terms.", R.drawable.selfdefense6));
        selfDefenses.add(new SelfDefense("Participating in self-defense classes often creates a supportive community of peers. Sharing experiences and practicing techniques with others can provide a sense of solidarity and encouragement.", R.drawable.selfdefense7));
        selfDefenses.add(new SelfDefense("Self-defense skills are transferable across different environments, including home, work, and public spaces", R.drawable.selfdefense8));
        selfDefenses.add(new SelfDefense("Women with self-defense skills are less likely to be perceived as easy targets. The knowledge that a potential assailant might face resistance can act as a deterrent, potentially reducing the risk of being targeted.", R.drawable.selfdefense9));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewSelfDefense);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new SelfDefenseAdapter(view.getContext(), selfDefenses));
        return  view;
    }
}