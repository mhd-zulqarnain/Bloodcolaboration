package zulqarnain.suuet.acadmy.com.bloodcolaboration.model

/**
 * Created by Zul Qarnain on 4/22/2018.
 */


data class Donner( val fname: String, val lastname: String, val email: String, val bloodGroup: String) {

    constructor() : this("", "", "", "")
}