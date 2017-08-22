package com.example.qthjen.expandablelistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class CustomExpandableListView extends BaseExpandableListAdapter {

    Context context;
    List<String> listHeader;
    HashMap<String, List<String>> listChild;

    public CustomExpandableListView(Context context, List<String> listHeader, HashMap<String, List<String>> listChild) {

        this.context = context;
        this.listHeader = listHeader;
        this.listChild = listChild;

    }

    @Override
    public int getGroupCount() {
        return listHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return listChild.get(listHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listChild.get(listHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPositon) {
        return groupPositon;
    }

    @Override
    public long getChildId(int groupPositon, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        String headerTitle = (String) getGroup(groupPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.row_group, null);
        TextView tvHeader = (TextView) view.findViewById(R.id.tvHeader);
        tvHeader.setText(" " + headerTitle);

        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean b, View view, ViewGroup viewGroup) {

        String childTitle = (String) getChild(groupPosition, childPosition);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = layoutInflater.inflate(R.layout.row_child, null);
        TextView tvChild = (TextView) view.findViewById(R.id.tvChild);
        tvChild.setText(" " + childTitle);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
