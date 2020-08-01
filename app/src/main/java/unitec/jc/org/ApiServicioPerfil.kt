package unitec.jc.org

import io.reactivex.rxjava3.core.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory

import retrofit2.converter.jackson.JacksonConverterFactory

class ApiServicioPerfil {
    //Aqui declaramos la urlBase de nuestra api
    private val baseUrl="https://topo-unitec.herokuapp.com/"

    //La siguinte variable es el objeto retrofit para acceder al servicio
    private val api=Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(JacksonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
        .create(ServicioPerfil::class.java)

    //Generamos una funcion para invocar a todos desde aqui
    //Si deseas puedes mas adelante, invocar algo pero para el de get por id
    fun getPerfiles(): Single<List<Perfil>> {
        return api.buscarTodos()
    }

}