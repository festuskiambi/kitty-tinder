package com.example.kittytinder.data

import com.squareup.moshi.Json

data class Vote(

	@Json(name="country_code")
	val countryCode: Any? = null,

	@Json(name="sub_id")
	val subId: Any? = null,

	@Json(name="created_at")
	val createdAt: String? = null,

	@Json(name="id")
	val id: Int? = null,

	@Json(name="image_id")
	val imageId: String? = null,

	@Json(name="value")
	val value: Int? = null
)