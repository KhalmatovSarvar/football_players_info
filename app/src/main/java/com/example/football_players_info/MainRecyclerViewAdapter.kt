package com.example.football_players_info

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MainRecyclerViewAdapter(private  val players: ArrayList<Player>):RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val player = players[position]

        holder.apply{
            tvPlayerName.text = player.name
            tvDescription.text = player.description
            imagePlayer.setImageResource(player.image)
        }
        if(player.expand) {
            holder.llExpandable.visibility = View.VISIBLE
            holder.imageUpToDown.setImageResource(R.drawable.ic_up)
        } else {
                holder.llExpandable.visibility = View.GONE
                holder.imageUpToDown.setImageResource(R.drawable.ic_down)
            }
        }

    override fun getItemCount(): Int = players.size

    inner class ViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val tvPlayerName = view.findViewById<TextView>(R.id.tv_player_name)
        val  tvDescription = view.findViewById<TextView>(R.id.tv_description)
        val imagePlayer = view.findViewById<ImageView>(R.id.img_player)
        val imageUpToDown = view.findViewById<ImageView>(R.id.img_up_down)
        val llExpandable = view.findViewById<LinearLayout>(R.id.ll_expandable)
        val readMoreButton = view.findViewById<Button>(R.id.btn_read_more)

        init {
            imageUpToDown.setOnClickListener {
                val player = players[adapterPosition]
                player.expand =! player.expand
                notifyDataSetChanged()
            }
        }
    }

    }
