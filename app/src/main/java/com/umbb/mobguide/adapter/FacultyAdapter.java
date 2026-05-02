package com.umbb.mobguide.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.umbb.mobguide.R;
import com.umbb.mobguide.model.Faculty;

import java.util.ArrayList;

public class FacultyAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<Faculty> faculties;
    private final LayoutInflater inflater;

    public FacultyAdapter(Context context, ArrayList<Faculty> faculties) {
        this.context = context;
        this.faculties = faculties;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() { return faculties.size(); }

    @Override
    public Object getItem(int position) { return faculties.get(position); }

    @Override
    public long getItemId(int position) { return faculties.get(position).getId(); }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_faculty, parent, false);
            holder = new ViewHolder();
            holder.icon = convertView.findViewById(R.id.imgFacultyIcon);
            holder.name = convertView.findViewById(R.id.tvFacultyName);
            holder.description = convertView.findViewById(R.id.tvFacultyDesc);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Faculty faculty = faculties.get(position);
        holder.icon.setImageResource(R.drawable.ic_faculty);
        holder.name.setText(faculty.getName());

        // Trim description to 80 chars for the list preview
        String desc = faculty.getDescription();
        if (desc.length() > 90) {
            desc = desc.substring(0, 90) + "…";
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
