package fr.isen.jaxel.androiderestaurant.model

import com.google.gson.annotations.SerializedName
//import fr.delset.androideestaurant.Data


data class DataResult (

  @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

):java.io.Serializable