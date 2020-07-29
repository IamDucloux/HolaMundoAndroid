package unitec.jc.org.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.textfield.TextInputEditText

import unitec.jc.org.R
import unitec.jc.org.TareaGuardarPerfil

/*
Un FRagmento es un elemento de android que esta asociad a una Activity y solo una y tambien
a un layout
En el patron de diseño MVP un Fragmento viene a ser la letra P es decir el Presenter
junto con todos los activities y el layout asociado es la View y el Modelo en este
caso ta simple es la TareaAsincronica
 */

class HomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)
       // Ese valor constante que aqui se genero como root nos apoyamos para
        //invocar nuestras componentes viuales e inyectarlas en el modelo
        var guardar=  root.findViewById<Button>(R.id.guardar)

     //Prevamente invocamos el evento (funcional) del boton y en el invocamos
     //   los valores

        guardar.setOnClickListener {
            var txtN=    root.findViewById<TextInputEditText>(R.id.txtN)
            var txtP=   root.findViewById<TextInputEditText>(R.id.txtP)
            var txtE=  root.findViewById<TextInputEditText>(R.id.txtE)

            //Lo siguiente es lo mas interesante!!  Presentar las vistas al modelo
            //Es lo que les deje de investigación.
            //Creamos un objeto de la tarea asincronica e inicializamos sus arggumentos
            TareaGuardarPerfil(txtN,txtP,txtE,root.context).execute()

        }

        return root
    }
}