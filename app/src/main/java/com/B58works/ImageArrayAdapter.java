package com.B58works;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListAdapter;

public class ImageArrayAdapter extends ArrayAdapter<CharSequence> {

    private int index;
    private int[] resourceIds;

    public ImageArrayAdapter(final Context context, final int n, final CharSequence[] array, final int[] resourceIds, final int index) {
        super(context, n, array);
        this.index = 0;
        this.resourceIds = null;
        this.index = index;
        this.resourceIds = resourceIds;
    }

    public View getView(final int n, final View view, final ViewGroup viewGroup) {
        final View inflate = ((Activity)this.getContext()).getLayoutInflater().inflate(R.layout.listitem, viewGroup, false);
        ((ImageView)inflate.findViewById(R.id.image)).setImageResource(this.resourceIds[n]);
        final CheckedTextView checkedTextView = inflate.findViewById(R.id.check);
        checkedTextView.setText(this.getItem(n));
        if (n == this.index) {
            checkedTextView.setChecked(true);
        }
        return inflate;
    }
}
