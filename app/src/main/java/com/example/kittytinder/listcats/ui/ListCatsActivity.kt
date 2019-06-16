package com.example.kittytinder.listcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kittytinder.R
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModel
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModelFactory
import com.yuyakaido.android.cardstackview.CardStackListener
import com.yuyakaido.android.cardstackview.Direction
import dagger.android.AndroidInjection
import javax.inject.Inject

class ListCatsActivity : AppCompatActivity(), CardStackListener {

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
                println(catImageList.last().url)
              //  adapter.submitList(notelist)

            }
        )
    }

    override fun onCardDisappeared(view: View?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCardSwiped(direction: Direction?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCardCanceled() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCardAppeared(view: View?, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCardRewound() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
