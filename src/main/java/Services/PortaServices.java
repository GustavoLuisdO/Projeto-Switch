package Services;

import Data.ConnectionDB;
import Entities.Porta;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortaServices
{
    private static ConnectionDB conn;

    public Porta findById(int id){
        try
        {
            conn.openConnection();

            Porta portaFindById = conn.getEm().find(Porta.class, id);

            System.out.println(portaFindById);
            return portaFindById;
        }
        catch (Exception e){
            System.out.println("Erro ao buscar a Porta! "+ e.getMessage());
            return null;
        }
    }

    public void insert(Porta newPorta){
        try
        {
            conn.openConnection();

            conn.getEm().getTransaction().begin();
            conn.getEm().persist(newPorta);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Porta criada com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao inserir Porta! "+ e.getMessage());
        }
    }

    public void update(Porta updatePorta){
        try
        {
            conn.getEm().getTransaction().begin();
            conn.getEm().merge(updatePorta);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Porta atualizada com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao atualizar Porta! "+ e.getMessage());
        }
    }

    public void delete(Porta removePorta){
        try
        {
            conn.getEm().getTransaction().begin();
            conn.getEm().remove(removePorta);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Porta '"+ removePorta.getNumeroPorta() +"' excluída com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao excluir a Porta! "+ e.getMessage());
        }
    }

    public List<Porta> findAll(){
        try
        {
            List<Porta> portas = null;

            conn.openConnection();

            portas = conn.getEm().createQuery("from Porta").getResultList();

            conn.closeConnection();

            return portas;
        }
        catch (Exception e){
            System.out.println("Erro ao listar as Portas! "+ e.getMessage());
            return null;
        }
    }

    public boolean validationIP(String ip){
        String ipRegex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                            "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

        Pattern pattern = Pattern.compile(ipRegex);
        Matcher matcher = pattern.matcher(ip);

        if (matcher.matches()){
           return true;
        }
        else {
            return false;
        }
    }
}
