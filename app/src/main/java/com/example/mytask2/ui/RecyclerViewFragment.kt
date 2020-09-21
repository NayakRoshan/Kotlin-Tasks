package com.example.mytask2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mytask2.Entity.PersonEntity
import com.example.mytask2.R
import kotlinx.android.synthetic.main.fragment_recyclerview.*

class RecyclerViewFragment : Fragment() {

    private lateinit var navController : NavController
    private val bundleKeys : Array<String> = resources.getStringArray(R.array.bundle_keys)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        navController = Navigation.findNavController(view)
        setUpRecyclerView()
    }

    private fun getPersonDetails() : List<PersonEntity> {
        val personDetails : ArrayList<PersonEntity> = arrayListOf()

        val person1 = PersonEntity(1, "Aaron Finch", "13423", 23)
        val person2 = PersonEntity(2, "Virat", "134235", 25)
        val person3 = PersonEntity(3, "ABD", "43356", 18)
        val person4 = PersonEntity(4, "Morris", "357457", 30)

        personDetails.run {
            this.add(person1)
            this.add(person2)
            this.add(person3)
            this.add(person4)
        }

        //define a comparator to sort the list wrt the age.
        //if result > 0 the o1 is greater else o2.
        val compareAge : Comparator<PersonEntity> = Comparator {
                o1 : PersonEntity, o2 : PersonEntity -> o1.age - o2.age
        }
        personDetails.sortWith(compareAge) //sort the list wrt the age.

        return personDetails
    }

    private val callDetailsFragment = { name : String ->
        val bundle : Bundle = bundleOf(bundleKeys[0] to name )
        navController.navigate(R.id.action_recyclerViewFragment_to_detailsFragment, bundle)
    }

    private fun setUpRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val detailsList : List<PersonEntity> = getPersonDetails()
        val viewAdapter = DetailsRecyclerViewAdapter(
            requireActivity(),
            detailsList,
            callDetailsFragment
        )
        recyclerView.adapter = viewAdapter
    }
}