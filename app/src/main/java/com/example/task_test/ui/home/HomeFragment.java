package com.example.task_test.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.task_test.Adapter.MovieAdapter;
import com.example.task_test.Api;
import com.example.task_test.appInterface.ApiInterface;
import com.example.task_test.Model.Movie;
import com.example.task_test.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    MovieAdapter movieAdapter;
    RecyclerView recyclerView;
    List<Movie> movieList = new ArrayList<Movie>();

 private OnFragmentInteractionListener listener;
    public static HomeFragment newInstance() {
        return new HomeFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);

        movieAdapter = new MovieAdapter(movieList, getActivity());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(movieAdapter);
        getMovieList();

        return view;
    }

    private void getMovieList() {
        ApiInterface apiInterface = Api.getClient().create(ApiInterface.class);
        Call<List<Movie>> call = apiInterface.getMovie();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if (response==null){
                    Toast.makeText(getActivity(), "Somthing Went Wrong...!!", Toast.LENGTH_SHORT).show();
                }else{
                    for (Movie movie:response.body()){
                        movieList.add(movie);
                    }
                    Log.i("RESPONSE: ", ""+response.toString());
                }
                movieAdapter.notifyDataSetChanged();
    }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getActivity(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });
            }

            @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public interface OnFragmentInteractionListener {
    }
}
