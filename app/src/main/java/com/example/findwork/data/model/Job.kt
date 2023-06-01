package com.example.findwork.data.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "job_table")
data class Job(

    @SerializedName("candidate_required_location")
    @Expose
    val candidate_required_location: String?,

    @SerializedName("category")
    @Expose
    val category: String?,

    @SerializedName("company_logo_url")
    @Expose
    val company_logo_url: String?,

    @SerializedName("company_name")
    @Expose
    val company_name: String?,

    @SerializedName("description")
    @Expose
    val description: String?,

    @PrimaryKey(autoGenerate = false)
    @NonNull
    @SerializedName("id")
    @Expose
    val id: Int,

    @SerializedName("job_type")
    @Expose
    val job_type: String?,

    @SerializedName("publication_date")
    @Expose
    val publication_date: String?,

    @SerializedName("salary")
    @Expose
    val salary: String?,

//    @SerializedName("tags")
//    @Expose
//    val tags: List<String>,

    @SerializedName("title")
    @Expose
    val title: String?,

    @SerializedName("url")
    @Expose
    val url: String?,

    @Expose
    var is_mark:Boolean=false
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Job> {
        override fun createFromParcel(parcel: Parcel): Job {
            return Job(parcel)
        }

        override fun newArray(size: Int): Array<Job?> {
            return arrayOfNulls(size)
        }
    }

}