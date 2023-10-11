package com.example.quanlysanpham;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SanPhamAdapter extends RecyclerView.Adapter<SanPhamHoler> {
    IOnItemClick listener;
    ArrayList<SanPham>data;
    private int selectedPosition = RecyclerView.NO_POSITION;
    public SanPhamAdapter(IOnItemClick listener, ArrayList<SanPham> data) {
        this.listener = listener;
        this.data = data;
    }
    public void setSelected(){
        selectedPosition=-1;
    }
    public void setSelectedPosition(int position) {
        selectedPosition = position;
        notifyDataSetChanged(); // Cập nhật lại RecyclerView để hiển thị màu nền được cập nhật
    }
    @NonNull
    @Override
    public SanPhamHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SanPhamHoler viewholder= new SanPhamHoler(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,parent,false));
//
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull SanPhamHoler holder, int position) {
        holder.tvmasp.setText("Mã sản phẩm: "+data.get(position).getMasp());
        holder.tvtensp.setText("Tên sản phẩm: "+data.get(position).getTensp());
        holder.tvslsp.setText("Số lượng sản phẩm: "+String.valueOf(data.get(position).getSlsp()));
        SanPham sanPham=data.get(position);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int clickedPosition = holder.getAdapterPosition();
                listener.setOnItemClickListener(sanPham,holder.getAdapterPosition());
                setSelectedPosition(clickedPosition);
            }
        });
        if (position == selectedPosition) {
            holder.itemView.setBackgroundResource(R.drawable.list_select); // Áp dụng màu nền khi dòng được chọn
        } else {
            holder.itemView.setBackgroundResource(0); // Xóa màu nền nếu không được chọn
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
