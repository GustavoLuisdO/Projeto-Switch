package Controllers;

import Entities.Switch;
import Services.ScanServices;
import Services.SwitchServices;

import java.util.Scanner;

public class SwitchController
{
    private static ScanServices scan;
    private static SwitchServices switchServices; // serviços da classe Switch

    public void newSwitch(String nome, int qtdPortas){
        try
        {
            Switch newSwitch = new Switch();

            newSwitch.setNomeSwitch(nome);
            newSwitch.setQuantidadePortas(qtdPortas);

            switchServices.insert(newSwitch);
        }
        catch (Exception e){
            System.out.println("Erro! "+ e.getMessage());
        }
    }

    public void updateSwitch(){
        System.out.print("Informe o ID do Switch que deseja atualizar: ");
        int idUpdate = scan.getScan().nextInt();
        clearBuffer(scan.getScan());

        Switch updateSwitch = switchServices.findById(idUpdate);

        System.out.println("Escolha qual campo deseja alterar\n" +
                            "1 - Nome\n" +
                            "2 - Quantidade de Portas\n" +
                            "3 - Todos os campos");

        System.out.print("Escolha sua opção: ");
        int escolha = scan.getScan().nextInt();
        clearBuffer(scan.getScan());

        switch (escolha)
        {
            case 1: // Nome
                System.out.print("Informe o novo nome: ");
                updateSwitch.setNomeSwitch(scan.getScan().nextLine());
                break;
            case 2: // Qtd de portas
                System.out.print("Informe a nova quantidade de portas: ");
                updateSwitch.setQuantidadePortas(scan.getScan().nextInt());
                clearBuffer(scan.getScan());
                break;
            case 3: // Todos os campos
                System.out.print("Informe o novo nome: ");
                updateSwitch.setNomeSwitch(scan.getScan().nextLine());

                System.out.print("Informe a nova quantidade de portas: ");
                updateSwitch.setQuantidadePortas(scan.getScan().nextInt());
                clearBuffer(scan.getScan());
                break;
            default:
                System.out.println("Opção não encontrada!");
        }

        System.out.println("Tem certeza que deseja atualizar o Switch? (1 para sim ou 2 para não)");
        int confirmacaoUpdate = scan.getScan().nextInt();
        clearBuffer(scan.getScan());
        if (confirmacaoUpdate == 1){
            switchServices.update(updateSwitch);
        }
        else{
            System.out.println("Operação cancelada!");
        }
    }



    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
