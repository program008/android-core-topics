package com.example.paging

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil

/**
 *
 * @author liu tao
 * @date 2022/2/18 11:24
 * @description 描述
 */
class UserAdapter(diffCallback: DiffUtil.ItemCallback<User>) :
    PagingDataAdapter<User, UserViewHolder>(diffCallback) {
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val item = getItem(position)
        // Note that item may be null. ViewHolder must support binding a
        // null item as a placeholder.
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent)
    }

}