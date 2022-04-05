/*
 * Kamus Curso java Insafor 2022
 */
package intermedioT3;

import com.google.gson.*;
import java.io.*;
import java.util.Iterator;

/**
 *
 * @author Kamus
 */
public class UsuarioDAO {

    public void crearJson(Usuario u) {
        try {
            Gson gson = new Gson();
            String json = gson.toJson(u);

            File folder = new File("/edutech/");
            if (folder.exists()) {
                System.out.println("ok");
            } else {

                System.out.println("la carpeta no existe y es creada....");
                folder.mkdir();// crea la carpeta en la ruta seleccionada
            }

            //Escribimos en el archivo json
            FileWriter fw = new FileWriter("/edutech/archivoJSon.json", true);
            fw.write("[");
            fw.write(json);
            fw.write("]");
            fw.write("\r\n");
            fw.close();

        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }

    }

    public Usuario leerJson(String usuario) {
        String resultado = "";
        Gson gson = new Gson();
        Usuario us = null;

        try {
            BufferedReader br = new BufferedReader(new FileReader("/edutech/archivoJSon.json"));
            String lineaActual = "";
            while ((lineaActual = br.readLine()) != null) {
                JsonElement json = new JsonParser().parse(lineaActual);
                JsonArray array = json.getAsJsonArray();
                Iterator iterator = array.iterator();

                while (iterator.hasNext()) {
                    JsonElement json2 = (JsonElement) iterator.next();
                    us = gson.fromJson(json2, Usuario.class);

                    if (us.usuario.equals(usuario)) {
                        return us;
                    } else {
                        us = null;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error " + e.getMessage());
            e.printStackTrace();
        }
        return us;
    }

}

class Usuario implements java.io.Serializable {

    String usuario;
    String apellidos;
    String nombres;
    String departamento;

}
