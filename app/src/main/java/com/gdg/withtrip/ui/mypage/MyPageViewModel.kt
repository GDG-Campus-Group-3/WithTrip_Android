package com.gdg.withtrip.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyPageViewModel : ViewModel() {
    private val _profile: MutableLiveData<UserProfileModel> = MutableLiveData(
        UserProfileModel(
            "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=http%3A%2F%2Fcfile7.uf.tistory.com%2Fimage%2F993745425A80274C0E0C7A",
            "3조 파이팅"
        )
    )
    val profile: LiveData<UserProfileModel> = _profile


}


data class UserProfileModel(
    val profileImage: String,
    val name: String
)