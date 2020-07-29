package unitec.jc.org.ui.gallery

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.perfil_item.view.*
import unitec.jc.org.Perfil
import unitec.jc.org.R

//La clase PerfilViewHolder es realmente la clase que sirve de enlace entre el modelo y la vista
class PerfilAdapter(val perfilList:ArrayList<Perfil>):RecyclerView.Adapter<PerfilAdapter.PerfilViewHolder>()   {


    //Generamos esa clase, que en este patro MVVM debe ser como clase interna.
    class PerfilViewHolder(var view: View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerfilViewHolder {
   val inflater =LayoutInflater.from(parent.context)

        val view =inflater.inflate(R.layout.perfil_item, parent,false)
        return PerfilViewHolder(view)
    }


    // Aqui ponemos el perfil adapter de la actualizacion
    fun actualizarPerfilList(nuevaListaPerfil:List<Perfil>){
        //Aqui viene la actualizacion automatica
        perfilList.clear()
        perfilList.addAll(nuevaListaPerfil)

        // este metodo final notifica al Observer que esta en la otras clase la notificacion
        //de que hay un actulizacion
        notifyDataSetChanged()
    }

    override fun getItemCount()= perfilList.size

    override fun onBindViewHolder(holder: PerfilViewHolder, position: Int) {
     //Bind en ingles es ENLZAR, este metodo NOS ENLAZA CADA VISTA A TU MODEL
        //Aqui iran el nombre, el paterno, mail, edad, de perfil
        //Solamente pondremos por el momento en nombre, porque en el list fake  que+
        //pusimo pues solamente pusimos
        holder.view.nombre_item.text=perfilList[position].nombre
        //Para cada uno de tus id's de tu perfil_item tendrias que agrega
        //algo similar

    }

}