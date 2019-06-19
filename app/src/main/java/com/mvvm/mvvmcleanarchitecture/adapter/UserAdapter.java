package com.mvvm.mvvmcleanarchitecture.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mvvm.mvvmcleanarchitecture.R;
import com.mvvm.mvvmcleanarchitecture.databinding.ContactItemBinding;
import com.mvvm.mvvmcleanarchitecture.model.UserContactResponse;
import com.mvvm.mvvmcleanarchitecture.viewModel.AllContactItemViewModel;

import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

    private List<UserContactResponse.PayloadBean.PatientListBean> userList;

    public UserAdapter() {this.userList = Collections.emptyList();}

    @Override
    public UserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       ContactItemBinding contactItemBinding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.contact_item ,parent, false);
        return new UserAdapterViewHolder(contactItemBinding);
    }

    @Override
    public void onBindViewHolder(UserAdapterViewHolder holder, int position) {
        holder.bindUser(userList.get(position));

    }

    @Override
    public int getItemCount() {
        return  userList.size();
    }

    public void setUserList(List<UserContactResponse.PayloadBean.PatientListBean> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    public static class UserAdapterViewHolder extends RecyclerView.ViewHolder {

        ContactItemBinding contactItemBinding;

        public UserAdapterViewHolder(ContactItemBinding itemUserBinding) {
            super(itemUserBinding.itemPeople);
            this.contactItemBinding = itemUserBinding;
        }

        void bindUser(UserContactResponse.PayloadBean.PatientListBean user){
            if(contactItemBinding.getUserViewModel() == null){
                contactItemBinding.setUserViewModel(new AllContactItemViewModel(user, itemView.getContext()));
            }else {
                contactItemBinding.getUserViewModel().setUser(user);
            }
        }
    }
}