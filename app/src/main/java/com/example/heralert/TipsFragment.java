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
 * Use the {@link TipsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TipsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ArrayList<Tips> tipsArrayList;
    private String mParam1;
    private String mParam2;

    public TipsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TipsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TipsFragment newInstance(String param1, String param2) {
        TipsFragment fragment = new TipsFragment();
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
        tipsArrayList = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tips, container, false);
        tipsArrayList.add(new Tips("At Home", "Have Gppd dppr lock, close doors, and winds. Don't open for strangers", R.drawable.home));
        tipsArrayList.add(new Tips("Shopping", "Tell your family members about where are you going. Keep your valuables with you", R.drawable.shopping));
        tipsArrayList.add(new Tips("In the Car", "Always lick your door & windows, Avoid poorly lit parking areas. Hold keys in your hands", R.drawable.inthecar));
        tipsArrayList.add(new Tips("Online", "Don't share private photos, don't share your location", R.drawable.online));
        tipsArrayList.add(new Tips("Traveling Alone", "Inform someone you trust about your travel plans and destination. Stay aware of your surroundings, especially in unfamiliar areas.", R.drawable.travelingalone));
        tipsArrayList.add(new Tips("Public Transportation", "Before boarding, be aware of emergency exits. Avoid empty train cars or buses late at night. Sit near the driver or conductor for added security.", R.drawable.publictransport));
        tipsArrayList.add(new Tips("Home Deliveries", "Request deliveries during daylight hours when possible. Avoid inviting delivery personnel inside. Keep communication brief and to the point.", R.drawable.homedelivery));
        tipsArrayList.add(new Tips("At Hotel", "Choose accommodations in safe neighborhoods. Use door chains or additional locks. Keep valuables secured, and use hotel safes for important items.", R.drawable.athotel));
        tipsArrayList.add(new Tips("Home Maintenance Services", "Verify the identity of service personnel before allowing them into your home. ", R.drawable.homemaintenanceservices));
        tipsArrayList.add(new Tips("Workplace Parking", "Park in well-lit areas. Be aware of your surroundings when walking to and from your car. Consider walking with colleagues, especially in the evening.", R.drawable.workplaceparking));
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTips);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setAdapter(new TipsAdapter(view.getContext(), tipsArrayList));
        return  view;
    }
}