package com.project.shimi.testsalehere.ui.home.model

import android.os.Parcel
import android.os.Parcelable

data class Goal(
    val id: String?,
    val image: String?,
    val unknown1: String?,
    val unknown2: String?,
    val unknown3: String?,
    val unknown4: String?,
    val unknown5: String?,
    val color: Int?
) :  Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(image)
        parcel.writeString(unknown1)
        parcel.writeString(unknown2)
        parcel.writeString(unknown3)
        parcel.writeString(unknown4)
        parcel.writeString(unknown5)
        parcel.writeValue(color)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Goal> {
        override fun createFromParcel(parcel: Parcel): Goal {
            return Goal(parcel)
        }

        override fun newArray(size: Int): Array<Goal?> {
            return arrayOfNulls(size)
        }
    }
}