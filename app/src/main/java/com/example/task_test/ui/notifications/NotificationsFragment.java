package com.example.task_test.ui.notifications;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.task_test.R;
import com.example.task_test.ui.dashboard.DashboardFragment;

public class NotificationsFragment extends Fragment {

    private NotificationsFragment.OnFragmentInteractionListener listener;
    public static NotificationsFragment newInstance() {
        return new NotificationsFragment();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    public interface OnFragmentInteractionListener {
    }
}
