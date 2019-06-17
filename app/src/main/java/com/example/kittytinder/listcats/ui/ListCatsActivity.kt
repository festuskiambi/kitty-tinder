package com.example.kittytinder.listcats.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.LinearInterpolator
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import com.example.kittytinder.R
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModel
import com.example.kittytinder.listcats.viewmodel.ListCatsViewModelFactory
import com.yuyakaido.android.cardstackview.*
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_list_cat.*
import javax.inject.Inject

class ListCatsActivity : AppCompatActivity(), CardStackListener {

    @Inject
    lateinit var viewModelFactory: ListCatsViewModelFactory
    private lateinit var viewModel: ListCatsViewModel

    private val cardStackView by lazy { card_stack_view }
    private val manager by lazy { CardStackLayoutManager(this, this) }
    private val adapter by lazy { CatsAdapter() }

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
        setupCardStackView()
        setupButtons()
    }

    private fun observeViewModel() {
        viewModel.catsList.observe(
            this,
            Observer { catImageList ->
                adapter.setCatslist(catImageList)
            }
        )
    }

    private fun setupCardStackView() {
        manager.setStackFrom(StackFrom.None)
        manager.setVisibleCount(3)
        manager.setTranslationInterval(8.0f)
        manager.setScaleInterval(0.95f)
        manager.setSwipeThreshold(0.3f)
        manager.setMaxDegree(20.0f)
        manager.setDirections(Direction.HORIZONTAL)
        manager.setCanScrollHorizontal(true)
        manager.setCanScrollVertical(true)
        manager.setSwipeableMethod(SwipeableMethod.AutomaticAndManual)
        manager.setOverlayInterpolator(LinearInterpolator())
        cardStackView.layoutManager = manager
        cardStackView.adapter = adapter
        cardStackView.itemAnimator.apply {
            if (this is DefaultItemAnimator) {
                supportsChangeAnimations = false
            }
        }
    }

    private fun setupButtons() {
        setupLikeButton()
        setupUnLikeButton()
        setupUnWindButton()
    }

    private fun setupLikeButton() {
        bt_like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Right)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }
    }

    private fun setupUnLikeButton() {
        bt_un_like.setOnClickListener {
            val setting = SwipeAnimationSetting.Builder()
                .setDirection(Direction.Left)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(AccelerateInterpolator())
                .build()
            manager.setSwipeAnimationSetting(setting)
            cardStackView.swipe()
        }
    }

    private fun setupUnWindButton() {
        bt_rewind.setOnClickListener {
            val setting = RewindAnimationSetting.Builder()
                .setDirection(Direction.Bottom)
                .setDuration(Duration.Normal.duration)
                .setInterpolator(DecelerateInterpolator())
                .build()
            manager.setRewindAnimationSetting(setting)
            cardStackView.rewind()
        }
    }

    override fun onCardDisappeared(view: View?, position: Int) {
    }

    override fun onCardDragging(direction: Direction?, ratio: Float) {
    }

    override fun onCardSwiped(direction: Direction?) {
    }

    override fun onCardCanceled() {
    }

    override fun onCardAppeared(view: View?, position: Int) {
    }

    override fun onCardRewound() {
    }
}
