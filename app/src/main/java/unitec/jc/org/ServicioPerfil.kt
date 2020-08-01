package unitec.jc.org

import io.reactivex.rxjava3.core.Single
import retrofit2.Call
import retrofit2.http.*


interface ServicioPerfil {

    //Empezamos con el post que es el de guardar
    @POST("api/perfil")
    fun guardar(@Body perfil:Perfil):Call<Estatus>

    //Sigue buscar Todos
    @GET("api/perfil")
    fun buscarTodos(): Single<List<Perfil>>



    //Sigue el de buscar por ID
    @GET("api/perfil/{id}")
    fun buscarTodos(@Path("id") id:String?):Call<Perfil>

    //Sigue actualizar
    @PUT("api/perfil")
    fun actualizar(@Body perfil:Perfil):Call<Estatus>

//ejercicio Vean la estructura del back-end y escriban solitos cómo quedaría el
    //Delete:
    @DELETE("api/perfil/{id}")
    fun borrar(@Path("id") id:String?):Call<Estatus>


}