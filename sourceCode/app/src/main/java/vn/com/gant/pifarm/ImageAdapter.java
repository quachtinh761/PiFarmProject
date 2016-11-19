package vn.com.gant.pifarm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 51104 on 11/19/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private final String[] features;

    public ImageAdapter(Context context, String[] features) {
        this.context = context;
        this.features = features;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {

            gridView = new View(context);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.fearture, null);

            // set value into textview
            TextView textView = (TextView) gridView
                    .findViewById(R.id.grid_item_label);
            textView.setText(features[position]);

            // set image based on selected text
            ImageView imageView = (ImageView) gridView
                    .findViewById(R.id.grid_item_image);

            String feature = features[position];

            if (feature.equals("Ghi thẻ")) {
                imageView.setImageResource(R.drawable.write_card_white);
            } else if (feature.equals("Đọc thẻ")) {
                imageView.setImageResource(R.drawable.read_card_white);
            } else if (feature.equals("Quản lý heo")) {
                imageView.setImageResource(R.drawable.swine_white);
            } else if (feature.equals("Thuốc và vaccine")){
                imageView.setImageResource(R.drawable.vaccine_white);
            } else if (feature.equals("Thống kê")){
                imageView.setImageResource(R.drawable.statistic_white);
            } else if (feature.equals("Hỏi đáp")){
                imageView.setImageResource(R.drawable.forum_white);
            } else if (feature.equals("Quản lý nhân viên")){
                imageView.setImageResource(R.drawable.manage_white);
            } else if (feature.equals("Đồng bộ dữ liệu")){
                imageView.setImageResource(R.drawable.sync_white);
            } else if (feature.equals("Đăng xuất")){
                imageView.setImageResource(R.drawable.logout_white);
            } else {
                imageView.setImageResource(R.mipmap.ic_launcher);
            }

        } else {
            gridView = (View) convertView;
        }

        return gridView;
    }

    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
}
