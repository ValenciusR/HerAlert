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
        escapeArrayList.add(new Escape("What should a woman do if she finds herself alone in the company of a stranger male as she prepares to enter a deserted parking garage at night?", "Expert says: Walk confidently towards your destination, and if you feel uneasy, press your car's panic button. The loud alarm may deter any potential threats.", R.drawable.escape_garage));
        escapeArrayList.add(new Escape("What to do if a stranger approaches a woman while she is jogging alone in a quiet park?", "Expert says: Change your route and head towards a more populated area. Predators often avoid places with more people, reducing the risk of an attack.", R.drawable.escape_jogging));
        escapeArrayList.add(new Escape("How should a woman react if she's alone in an elevator and a stranger enters, making her uncomfortable?", "Expert says: Trust your instincts. If uneasy, exit the elevator on the next floor, even if it's not your intended stop. Your safety is a priority.", R.drawable.escape_elevator));
        escapeArrayList.add(new Escape("What should a woman do if she's alone in a cab and the driver's behavior becomes suspicious or uncomfortable?", "Expert says: Stay on a call with someone, giving details about your location and the cab. If needed, ask the driver to stop in a busy, well-lit area and exit safely.", R.drawable.escape_taxi));
        escapeArrayList.add(new Escape("In a crowded public transportation setting, what should a woman do if she feels someone is following her?", "Expert says: Move towards the driver or conductor, and alert them discreetly about your concern. They can assist and ensure your safety.", R.drawable.publictransport));
        escapeArrayList.add(new Escape("How should a woman respond if a stranger invades her personal space in a crowded concert or event?", "Expert says: Create distance by moving away and notifying event security. Blend into the crowd and seek assistance if the situation escalates.", R.drawable.escape_concert));
        escapeArrayList.add(new Escape("When alone in a residential area and a stranger approaches, how can a woman use her smartphone for safety without escalating the situation?", "Expert says: Pretend to answer a call or send a text message. This may discourage the stranger from approaching, giving you an opportunity to distance yourself.", R.drawable.escape_phone));
        escapeArrayList.add(new Escape("How can a woman create a safety network while traveling alone, ensuring someone is aware of her whereabouts in case of an emergency?", "Expert says: Share your travel itinerary and check-in times with a trusted friend or family member. Utilize location-sharing apps to enhance your safety during solo trips.", R.drawable.travelingalone));
        escapeArrayList.add(new Escape("If a woman is alone in a quiet café and a stranger becomes overly persistent in engaging her, what should she do to maintain her safety?", "Expert says: Politely but firmly decline further interaction, and if necessary, inform café staff about the situation. Position yourself near the exit for a quick departure.", R.drawable.escape_cafe));
        escapeArrayList.add(new Escape("If a woman feels uneasy when entering her apartment building alone, what precautions can she take to enhance her safety?", "Expert says: Carry a loud personal alarm and be ready to use it if necessary. Also, consider asking building security to accompany you to your floor if available.", R.drawable.escape_apart));

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewEscape);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new EscapeAdapter(view.getContext(), escapeArrayList));
        return  view;
    }
}