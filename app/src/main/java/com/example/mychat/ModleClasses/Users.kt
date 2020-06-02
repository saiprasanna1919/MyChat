package com.example.mychat.ModleClasses

import android.media.FaceDetector
import com.example.mychat.Fragments.SearchFragment

class Users {

    private var uid : String = ""
    private var Username : String = ""
    private var Profile : String = ""
    private var Cover : String = ""
    private var Status : String = ""
    private var Facebook : String = ""
    private var Instagram : String = ""
    private var Search: String = ""


    constructor()
    constructor(
        uid: String,
        Username: String,
        Profile: String,
        Cover: String,
        Status: String,
        Facebook: String,
        Instagram: String,
        Search: String
    ) {
        this.uid = uid
        this.Username = Username
        this.Profile = Profile
        this.Cover = Cover
        this.Status = Status
        this.Facebook = Facebook
        this.Instagram = Instagram
        this.Search = Search
    }


    fun getuid(): String? {
        return  uid
    }

    fun setuid(uid: String){
        this.uid = uid
    }

    fun getUsername(): String? {
        return  Username
    }

    fun setUsername(Username: String){
        this.Username = Username
    }

    fun getCover(): String? {
        return  Cover
    }

    fun setCover(Cover: String){
        this.Cover = Cover
    }

    fun getFacebook(): String? {
        return  Facebook
    }

    fun setFacebook(Facebook: String){
        this.Facebook = Facebook
    }

    fun getInstagram(): String? {
        return  Instagram
    }

    fun setInstagram(Instagram: String){
        this.Instagram = Instagram
    }

    fun getProfile(): String? {
        return  Profile
    }

    fun setProfile(Profile: String){
        this.Profile = Profile
    }

    fun getSearch(): String? {
        return  Search
    }

    fun setSearch(Search: String){
        this.Search = Search
    }

    fun getStatus(): String? {
        return  Status
    }

    fun setStatus(Status: String){
        this.Status = Status
    }


}