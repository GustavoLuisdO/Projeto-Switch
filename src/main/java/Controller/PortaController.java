package Controller;

import Entities.Porta;
import Services.PortaServices;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PortaController
{
    private static PortaServices portaServices = new PortaServices();

    public void newPorta(int idSwitch, int numPorta, String ip){
        try
        {
            Porta newPorta = new Porta(idSwitch, numPorta, ip);
            portaServices.insert(newPorta);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void updatePorta(int id, int idSwitch, int numPorta, String ip){
        try
        {
            Porta updatePorta = portaServices.findById(id);

            updatePorta.setIdSwitch(idSwitch);
            updatePorta.setNumeroPorta(numPorta);
            updatePorta.setNumeroIP(ip);

            portaServices.update(updatePorta);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void deletePorta(int id){
        try
        {
            Porta deletePorta = portaServices.findById(id);
            portaServices.delete(deletePorta);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void findPorta(int id){
        try
        {
            portaServices.findById(id);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void findAllPortas(){
        try
        {
            for (Porta p: portaServices.findAll()){
                System.out.println("Id: "+ p.getIdPorta() +"\n"+
                        "Id do Switch: "+ p.getIdSwitch() +"\n"+
                        "Número da Porta: "+ p.getNumeroPorta() +"\n"+
                        "Número do IP: "+ p.getNumeroIP() +"\n");
            }
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public boolean validationIP(String ip){
        try {
            String ipRegex = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
                    "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

            Pattern pattern = Pattern.compile(ipRegex);
            Matcher matcher = pattern.matcher(ip);

            if (matcher.matches()){
                return true;
            }
            else {
                System.out.println("Formato de ip inválido!");
                return false;
            }
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
            return false;
        }
    }
}