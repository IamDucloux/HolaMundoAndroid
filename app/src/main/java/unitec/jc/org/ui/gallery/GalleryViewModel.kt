package unitec.jc.org.ui.gallery


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import unitec.jc.org.Perfil


//El ViewModel se encarga de obtener la informacion del back-end
//y prepararla para la vista. En el caso del RecyclerView vamos a tener
//que apoyarnos de las clases Adatpadoras. Su funcion de ellas es "adaptar" el modelo
//a la vista (perfil_item)
class GalleryViewModel : ViewModel() {

    val lista_perfiles=MutableLiveData<List<Perfil>>()
    val errorInternet=MutableLiveData<Boolean>()
    val cargando=MutableLiveData<Boolean>()

    private fun obtenerPerfile(){
        //Aqui vamos a llamar nuestro srvicio rest, por el momento vamos a
        //hacer un fake de perfiles para primero, verificar que funcione
    }

    fun refrescar(){
        //Cada que se requierea obtener informacion ya cambiada se va a invocar
        // este metodo refrescar. y vamos a hacer un enlace al back end con retrofit
        //Por simplicidad vamos a hacer una lista fake de perfiles.
        val p1= Perfil()
        p1.nombre="Vaneso"
        val p2=Perfil()
        p2.nombre="Eriko"
        val p3=Perfil()
        p3.nombre="Rodriga"
        val p4=Perfil()
        p4.nombre="Armanda"
        val lista= arrayListOf<Perfil>(p1,p2,p3,p4)
        //Imagina que estos los sacaste de retrofit
       //Asignamos MutableLiveData a estos
        lista_perfiles.value=lista
        errorInternet.value=false
        cargando.value=false

    }
}