package com.kitkatstudio.sqliteadapters.fragments;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kitkatstudio.sqliteadapters.R;
import com.kitkatstudio.sqliteadapters.adapters.ShowAdapter;
import com.kitkatstudio.sqliteadapters.customclass.ShowContent;
import com.kitkatstudio.sqliteadapters.customclass.ShowContent.ShowItem;
import com.kitkatstudio.sqliteadapters.database.DatabaseColumns;
import com.kitkatstudio.sqliteadapters.database.DatabaseQueries;


public class ShowFragment extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    private Context mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ShowFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_show_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.list);

        // Set the adapter

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), mColumnCount));
            }

        DatabaseQueries db = new DatabaseQueries(getContext());
        Cursor cursor = db.getData();

        ShowContent.ITEMS.clear();

        if(cursor.moveToFirst())
        {
            do {
                ShowItem showContent = new ShowItem(cursor.getString(cursor.getColumnIndex(DatabaseColumns.NAME)),
                        cursor.getString(cursor.getColumnIndex(DatabaseColumns.EMAIL)),
                        cursor.getString(cursor.getColumnIndex(DatabaseColumns.PASSWORD)));

                ShowContent.ITEMS.add(showContent);
            } while (cursor.moveToNext());
        }

        ShowAdapter showAdapter = new ShowAdapter(ShowContent.ITEMS, getContext());
        recyclerView.setAdapter(showAdapter);

        return view;
    }


}
