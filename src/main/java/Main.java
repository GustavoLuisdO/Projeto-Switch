import Entities.Switch;
import Services.SwitchServices;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        SwitchServices switchServices = new SwitchServices(); // serviços da classe Switch

        Scanner scan = new Scanner(System.in);


        System.out.println("Selecione uma opção\n");

        System.out.println("1 - Inserir Switch\n" +
                            "2 - Atualizar Switch\n" +
                            "3 - Excluir Switch\n" +
                            "4 - Consultar Switch\n" +
                            "5 - Lista de Switchs");

        System.out.print("Escolha sua opção: ");
        int opcao = scan.nextInt();
        clearBuffer(scan);

        switch (opcao)
        {
            case 1: // Insert
                    Switch newSwitch = new Switch();

                    System.out.print("Nome do Switch: ");
                    newSwitch.setNomeSwitch(scan.nextLine());

                    System.out.print("\nQuantidade de portas: ");
                    newSwitch.setQuantidadePortas(scan.nextInt());

                    switchServices.insert(newSwitch);
                break;

            case 2: // Update
                    System.out.print("Informe o ID do Switch que deseja atualizar: ");
                    int idUpdate = scan.nextInt();
                    clearBuffer(scan);

                    Switch updateSwitch = switchServices.findById(idUpdate);

                    System.out.println("Escolha qual campo deseja alterar\n" +
                                        "1 - Nome\n" +
                                        "2 - Quantidade de Portas\n" +
                                        "3 - Todos os campos");
                    System.out.print("Escolha sua opção: ");
                    int escolha = scan.nextInt();
                    clearBuffer(scan);
                    switch (escolha)
                    {
                        case 1: // Nome
                                System.out.print("Informe o novo nome: ");
                                updateSwitch.setNomeSwitch(scan.nextLine());
                            break;
                        case 2: // Qtd de portas
                                System.out.print("Informe a nova quantidade de portas: ");
                                updateSwitch.setQuantidadePortas(scan.nextInt());
                                clearBuffer(scan);
                            break;
                        case 3: // Todos os campos
                                System.out.print("Informe o novo nome: ");
                                updateSwitch.setNomeSwitch(scan.nextLine());

                                System.out.print("Informe a nova quantidade de portas: ");
                                updateSwitch.setQuantidadePortas(scan.nextInt());
                                clearBuffer(scan);
                            break;
                        default:
                                System.out.println("Opção não encontrada!");
                    }

                    System.out.println("Tem certeza que deseja atualizar o Switch? (1 para sim ou 2 para não)");
                    int confirmacaoUpdate = scan.nextInt();
                    clearBuffer(scan);
                    if (confirmacaoUpdate == 1){
                        switchServices.update(updateSwitch);
                    }
                    else{
                        System.out.println("Operação cancelada!");
                    }
                break;

            case 3: // Delete
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

            case 4: // FindById
                    System.out.print("Informe o ID do Switch que deseja buscar: ");
                    int findId = scan.nextInt();

                    switchServices.findById(findId);
                break;

            case 5: // FindAll
                    for (Switch s: switchServices.findAll()){
                        System.out.println("Id: "+ s.getIdSwitch() +"\n"+
                                            "Nome: "+ s.getNomeSwitch() +"\n"+
                                            "Quantidade de portas: "+ s.getQuantidadePortas() +"\n");
                    }
                break;
            default:
                System.out.println("Opção não encontrada!");
        }
        scan.close();
    }

    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}