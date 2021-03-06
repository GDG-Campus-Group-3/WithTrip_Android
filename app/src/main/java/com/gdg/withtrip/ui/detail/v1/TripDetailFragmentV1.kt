package com.gdg.withtrip.ui.detail.v1

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.gdg.withtrip.R
import com.gdg.withtrip.databinding.FragmentTripDetailBinding
import com.gdg.withtrip.ui.detail.TripDetail
import com.gdg.withtrip.ui.detail.TripDetailFragment
import com.gdg.withtrip.ui.detail.TripDetailFragmentArgs
import com.gdg.withtrip.ui.detail.TripDetailViewModel
import com.solar.universe.binding.UniverseViewFragment
import com.solar.universe.extension.loadUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TripDetailFragmentV1 : UniverseViewFragment<FragmentTripDetailBinding>(
    R.layout.fragment_trip_detail,
    FragmentTripDetailBinding::bind
) {

    //private val tripDetail: TripDetail? by lazy { arguments?.getParcelable(KEY_TRIP_DETAIL) }
    private val tripDetail: TripDetailFragmentArgs by navArgs()

    private val tripDetailViewModel: TripDetailViewModel by viewModels()

    override fun onViewCreated(bind: FragmentTripDetailBinding, savedInstanceState: Bundle?) {
        render(tripDetail.tripDetail)

//        tripDetailViewModel.tripDetailLiveData.observe(viewLifecycleOwner, {
//
//        })
    }

    private fun render(tripDetail: TripDetail) = with(binding) {
//        tripDetailImage.loadUrl(tripDetail.image)
//        tripDetailName.text = tripDetail.name
//        tripDetailLocation.text = tripDetail.location
//        tripDetailTitle.text = tripDetail.title
//        tripDetailDesc.text = tripDetail.desc
    }
    companion object {
        fun newInstance(tripDetail: TripDetail): TripDetailFragment {
            val args = Bundle().apply {
                putParcelable(KEY_TRIP_DETAIL, tripDetail)
            }

            val fragment = TripDetailFragment()
            fragment.arguments = args
            return fragment
        }

        private const val KEY_TRIP_DETAIL = "trip_detail"
    }
}