package com.umbb.mobguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResultAdapter extends BaseAdapter {

    private final Context context;
    private final ArrayList<SearchActivity.SearchResult> results;
    private final LayoutInflater inflater;

    public SearchResultAdapter(Context context,
            ArrayList<SearchActivity.SearchResult> results) {
        this.context = context;
        this.results = results;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return results.size();
    }

    @Override
    public Object getItem(int position) {
        return results.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.row_search_result, parent, false);
            holder = new ViewHolder();
            holder.tvName = convertView.findViewById(R.id.tvResultName);
            holder.tvTypeLabel = convertView.findViewById(R.id.tvResultType);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        SearchActivity.SearchResult result = results.get(position);
        holder.tvName.setText(result.name);
        holder.tvTypeLabel.setText(result.typeLabel);

        // Colour badge based on type
        int badgeColor = "FACULTY".equals(result.type)
                ? context.getResources().getColor(R.color.primary, null)
                : context.getResources().getColor(R.color.accent, null);
        holder.tvTypeLabel.setBackgroundTintList(
                android.content.res.ColorStateList.valueOf(badgeColor));

        return convertView;
    }

    static class ViewHolder {
        TextView tvName;
        TextView tvTypeLabel;
    }
}
