package com.mca.recyclertwo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {
    private List<EmployeeInfo> employeeList;

    public EmployeeAdapter(List<EmployeeInfo> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        EmployeeInfo employee = employeeList.get(position);
        holder.nameTextView.setText(employee.getEmployeeName());
        holder.phoneTextView.setText(employee.getEmployeeContactNumber());
        holder.addressTextView.setText(employee.getEmployeeAddress());
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, phoneTextView, addressTextView;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.idTxtEmployeeName);
            phoneTextView = itemView.findViewById(R.id.idTxtEmployeePhone);
            addressTextView = itemView.findViewById(R.id.idTxtEmployeeAddress);
        }
    }
}
