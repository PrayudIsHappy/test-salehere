package com.project.shimi.testsalehere.ui.home.model

import android.os.Parcel
import android.os.Parcelable

data class SuggestForYou(
    val id: String?,
    val src: String?
) :  Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(src)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SuggestForYou> {
        override fun createFromParcel(parcel: Parcel): SuggestForYou {
            return SuggestForYou(parcel)
        }

        override fun newArray(size: Int): Array<SuggestForYou?> {
            return arrayOfNulls(size)
        }
    }
}