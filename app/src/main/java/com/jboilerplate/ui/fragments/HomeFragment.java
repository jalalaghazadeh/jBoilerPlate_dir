package com.jboilerplate.ui.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jboilerplate.R;
import com.jboilerplate.data.DataManager;
import com.jboilerplate.data.http_call.Retrofit2Client;
import com.jboilerplate.data.http_call.listener.IResponseAsListListener;
import com.jboilerplate.data.http_call.models.BaseModel;
import com.jboilerplate.data.http_call.models.CategoryModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private final String TAG = getClass().getSimpleName();

    @BindView(R.id.btn_action)
    Button btnAction;
    Unbinder unbinder;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_action)
    public void onViewClicked() {
        new DataManager(getContext()).getAllCategories(new IResponseAsListListener() {
            @Override
            public void onSuccess(Response response) {
                BaseModel categories = (BaseModel) response.body();
                Log.i(TAG, "categories size: " + categories.getData().size());
            }

            @Override
            public void onFailure(String error) {
                Log.i(TAG, "on failure");
            }
        });
    }
}
