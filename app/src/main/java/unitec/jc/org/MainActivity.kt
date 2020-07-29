package unitec.jc.org

import android.content.Context
import android.content.Intent


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//el compilador de android se llama Dalvik

  //Este metodo lo obtiene de la clase AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
       //Vamos a quitar la actionToolbar

      actionBar?.hide()
      supportActionBar?.hide()

       boton1.setOnClickListener{
      //Navegacion para pasar de la activity MainActivity a la
           // MenuActivity
       var i = Intent(this, MenuActivity::class.java)
           //Finalmente redireccionamos
           startActivity(i)


           //Aqui metemos el manejo del evento
           //Vamos a mostrar en pantalla nuestro primero objeto con código
     Toast.makeText(this,"Mi primer app con kotlin",Toast.LENGTH_LONG)
         .show()
          //Vamos a invocar por medio del contexto el dispositivo
           //de vibarcion del cel
    var v= getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        //El objeto v ya es de tipo Vibrator invocamos su metodo vibrate
    //       v.vibrate(3000)
           //Vamos a dar un breve repaso de kotlin
           //En kotlin no existen ya los datos primitivo o primarios
           //float, int, char, double, byte short
           //Declaracion de constantes
          // val x=4
           val y:Int=7
          // y=5
           var z:Int;
           z=9

          //La clase Log sirve para acceder a la ventana Logcat y esta ventana
           //de verdad que LA AMAMOS LOS DEVELOPERS DE ANDROID. ES PARA DEPURAR
           //El signo de pesos seguido de una variable se le llama interpolacion estatica de Strings
          Log.i("CHORO", "El valor de z es $z y el y es $y ")
          //Tambien el signo de $ sirve para evaluar e interpolar expresiones de programacion
           Log.i("CHORO", "Una expresion evaluada simple ${z+2} esta es una expreion")
            //Invocamos la funcion
           hola()
           Log.i("CHORO","invocando fun con tipo de retorno ${hola2()}  dfdfdfd")
           Log.i("CHORO", "El valor es entre 20 y 30 ${hola3(80,1.70f)}")
       }

    }
    //Aqui vamos a declarar una funcion (metodos)
    fun hola(){
        Log.i("CHORO", "Una funcion invocada")
    }

    //Otra funcion
    fun hola2():String{
        return "Hola mundo"
    }
    //El ultimo tipo es con parametros o argumentos
    fun hola3( peso:Int, altura:Float):Float{
        var imc=peso/(altura*altura)
        return  imc
    }
}
