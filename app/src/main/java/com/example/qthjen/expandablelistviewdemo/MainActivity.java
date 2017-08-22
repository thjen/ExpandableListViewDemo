package com.example.qthjen.expandablelistviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListView exListView;
    List<String> listHeader;
    HashMap<String, List<String>> listDataChild;
    CustomExpandableListView customExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
        customExpandableListView = new CustomExpandableListView(MainActivity.this, listHeader, listDataChild);
        exListView.setAdapter(customExpandableListView);
        GroupEvent();
        ChildEvent();
        OpenGroupEvent();
        CloseGroupEvent();

    }

    private void CloseGroupEvent() {
        exListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPositon) {
                Toast.makeText(MainActivity.this, listHeader.get(groupPositon) + " Close", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void OpenGroupEvent() {
        exListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPositon) {
                Toast.makeText(MainActivity.this, listHeader.get(groupPositon) + " Open", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void ChildEvent() {
        exListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int groupPositon, int childPosition, long l) {
                Toast.makeText(MainActivity.this, listDataChild.get(listHeader.get(groupPositon)).get(childPosition), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void GroupEvent() {
        exListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int groupPositon, long l) {
                Toast.makeText(MainActivity.this, listHeader.get(groupPositon), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void addControl() {
        exListView = (ExpandableListView) findViewById(R.id.exListView);
        listHeader = new ArrayList<>();
        listDataChild = new HashMap<String, List<String>>();

        listHeader.add("Film month 10");
        listHeader.add("Film month 11");
        listHeader.add("Film month 12");

        List<String> film10 = new ArrayList<String>();
        film10.add("Tranformer");
        film10.add("anabelle");
        film10.add("Fast and furious");

        List<String> film11 = new ArrayList<String>();
        film11.add("One piece");
        film11.add("Naruto");
        film11.add("Nanatsu no taizai");

        List<String> film12 = new ArrayList<String>();
        film12.add("Fairy tail");
        film12.add("War craft");
        film12.add("Avenger");

        listDataChild.put(listHeader.get(0), film10);
        listDataChild.put(listHeader.get(1), film11);
        listDataChild.put(listHeader.get(2), film12);

    }

}
