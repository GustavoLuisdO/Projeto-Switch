package Controller;

import Entities.Switch;
import Services.SwitchServices;

public class SwitchController
{
    private static SwitchServices switchServices = new SwitchServices();

    public void newSwitch(String nome, int qtdPortas){
        try
        {
            Switch nSwitch = new Switch(nome, qtdPortas);
            switchServices.insert(nSwitch);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void updateSwitch(int id, String nome, int qtdPortas){
        try
        {
            Switch updateSwitch = switchServices.findById(id);

            updateSwitch.setNomeSwitch(nome);
            updateSwitch.setQuantidadePortas(qtdPortas);

            switchServices.update(updateSwitch);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void deleteSwitch(int id){
        try
        {
            Switch deleteSwitch = switchServices.findById(id);
            switchServices.delete(deleteSwitch);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void findSwitch(int id){
        try
        {
            switchServices.findById(id);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void findAllSwitchs(){
        try
        {
            for (Switch s: switchServices.findAll()){
                System.out.println("Id: "+ s.getIdSwitch() +"\n"+
                                    "Nome: "+ s.getNomeSwitch() +"\n"+
                                    "Quantidade de portas: "+ s.getQuantidadePortas() +"\n");
            }
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }
}
