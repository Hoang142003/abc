package com.example.quanlysanpham;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements IOnItemClick{
RecyclerView rev;
EditText edtmasp,edttensp,edtslsp;
Button btnthem,btnxoa,btnsua,btnthoat,btn_doimau_red,btn_doimau_green;
int index=-1;
ArrayList<SanPham> data=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }

    private void setEvent() {
        SanPhamAdapter adapter=new SanPhamAdapter(this, data);
        rev.setLayoutManager(new LinearLayoutManager(this));
        rev.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rev.addItemDecoration(dividerItemDecoration);
        btn_doimau_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnthem.setBackgroundResource(R.drawable.btn_click_red);
                btnxoa.setBackgroundResource(R.drawable.btn_click_red);
                btnsua.setBackgroundResource(R.drawable.btn_click_red);
                btnthoat.setBackgroundResource(R.drawable.btn_click_red);
            }
        });
        btn_doimau_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnthem.setBackgroundResource(R.drawable.button_press);
                btnxoa.setBackgroundResource(R.drawable.button_press);
                btnsua.setBackgroundResource(R.drawable.button_press);
                btnthoat.setBackgroundResource(R.drawable.button_press);
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.add(new SanPham(edtmasp.getText().toString(),edttensp.getText().toString(),Integer.parseInt(edtslsp.getText().toString())));
                adapter.notifyDataSetChanged();
            }
        });
        btnxoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index!=-1) {
                    data.remove(index);
                    adapter.notifyDataSetChanged();
                    adapter.setSelected();
                    index=-1;
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng chọn dòng cần xóa !!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnsua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(index!=-1){
                    data.set(index,new SanPham(edtmasp.getText().toString(),edttensp.getText().toString(),Integer.parseInt(edtslsp.getText().toString())));
                    adapter.notifyDataSetChanged();
                    adapter.setSelected();
                    index=-1;
                }else{
                    Toast.makeText(MainActivity.this, "Vui lòng chọn dòng cần sửa !!!", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void setControl() {
        rev=findViewById(R.id.revSP);
        edtmasp=findViewById(R.id.edtmasp);
        edttensp=findViewById(R.id.edttensp);
        edtslsp=findViewById(R.id.edtslsp);
        btnthem=findViewById(R.id.btnthem);
        btnxoa=findViewById(R.id.btnxoa);
        btnsua=findViewById(R.id.btnsua);
        btnthoat=findViewById(R.id.btnthoat);
        btn_doimau_red=findViewById(R.id.btn_doimau_red);
        btn_doimau_green=findViewById(R.id.btn_doimau_green);
    }

    @Override
    public void setOnItemClickListener(SanPham sanPham,int position) {
        edtmasp.setText(sanPham.getMasp());
        edttensp.setText(sanPham.getTensp());
        edtslsp.setText(String.valueOf(sanPham.getSlsp()));
        index=position;
    }
}