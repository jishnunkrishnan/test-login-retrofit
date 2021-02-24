package com.jishnunkrishnan.test_loginretrofit

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_course_listing.view.*

//class CourseListAdapter(private val data: ResponseModel, private val context: Context, private val goToProduct: GoToProduct): RecyclerView.Adapter<CourseListAdapter.ViewHolder>() {
class CourseListAdapter(private val data: ResponseModel, private val context: Context): RecyclerView.Adapter<CourseListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.custom_course_listing, parent, false)
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context)
            .load(data.data?.get(position)?.course_image)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.image)
        holder.courseTitle.text = data.data?.get(position)?.course_title
        Glide.with(context)
            .load(data.data?.get(position)?.trainer_img)
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageTutor)
        holder.tutorName.text = data.data?.get(position)?.trainer
        holder.like.text = data.data?.get(position)?.course_like

        holder.price.text = "₹ " + data.data?.get(position)?.course_price

        /* Enabling Clicks on each grid layout */
        /*holder.item.setOnClickListener {

            goToProduct.goToProduct(searchData.arrList?.get(position)?._id.toString())
        }*/
    }

    override fun getItemCount(): Int { return data.data?.size!! }

    inner class ViewHolder internal constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        var image: ImageView = itemView.ivCourseImage
        var courseTitle: TextView = itemView.tvCourseTitle
        var imageTutor: ImageView = itemView.tutorImg
        var tutorName: TextView = itemView.tutorName
        var like: TextView = itemView.tvLike
        var price: TextView = itemView.tvPrice
        //val item: GridLayout = itemView.glProductList
    }

    interface GoToProduct {
        fun goToProduct(productListModel: String)
    }
}