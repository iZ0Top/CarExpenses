package com.example.carexpenses.screens.list
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.R
import com.example.carexpenses.adapters.AdapterEvent
import com.example.carexpenses.databinding.FragmentListBinding
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling

class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var listViewModel: ListViewModel

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AdapterEvent

    private var events = mutableListOf<Event>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()

        testInit()

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        mAdapter = AdapterEvent()
        mRecyclerView = binding.recyclerView
        mRecyclerView.adapter = mAdapter

        mAdapter.setData(events)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun testInit(){

        val  listEventExpense00 = emptyList<EventExpense>()
        var listEventExpense01 = mutableListOf<EventExpense>()
        var listEventExpense02 = mutableListOf<EventExpense>()
        listEventExpense01.add(EventExpense(0,"10.10.1010", 123456, 0, "Engine oil", "Aral 10w40", "AAA 111 222 333", 999, 1))
        listEventExpense01.add(EventExpense(1,"10.10.1012", 123457, 0, "Engine oil filter", "Mahle", "AAA 111 222 444", 199, 1))
        listEventExpense02.add(EventExpense(2,"10.10.1012", 123457, 0, "Engine air filter", "Denkerman", "AAA 111 222 555", 160, 1))
        var listEventRefueling00 = emptyList<EventRefueling>()
        var listEventRefueling01 = mutableListOf<EventRefueling>()
        var listEventRefueling02 = mutableListOf<EventRefueling>()
        listEventRefueling01.add(EventRefueling(1,"10.10.1011", 123458, 1, 1,37, 996))
        listEventRefueling02.add(EventRefueling(2,"10.10.1013", 123459, 1, 2,45, 1678))



        events.add(Event(0,"10.10.2010",123456,0,999, listEventExpense01, listEventRefueling00))
        events.add(Event(1,"10.10.2010",123457,1,999, listEventExpense00, listEventRefueling02))
        events.add(Event(2,"10.10.2011",123458,0,999, listEventExpense00, listEventRefueling02))


    }

}