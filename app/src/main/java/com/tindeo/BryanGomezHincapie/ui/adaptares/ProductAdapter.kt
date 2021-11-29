package com.tindeo.BryanGomezHincapie.ui.adaptares

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tindeo.BryanGomezHincapie.ui.listeners.OnProductListener
import com.tindeo.BryanGomezHincapie.data.models.Product
import com.tindeo.BryanGomezHincapie.databinding.ItemProductBinding

//Recibe una lsita de productos del pollo - Hereda del recicler view del adaptar
//El viewholder se crear ahi
class ProductAdapter (val items: List<Product>):RecyclerView.Adapter<ProductAdapter.ViewHolder>() {
    //Variable
    var listener: OnProductListener? = null

    //Privada
    class ViewHolder(val item: ItemProductBinding): RecyclerView.ViewHolder(item.root)

    //Crear
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            //Lo que le manda al metodo
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.item.itemProductName.text = item.name
        holder.item.itemProductPrice.text = item.price
        //Libreria para traer imagenes de internet
        //       donde pone image   Que vas a cargar      Donde se va a guardar
        Glide.with(holder.itemView).load(item.image).into(holder.item.itemProductPhoto)
        holder.item.root.setOnClickListener {
            //Navegacion segura con "?"
            //Delegar el click
            listener?.onClick(item)
        }

    }

    //Numero de elementos
    override fun getItemCount(): Int {
        return items.size
    }
    //Inidicar que layout -- Podemos hacer un codigo por si llega a ver 0 o 1 o mas elementos
    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}