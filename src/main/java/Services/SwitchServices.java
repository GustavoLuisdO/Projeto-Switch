package Services;

import Data.ConnectionDB;
import Entities.Switch;
import java.util.List;

public class SwitchServices
{
    private static ConnectionDB conn;
    //private static SwitchController switchController;

    public Switch findById(int id){
        try
        {
            conn.openConnection();

            Switch switchFindById = conn.getEm().find(Switch.class, id);
            System.out.println(switchFindById);
            return switchFindById;
        }
        catch (Exception e){
            System.out.println("Erro ao buscar o Switch! "+ e.getMessage());
            return null;
        }
    }

    public void insert(Switch newSwitch){
        try
        {
            conn.openConnection();

            conn.getEm().getTransaction().begin();
            conn.getEm().persist(newSwitch);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Switch criado com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao inserir Switch! "+ e.getMessage());
        }
    }

    public void update(Switch updateSwitch){
        try
        {
            conn.getEm().getTransaction().begin();
            conn.getEm().merge(updateSwitch);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Switch atualizado com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao atualizar Switch! "+ e.getMessage());
        }
    }

    public void delete(Switch removeSwitch){
        try
        {
            conn.getEm().getTransaction().begin();
            conn.getEm().remove(removeSwitch);
            conn.getEm().getTransaction().commit();

            conn.closeConnection();

            System.out.println("Switch '"+ removeSwitch.getNomeSwitch() +"' excluído com sucesso!");
        }
        catch (Exception e){
            System.out.println("Erro ao excluir o Switch! "+ e.getMessage());
        }
    }

    public List<Switch> findAll(){
        try
        {
            List<Switch> switchs = null;

            conn.openConnection();

            switchs = conn.getEm().createQuery("from Switch").getResultList();

            conn.closeConnection();

            return switchs;

        }
        catch (Exception e){
            System.out.println("Erro ao listar os Switchs! "+ e.getMessage());
            return null;
        }
    }
}