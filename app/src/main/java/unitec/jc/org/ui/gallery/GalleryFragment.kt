package unitec.jc.org.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_gallery.*
import kotlinx.android.synthetic.main.fragment_gallery.view.*
import unitec.jc.org.Perfil
import unitec.jc.org.R

class GalleryFragment : Fragment() {
    //Empezamos declarando dos atributos, el primer es de tipo viemodel y el segundo
    //el de tipo adater recien creado
    private lateinit var viewModel :GalleryViewModel
    private val  perfilListAdapter = PerfilAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_gallery, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aqui hacemos el enlace de nuestros atributos
        viewModel=ViewModelProviders.of(this).get(GalleryViewModel::class.java)
        //Inmediatamente le vamos a decir que se conecte al backe-end
        viewModel.refrescar()

        //Hasta aqui en ningun momeno el layout  perfil_item esta ligado al fragment_gallery
        //Primero va el enlace. ESTE ES EL ENLACE ENTRE LOS DOS LAYOUT EL QUE
        //CONTIENE EL RECILCERVIEW Y EL DEL LOS ITEMS Y SE HACE POR MEDIO DEL ADAPTER
        perfiles.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=perfilListAdapter
        }

        //Aqui vamos a invocar un metodo que de manera automatica lelva a cabo la adpatacion
        //cada que el usuario le de click ale menu donde esta el fragmento de la gallery
        //este paso es elequivalente de cuando se meten a la app de facebook y se refresca
        // y cambia lo datos en automatico
        //Activamos el swipe
         swipe.setOnRefreshListener {
             perfiles.visibility=View.GONE
             error.visibility=View.GONE
             cargando.visibility=View.VISIBLE
             viewModel.refrescar()
             swipe.isRefreshing=false
         }

        observarViewModel()

    }

    //El ultimo y no vamos este metodo implement a su vez un patron de diseño reactivo
    //que se llama Observer
    fun observarViewModel(){
        //primero invocamos nuestro atributo viewmodel
        viewModel.lista_perfiles.observe(this, Observer {perfi ->
            perfi?.let {
                perfiles.visibility=View.VISIBLE
                perfilListAdapter.actualizarPerfilList(perfi)
            }

        })

        //Seguimos con el errorInternet
        viewModel.errorInternet.observe(this, Observer{errorsito->
            errorsito?.let {
                error.visibility=if(it)View.VISIBLE else View.GONE
            }

        })

        //Terminamos con cargando
        viewModel.cargando.observe(this, Observer {carga->
            carga?.let {
                cargando.visibility=if(it)View.VISIBLE else View.GONE
            }

        })

    }


}