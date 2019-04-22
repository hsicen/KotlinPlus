package com.night.jetpack.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * <p>作者：黄思程  2019/4/20 19:51
 * <p>邮箱：codinghuang@163.com
 * <p>功能：
 * <p>描述： 序列化
 */
class User(val name: String?, val age: Int, val gender: String?) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(age)
        parcel.writeString(gender)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}