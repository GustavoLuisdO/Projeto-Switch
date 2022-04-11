import Controller.PortaController;
import Controller.SwitchController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SwitchController switchController = new SwitchController(); // controlador da classe Switch
        PortaController portaController = new PortaController(); // controlador da classe Porta
        Scanner scan = new Scanner(System.in);

        int continuar = 1;
        for (int pare = 0; pare < continuar; pare++) {
            System.out.println("Selecione uma opção\n");

            System.out.println("1 - Inserir Switch\n" +
                                "2 - Atualizar Switch\n" +
                                "3 - Excluir Switch\n" +
                                "4 - Consultar Switch\n" +
                                "5 - Lista de Switchs\n" +
                                "6 - Inserir Porta\n" +
                                "7 - Atualizar Porta\n" +
                                "8 - Excluir Porta\n" +
                                "9 - Consultar Porta\n" +
                                "10 - Lista de Portas\n");

            System.out.print("Escolha sua opção: ");
            int opcao = scan.nextInt();
            clearBuffer(scan);
            switch (opcao) {
                case 1: // Insert Switch
                    System.out.print("Nome do Switch: ");
                    String nome = scan.nextLine();

                    System.out.print("\nQuantidade de portas: ");
                    int portas = scan.nextInt();
                    clearBuffer(scan);

                    switchController.newSwitch(nome, portas);
                    break;

                case 2: // Update Switch
                    System.out.print("Informe o ID do Switch que deseja atualizar: ");
                    int idUpdate = scan.nextInt();
                    clearBuffer(scan);

                    switchController.findSwitch(idUpdate);

                    System.out.print("Informe o nome: ");
                    String nomeSwitch = scan.nextLine();

                    System.out.print("Informe a quantidade de portas: ");
                    int qtdPortas = scan.nextInt();
                    clearBuffer(scan);

                    System.out.println("Tem certeza que deseja atualizar o Switch? (1 para sim ou 2 para não)");
                    int confirmacaoUpdate = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoUpdate == 1) {
                        switchController.updateSwitch(idUpdate, nomeSwitch, qtdPortas);
                    } else {
                        System.out.println("Operação cancelada!");
                    }
                    break;

                case 3: // Delete Switch
                    System.out.print("Informe o ID do Switch que deseja excluir: ");
                    int idDelete = scan.nextInt();
                    clearBuffer(scan);

                    switchController.findSwitch(idDelete);

                    System.out.println("Tem certeza que deseja excluir o Switch? (1 para sim ou 2 para não)");
                    int confirmacaoDelete = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoDelete == 1) {
                        switchController.deleteSwitch(idDelete);
                    } else {
                        System.out.println("Operação cancelada!");
                    }
                    break;

                case 4: // FindById Switch
                    System.out.print("Informe o ID do Switch que deseja buscar: ");
                    int findId = scan.nextInt();

                    switchController.findSwitch(findId);
                    break;

                case 5: // FindAll Switch
                    switchController.findAllSwitchs();
                    break;

                case 6: // Insert Porta
                    System.out.print("Informe o ID do Switch: ");
                    int idSwitch = scan.nextInt();
                    clearBuffer(scan);

                    switchController.findSwitch(idSwitch);

                    System.out.print("Número da porta: ");
                    int numPorta = scan.nextInt();
                    clearBuffer(scan);

                    System.out.print("Número do IP: ");
                    String ip = scan.nextLine();

                    if (portaController.validationIP(ip)) {
                        portaController.newPorta(idSwitch, numPorta, ip);
                    } else {
                        System.out.println("Formato de ip inválido!");
                    }
                    break;

                case 7: // Update Porta
                    System.out.print("Informe o ID da Porta que deseja atualizar: ");
                    int idUpdatePorta = scan.nextInt();
                    clearBuffer(scan);

                    portaController.findPorta(idUpdatePorta);

                    System.out.print("Informe o ID do Switch: ");
                    int idSwitchUpdate = scan.nextInt();
                    clearBuffer(scan);

                    System.out.print("Informe o numero da porta: ");
                    int numeroPorta = scan.nextInt();
                    clearBuffer(scan);

                    System.out.print("Informe o IP: ");
                    String newIP = scan.nextLine();

                    portaController.validationIP(newIP);

                    System.out.println("Tem certeza que deseja atualizar a Porta? (1 para sim ou 2 para não)");
                    int confirmacaoUpdatePorta = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoUpdatePorta == 1) {
                        portaController.updatePorta(idUpdatePorta, idSwitchUpdate, numeroPorta, newIP);
                    } else {
                        System.out.println("Operação cancelada!");
                    }
                    break;

                case 8: // Delete Porta
                    System.out.print("Informe o ID da Porta que deseja excluir: ");
                    int idDeletePorta = scan.nextInt();
                    clearBuffer(scan);

                    portaController.findPorta(idDeletePorta);

                    System.out.println("Tem certeza que deseja excluir a Porta? (1 para sim ou 2 para não)");
                    int confirmacaoDeletePorta = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoDeletePorta == 1) {
                        portaController.deletePorta(idDeletePorta);
                    } else {
                        System.out.println("Operação cancelada!");
                    }
                    break;

                case 9: // FindById Porta
                    System.out.print("Informe o ID da Porta que deseja buscar: ");
                    int findIdPorta = scan.nextInt();

                    //portaServices.findById(findIdPorta);
                    portaController.findPorta(findIdPorta);
                    break;

                case 10: // FindAll Porta
                    portaController.findAllPortas();
                    break;

                default:
                    System.out.println("Opção não encontrada!");
            }

            System.out.print("--------------------------------------------\n" +
                             "Deseja continuar? (1 para sim ou 2 para não) ");
            int cont = scan.nextInt();
            clearBuffer(scan);
            if (cont == 1){
                continuar ++;
            }else{
                System.out.println("Execução encerrada!");
            }
        }
        scan.close();
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}