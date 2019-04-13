package pr.thomassong.movie.widget.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter


/**
 *  author thomassong
 */
abstract class BaseAdapter<T: Any>(
    private val lifecycleOwner: LifecycleOwner,
    diffCallback: DiffUtil.ItemCallback<T>
): ListAdapter<T, BaseViewHolder<T, ViewDataBinding>>(diffCallback) {

    abstract fun createViewHolder(binding: ViewDataBinding): BaseViewHolder<T, ViewDataBinding>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, ViewDataBinding> {
        return createViewHolder(DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), viewType, parent, false))
    }


    override fun onBindViewHolder(holder: BaseViewHolder<T, ViewDataBinding>, position: Int) {
        holder.binding.lifecycleOwner = this@BaseAdapter.lifecycleOwner
        holder.bind(getItem(position))
    }

}