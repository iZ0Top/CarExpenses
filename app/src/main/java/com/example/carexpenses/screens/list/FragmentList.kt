package com.example.carexpenses.screens.list
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.carexpenses.R
import com.example.carexpenses.adapters.AdapterEvent
import com.example.carexpenses.databinding.FragmentListBinding
import com.example.carexpenses.model.Car
import com.example.carexpenses.model.Event
import com.example.carexpenses.model.EventExpense
import com.example.carexpenses.model.EventRefueling
import com.example.carexpenses.utils.CURRENT_CAR

class FragmentList : Fragment() {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!
    private lateinit var listViewModel: ListViewModel
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AdapterEvent
    private var events = mutableListOf<Event>()

    private lateinit var mCarObserver: Observer<List<Car>>
    private lateinit var mEventExpenseObserver: Observer<List<EventExpense>>
    private lateinit var mEventRefuelingObserver: Observer<List<EventRefueling>>


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

        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        listViewModel.initDatabase()
        listViewModel.getCarList()

        if (CURRENT_CAR.isEmpty()){
            TODO()
        } else {
            listViewModel.getEvents()
        }

        mAdapter = AdapterEvent()
        mRecyclerView = binding.recyclerView
        mRecyclerView.adapter = mAdapter
        mAdapter.setData(events)

        listViewModel.allEventExpense.observe(this, mEventExpenseObserver)
        listViewModel.allEventRefueling.observe(this, mEventRefuelingObserver)

        mEventExpenseObserver = Observer {

        }
        mEventRefuelingObserver = Observer {

        }



    }

    override fun onResume() {
        super.onResume()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
//    fun testInit(){
//
//        val  listEventExpense00 = emptyList<EventExpense>()
//        var listEventExpense01 = mutableListOf<EventExpense>()
//        var listEventExpense02 = mutableListOf<EventExpense>()
//        listEventExpense01.add(EventExpense(0,"10.10.1010", 123456, 0, "Engine oil", "Aral 10w40", "AAA 111 222 333", 1070, 1))
//        listEventExpense01.add(EventExpense(1,"10.10.1012", 123457, 0, "Engine oil filter", "Mahle", "AAA 111 222 444", 199, 3))
//        listEventExpense02.add(EventExpense(2,"10.10.1012", 123457, 0, "Engine air filter", "Denkerman", "AAA 111 222 555", 160, 5))
//        var listEventRefueling00 = emptyList<EventRefueling>()
//        var listEventRefueling01 = mutableListOf<EventRefueling>()
//        listEventRefueling01.add(EventRefueling(1,"10.10.1011", 123458, 1, 1,37, 996))
//        listEventRefueling01.add(EventRefueling(2,"10.10.1013", 123459, 1, 2,45, 1678))
//
//        events.add(Event(0,"10.10.2010",123457,1,999, listEventExpense00, listEventRefueling01))
//        events.add(Event(1,"10.10.2020",123456,0,1000, listEventExpense01, listEventRefueling00))
//        events.add(Event(2,"10.10.2010",123457,1,999, listEventExpense00, listEventRefueling01))
//        events.add(Event(4,"10.10.2020",123456,0,1500, listEventExpense02, listEventRefueling00))
//    }

}