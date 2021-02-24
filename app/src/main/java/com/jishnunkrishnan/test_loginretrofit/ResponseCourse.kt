package com.jishnunkrishnan.test_loginretrofit

data class ResponseCourse(
	val msg: String? = null,
	val data: Data? = null,
	val status: String? = null
)

data class Categoryy(
	val categoryName: String? = null,
	val isBlock: Int? = null,
	val categoryCode: String? = null,
	val createdAt: String? = null,
	val id: Int? = null
)

data class SubSubCategoryy(
	val subSubCategoryName: String? = null,
	val isBlock: Int? = null,
	val createdAt: String? = null,
	val subSubCategoryCode: String? = null,
	val id: Int? = null,
	val category: Int? = null,
	val subcategory: Int? = null
)

data class CourseAllTrainersItem(
	val country: Int? = null,
	val whatsappId: Any? = null,
	val lastLoginTime: String? = null,
	val technicalSkills: Any? = null,
	val loginType: Int? = null,
	val phone2: Any? = null,
	val tutorCode: String? = null,
	val phone1: String? = null,
	val passingYear: Any? = null,
	val availableTime: Any? = null,
	val youtubeLink: Any? = null,
	val skypeId: Any? = null,
	val userType: Int? = null,
	val id: Int? = null,
	val state: Int? = null,
	val twitterId: Any? = null,
	val verification: String? = null,
	val currentLocation: String? = null,
	val goals: String? = null,
	val createdUser: Int? = null,
	val lastLoginId: Any? = null,
	val currentDesignation: String? = null,
	val functionalArea: Any? = null,
	val facebookId: Any? = null,
	val forgotCode: Any? = null,
	val qualification: String? = null,
	val vision: String? = null,
	val profileImg: String? = null,
	val nationality: String? = null,
	val dob: String? = null,
	val district: Int? = null,
	val workingFlag: Int? = null,
	val designation: Int? = null,
	val certificationFlag: Int? = null,
	val desc: String? = null,
	val gender: String? = null,
	val isBlock: Int? = null,
	val createdAt: String? = null,
	val changePw: Any? = null,
	val modifiedUser: Int? = null,
	val totalExperience: String? = null,
	val softSkills: Any? = null,
	val anotherProfile: String? = null,
	val achivements: String? = null,
	val firstName: String? = null,
	val email: String? = null,
	val website: Any? = null,
	val address: String? = null,
	val question: Any? = null,
	val lastName: Any? = null,
	val serviceSpecification: Any? = null,
	val answer: Any? = null,
	val isApproved: Int? = null
)

data class TopicsItem(
	val method: Any? = null,
	val androidVideoUrl: Any? = null,
	val createdUser: Int? = null,
	val isBlock: Int? = null,
	val createdAt: String? = null,
	val featuredImage: String? = null,
	val modifiedUser: Any? = null,
	val videoUrl: Any? = null,
	val topicTitle: String? = null,
	val topicDescription: String? = null,
	val featuredVideo: Any? = null,
	val course: Int? = null,
	val id: Int? = null,
	val topicSubTitle: String? = null,
	val topicSpecification: String? = null
)

data class Data(
	val short_description: String? = null,
	val isBlock: Int? = null,
	val subCategory: SubCategory? = null,
	val isSubscription: String? = null,
	val recrut: List<Any?>? = null,
	val courseDollerPrice: Int? = null,
	val courseAllTrainers: List<CourseAllTrainersItem?>? = null,
	val createdAt: String? = null,
	val reviewCount: Int? = null,
	val course_image: String? = null,
	val courseExpiry: Any? = null,
	val duration: String? = null,
	val modifiedUser: Int? = null,
	val relatedCourse: List<RelatedCourseItem?>? = null,
	val subSubCategory: SubSubCategory? = null,
	val course_language: String? = null,
	val videoUrl: String? = null,
	val courseCode: String? = null,
	val trainer: String? = null,
	val review: List<Any?>? = null,
	val courseFees: String? = null,
	val courseLink: String? = null,
	val courseExpiryDate: String? = null,
	val id: Int? = null,
	val trainerImg: String? = null,
	val method: String? = null,
	val androidVideoUrl: String? = null,
	val createdUser: Int? = null,
	val topics: List<TopicsItem?>? = null,
	val course_title: String? = null,
	val jobs: List<JobsItem?>? = null,
	val specification: String? = null,
	val stars: Int? = null,
	val showMsg: String? = null,
	val createdBy: Any? = null,
	val tutor: String? = null,
	val tags: String? = null,
	val courseSubTitle: String? = null,
	val tId: Int? = null,
	val course_like: String? = null,
	val courseVisitor: Int? = null,
	val featuredFlag: Int? = null,
	val featuredVideo: Any? = null,
	val subsubcategory: Int? = null,
	val course_price: Int? = null,
	val originalCourseImage: String? = null,
	val category: Category? = null,
	val subcategory: Int? = null
)

data class JobsItem(
	val course: Int? = null,
	val createdAt: String? = null,
	val id: Int? = null,
	val title: String? = null,
	val jType: String? = null,
	val url: String? = null
)

data class RelatedCourseItem(
	val shortDescription: String? = null,
	val isBlock: Int? = null,
	val subCategory: SubCategory? = null,
	val isSubscription: String? = null,
	val courseDollerPrice: Int? = null,
	val createdAt: String? = null,
	val course_image: String? = null,
	val courseExpiry: Any? = null,
	val duration: String? = null,
	val modifiedUser: Int? = null,
	val subSubCategory: SubSubCategory? = null,
	val course_language: String? = null,
	val videoUrl: String? = null,
	val courseCode: String? = null,
	val trainer: String? = null,
	val courseFees: String? = null,
	val courseExpiryDate: String? = null,
	val id: Int? = null,
	val trainerImg: String? = null,
	val method: String? = null,
	val androidVideoUrl: String? = null,
	val createdUser: Int? = null,
	val courseTitle: String? = null,
	val specification: String? = null,
	val showMsg: Any? = null,
	val createdBy: Any? = null,
	val tutor: String? = null,
	val tags: String? = null,
	val courseSubTitle: String? = null,
	val tId: Int? = null,
	val courseLike: String? = null,
	val courseVisitor: Int? = null,
	val featuredFlag: Int? = null,
	val featuredVideo: Any? = null,
	val subsubcategory: Int? = null,
	val coursePrice: Int? = null,
	val originalCourseImage: String? = null,
	val category: Category? = null,
	val subcategory: Int? = null
)

data class SubCategoryy(
	val isBlock: Int? = null,
	val subCategoryName: String? = null,
	val createdAt: String? = null,
	val id: Int? = null,
	val category: Int? = null,
	val subCategoryCode: String? = null
)
