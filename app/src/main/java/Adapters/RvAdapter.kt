package Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ilhomjon.customtabitemsandcicrleindicatorintablayout.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.image_item_rv.view.*

class RvAdapter(val imageList:ArrayList<String>) : RecyclerView.Adapter<RvAdapter.VH>() {

    inner class VH(itemView:View) : RecyclerView.ViewHolder(itemView){

        fun onBind(str:String){
            Picasso.get().load(str).into(itemView.image_view_rv_item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(LayoutInflater.from(parent.context).inflate(R.layout.image_item_rv, parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(imageList[position])
    }

    override fun getItemCount(): Int {
        return imageList.size
    }
}