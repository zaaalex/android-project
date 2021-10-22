package com.example.lab4.ui.events

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab4.R

class EventAdapter : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

        private var eventReminderList = listOf<EventReminder>()

        fun reload(events: List<EventReminder>){
            eventReminderList = events
            notifyItemRangeChanged(0, events.size)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            return EventViewHolder(inflater.inflate(R.layout.event_item, parent, false))
        }

        override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
            holder.bind(eventReminderList[position])
        }

        override fun getItemCount(): Int  = eventReminderList.size

        class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
            private val nameView: TextView by lazy { itemView.findViewById(R.id.event_item) }

            @SuppressLint("SetTextI18n")
            fun bind(eventReminder:EventReminder) {
                nameView.text = eventReminder.title + " " + eventReminder.desc + " " + eventReminder.date
            }
        }
    }

