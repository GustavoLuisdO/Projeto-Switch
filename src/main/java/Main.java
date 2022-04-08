import Controllers.SwitchController;
import Services.PortaServices;
import Services.ScanServices;
import Services.SwitchServices;

public class Main {
    public static void main(String[] args)
    {
        ScanServices scan = new ScanServices();
        SwitchServices switchServices = new SwitchServices(); // serviços da classe Switch
        PortaServices portaServices = new PortaServices(); // serviços da classe Porta

        SwitchController switchController = new SwitchController();

        //Scanner scan = new Scanner(System.in);

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
        int opcao = scan.getScan().nextInt();
        scan.clearBuffer(scan.getScan());

        switch (opcao)
        {
            case 1: // Insert Switch
                    System.out.print("Nome do Switch: ");
                    String nomeSwitch = scan.getScan().nextLine();

                    System.out.print("\nQuantidade de portas: ");
                    int qtdPortas = scan.getScan().nextInt();
                    scan.clearBuffer(scan.getScan());

                    switchController.newSwitch(nomeSwitch, qtdPortas);
                break;

            case 2: // Update Switch
                    switchController.updateSwitch();
                break;

            case 3: // Delete Switch
                    System.out.print("Informe o ID do Switch que deseja excluir: ");
                    int idDelete = scan.nextInt();
                    clearBuffer(scan);

                    Switch deleteSwitch = switchServices.findById(idDelete);

                    System.out.println("Tem certeza que deseja excluir o Switch? (1 para sim ou 2 para não)");
                    int confirmacaoDelete = scan.nextInt();
                    clearBuffer(scan);

                    if (confirmacaoDelete == 1){
                        switchServices.delete(deleteSwitch);
                    }
                    else{
                        System.out.println("Operação cancelada!");
                    }
                break;

            case 4: // FindById Switch
                    System.out.print("Informe o ID do Switch que deseja buscar: ");
                    int findId = scan.nextInt();

                    switchServices.findById(findId);
                break;

            case 5: // FindAll Switch
                    for (Switch s: switchServices.findAll()){
                        System.out.println("Id: "+ s.getIdSwitch() +"\n"+
                                            "Nome: "+ s.getNomeSwitch() +"\n"+
                                            "Quantidade de portas: "+ s.getQuantidadePortas() +"\n");
                    }
                break;

            case 6: // Insert Porta
                    Porta newPorta = new Porta();

                    System.out.print("Informe o ID do Switch: ");

                    int idSwitch = scan.nextInt();
                    clearBuffer(scan);

                    Switch verificaId = switchServices.findById(idSwitch);

                    if (verificaId == null){
                        System.out.println("Id inválido!");
                    }
                    else {
                        newPorta.setIdSwitch(idSwitch);

                        System.out.print("Número da porta: ");
                        newPorta.setNumeroPorta(scan.nextInt());
                        clearBuffer(scan);

                        System.out.print("Número do IP: ");

                        String ip = scan.nextLine();

                        if (portaServices.validationIP(ip)){
                            newPorta.setNumeroIP(ip);

                            portaServices.insert(newPorta);
                        }
                        else {
                            System.out.println("Formato de ip inválido!");
                        }
                    }
                break;

            case 7: // Update Porta
                    System.out.print("Informe o ID da Porta que deseja atualizar: ");
                    int idUpdatePorta = scan.nextInt();
                    clearBuffer(scan);

                    Porta updatePorta = portaServices.findById(idUpdatePorta);

                    System.out.println("Escolha qual campo deseja alterar\n" +
                            "1 - Id do Switch\n" +
                            "2 - Número da porta\n" +
                            "3 - Número do IP\n" +
                            "4 - Todos os campos");
                    System.out.print("Escolha sua opção: ");
                    int escolhaUpdate = scan.nextInt();
                    clearBuffer(scan);
                    switch (escolhaUpdate)
                    {
                        case 1: // ID do Switch
                            System.out.print("Informe o ID do Switch: ");
                            updatePorta.setIdSwitch(scan.nextInt());
                            clearBuffer(scan);
                            break;
                        case 2: // Número da porta
                            System.out.print("Informe o novo numero da porta: ");
                            updatePorta.setNumeroPorta(scan.nextInt());
                            clearBuffer(scan);
                            break;
                        case 3: // IP
                                System.out.print("Informe o novo IP: ");
                                String ip = scan.nextLine();

                                if (portaServices.validationIP(ip)){
                                    updatePorta.setNumeroIP(ip);
                                    clearBuffer(scan);
                                }
                                else {
                                    System.out.println("Formato de ip inválido!");
                                }
                            break;
                        case 4: // Todos os campos
                            System.out.print("Informe o ID do Switch: ");
                            updatePorta.setIdSwitch(scan.nextInt());
                            clearBuffer(scan);

                            System.out.print("Informe o novo numero da porta: ");
                            updatePorta.setNumeroPorta(scan.nextInt());
                            clearBuffer(scan);

                            System.out.print("Informe o novo IP: ");
                            String newIP = scan.nextLine();

                            if (portaServices.validationIP(newIP)){
                                updatePorta.setNumeroIP(newIP);
                            }
                            else {
                                System.out.println("Formato de ip inválido!");
                            }
                            break;
                        default:
                            System.out.println("Opção não encontrada!");
                    }

                    System.out.println("Tem certeza que deseja atualizar a Porta? (1 para sim ou 2 para não)");
                    int confirmacaoUpdatePorta = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoUpdatePorta == 1){
                        portaServices.update(updatePorta);
                    }
                    else{
                        System.out.println("Operação cancelada!");
                    }
                break;

            case 8: // Delete Porta
                    System.out.print("Informe o ID da Porta que deseja excluir: ");
                    int idDeletePorta = scan.nextInt();
                    clearBuffer(scan);

                    Porta deletePorta = portaServices.findById(idDeletePorta);

                    System.out.println("Tem certeza que deseja excluir a Porta? (1 para sim ou 2 para não)");
                    int confirmacaoDeletePorta = scan.nextInt();
                    clearBuffer(scan);

                    if (confirmacaoDeletePorta == 1){
                        portaServices.delete(deletePorta);
                    }
                    else{
                        System.out.println("Operação cancelada!");
                    }
                break;

            case 9: // FindById Porta
                    System.out.print("Informe o ID da Porta que deseja buscar: ");
                    int findIdPorta = scan.nextInt();

                    portaServices.findById(findIdPorta);
                break;

            case 10: // FindAll Porta
                    for (Porta p: portaServices.findAll()){
                        System.out.println("Id: "+ p.getIdPorta() +"\n"+
                                "Id do Switch: "+ p.getIdSwitch() +"\n"+
                                "Número da Porta: "+ p.getNumeroPorta() +"\n"+
                                "Número do IP: "+ p.getNumeroIP() +"\n");
                    }
                break;

            default:
                System.out.println("Opção não encontrada!");
        }
        scan.closeScan();
    }
}