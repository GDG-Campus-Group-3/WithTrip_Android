package com.gdg.withtrip.ui.feed

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentFeedBinding
import com.gdg.withtrip.ui.MockData
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.popular.PopularCard
import com.gdg.withtrip.ui.popular.PopularCardAdapter
import com.gdg.withtrip.ui.popular.PopularCardEventListener
import com.gdg.withtrip.ui.trip.TripViewModel
import com.solar.universe.binding.UniverseViewFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment :
    UniverseViewFragment<FragmentFeedBinding>(R.layout.fragment_feed, FragmentFeedBinding::bind),
    PopularCardEventListener {

    private val tripViewModel: TripViewModel by viewModels()

    override fun onViewCreated(bind: FragmentFeedBinding, savedInstanceState: Bundle?) {


        bind.popularListView.adapter = PopularCardAdapter(this).apply {
            submit(MockData.randomPopularMockData())
        }
    }

    override fun onClickCard(popularCard: PopularCard) {
        val tripDetail = TripDetail(
            image = popularCard.image,
            name = popularCard.title,
            location = popularCard.title,
            title = popularCard.title,
            desc = popularCard.subtitle
        )

        requireView().findNavController().navigate(
            FeedFragmentDirections.actionNavigationFeedToTripDetailFragment2(tripDetail)
        )
    }

    override fun onClickLike(popularCard: PopularCard) {
        tripViewModel.savePopularCard(popularCard)
    }
}