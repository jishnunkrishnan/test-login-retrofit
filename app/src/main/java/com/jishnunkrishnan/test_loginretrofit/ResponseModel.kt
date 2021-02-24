package com.jishnunkrishnan.test_loginretrofit

data class ResponseModel(
	val msg: String? = null,
	val data: List<DataItem?>? = null,
	val status: String? = null
)

data class Category(
	val category_name: String? = null,
	val is_block: Int? = null,
	val category_code: String? = null,
	val created_at: String? = null,
	val id: Int? = null
)

data class DataItem(
	val shortDescription: String? = null,
	val isBlock: Int? = null,
	val subCategory: SubCategory? = null,
	val is_subscription: String? = null,
	val courseDollerPrice: Int? = null,
	val createdAt: String? = null,
	val course_image: String? = null,
	val courseExpiry: Any? = null,
	val duration: String? = null,
	val modifiedUser: Int? = null,
	val subSubCategory: SubSubCategory? = null,
	val course_language: String? = null,
	val videoUrl: String? = null,
	val course_code: String? = null,
	val trainer: String? = null,
	val course_fees: String? = null,
	val courseExpiryDate: String? = null,
	val id: Int? = null,
	val trainer_img: String? = null,
	val method: String? = null,
	val androidVideoUrl: String? = null,
	val createdUser: Int? = null,
	val course_title: String? = null,
	val specification: String? = null,
	val showMsg: String? = null,
	val createdBy: Any? = null,
	val tutor: String? = null,
	val tags: String? = null,
	val course_sub_title: String? = null,
	val tId: Int? = null,
	val course_like: String? = null,
	val course_visitor: Int? = null,
	val featuredF_flag: Int? = null,
	val featuredVideo: Any? = null,
	val subsubcategory: Int? = null,
	val course_price: Int? = null,
	val originalCourseImage: String? = null,
	val category: Category? = null,
	val subcategory: Int? = null
)

data class SubSubCategory(
	val subSubCategoryName: String? = null,
	val isBlock: Int? = null,
	val createdAt: String? = null,
	val subSubCategoryCode: String? = null,
	val id: Int? = null,
	val category: Int? = null,
	val subcategory: Int? = null
)

data class SubCategory(
	val isBlock: Int? = null,
	val subCategoryName: String? = null,
	val createdAt: String? = null,
	val id: Int? = null,
	val category: Int? = null,
	val subCategoryCode: String? = null
)

