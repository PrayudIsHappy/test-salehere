package com.project.shimi.testsalehere.ui.newgoal.model

import android.os.Parcel
import android.os.Parcelable

data class NewGoalAction(
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

    companion object CREATOR : Parcelable.Creator<NewGoalAction> {
        override fun createFromParcel(parcel: Parcel): NewGoalAction {
            return NewGoalAction(parcel)
        }

        override fun newArray(size: Int): Array<NewGoalAction?> {
            return arrayOfNulls(size)
        }
    }
}