package com.project.shimi.testsalehere.ui.achievement.model

import android.os.Parcel
import android.os.Parcelable

data class Achievement(
    val id: String?,
    val image: String?,
    val name: String?
) :  Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Achievement> {
        override fun createFromParcel(parcel: Parcel): Achievement {
            return Achievement(parcel)
        }

        override fun newArray(size: Int): Array<Achievement?> {
            return arrayOfNulls(size)
        }
    }
}