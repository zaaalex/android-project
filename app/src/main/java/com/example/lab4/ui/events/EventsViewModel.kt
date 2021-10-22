package com.example.lab4.ui.events

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class EventsViewModel: ViewModel() {

        private val eventsReminder: MutableLiveData<List<EventReminder>> = MutableLiveData()

        init {
            loadEventsReminder()
        }

        fun getEvents(): LiveData<List<EventReminder>>{
            return eventsReminder
        }

        private fun loadEventsReminder() {
            val list = listOf(
                EventReminder("Title","Desc", Date()),
                EventReminder("Title2","Desc2", Date()),
                EventReminder("Title3","Desc3", Date())
            )
            eventsReminder.postValue(list)
        }
}