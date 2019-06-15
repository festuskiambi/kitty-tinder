package com.example.kittytinder.listcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kittytinder.R
import com.example.kittytinder.listcats.ListCatEvent
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModel
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class ListCatsActivity : AppCompatActivity() {


    @Inject
    lateinit var viewModelFactory: ListCatsViewModelFactory
    private lateinit var viewModel: ListCatsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cat)

        AndroidInjection.inject(this)

        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ListCatsViewModel::class.java)

        initViews()
    }

    private fun initViews() {
        viewModel.handleEvent(ListCatEvent.OnStart)
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.catsList.observe(
            this,
            Observer {catImageList ->
                print(catImageList)
              //  adapter.submitList(notelist)

            }
        )
    }
}
