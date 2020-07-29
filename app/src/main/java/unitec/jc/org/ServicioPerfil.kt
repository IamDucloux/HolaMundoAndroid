package unitec.jc.org

import retrofit2.Call
import retrofit2.http.*


//Esta interface es el extremo del front-end para cominicarte con el backend
//Tu extremo de comunicacion en el back-end es el ControladorPerfil,
//De tal manera que POR CADA SERVICIO EN EL CONTROLADOR, DEBE HABER UN SERVICIO
//ESPEJO AQUI. Es decir tus 5 operaciones basicas CRUD de la entidad Perfil
interface ServicioPerfil {

    //Empezamos con el post que es el de guardar
    @POST("api/perfil")
    fun guardar(@Body perfil:Perfil):Call<Estatus>

    //Sigue buscar Todos
    @GET("api/perfil")
    fun buscarTodos():Call<List<Perfil>>

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