package com.umbb.mobguide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.umbb.mobguide.R;
import com.umbb.mobguide.model.Department;

import java.util.ArrayList;

public class DepartmentAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Department> departments;
    private final LayoutInflater inflater;

    public DepartmentAdapter(Context context, ArrayList<Department> departments) {
        this.context = context;
        this.departments = departments;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return departments.size(); }

    @Override
    public Object getItem(int position) { return departments.get(position); }

    @Override
    public long getItemId(int position) { return departments.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_department, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.imgDeptIcon);
            holder.name = convertView.findViewById(R.id.tvDeptName);
            holder.description = convertView.findViewById(R.id.tvDeptDesc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Department dept = departments.get(position);
        holder.icon.setImageResource(R.drawable.ic_department);
        holder.name.setText(dept.getName());

        String desc = dept.getDescription();
        if (desc.length() > 80) {
            desc = desc.substring(0, 80) + "…";
        }
        holder.description.setText(desc);

        return convertView;
    }

    static class ViewHolder {
        ImageView icon;
        TextView name;
        TextView description;
    }
}
