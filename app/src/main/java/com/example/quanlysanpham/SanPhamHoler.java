package com.example.quanlysanpham;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SanPhamHoler extends RecyclerView.ViewHolder {
    TextView tvmasp, tvtensp,tvslsp;
            LinearLayout layout_item;
    public SanPhamHoler(@NonNull View itemView) {
        super(itemView);
        tvmasp=itemView.findViewById(R.id.tvmasp);
        tvtensp=itemView.findViewById(R.id.tvtensp);
        tvslsp=itemView.findViewById(R.id.tvslsp);
        layout_item=itemView.findViewById(R.id.layout_item);
    }
}
