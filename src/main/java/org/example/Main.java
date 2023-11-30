package org.example;

import org.example.DAO.*;
import org.example.models.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int auxMenuPrincipal;
        int auxMenuSecundario;

        //Menu principal
        do{

            auxMenuPrincipal = exibirMenuPrincipal();
            if(auxMenuPrincipal == 0){
                break;
            }

            //Menu secundário
            do {

                auxMenuSecundario = exibirMenuSecundario(auxMenuPrincipal);
                if(auxMenuSecundario == 0){
                    break;
                }


            }while(true);

        }while(true);

    }

    public static int exibirMenuPrincipal(){
        System.out.println("\n\n*********MENU*********");
        System.out.println("1 - Inserir dados");
        System.out.println("2 - Realizar transmutação/crafting");
        System.out.println("3 - Deletar/alterar dados");
        System.out.println("0 - Fechar o programa");
        return sc.nextInt();
    }

    public static int exibirMenuSecundario(int aux){
        int auxReturn;
        switch (aux){
            case 1:
                auxReturn = exibirMenuDeInserção();
                break;
            case 2:
                auxReturn = exibirMenuDeTransmutacaoOuCrafting();
                break;
            case 3:
                auxReturn = exibirMenuDeDelecaoOuAlteracao();
                break;
            case 0:
                return 0;
            default:
                System.out.println("Opção inválida!");
                return 0;
        }

        return auxReturn;
    }


    public static int exibirMenuDeInserção(){
        System.out.println("\n\n*********MENU DE INSERÇÃO DE DADOS*********");
        System.out.println("1 - Inserir dados de transmutação");
        System.out.println("2 - Inserir dados de couro");
        System.out.println("3 - Inserir dados de capuz");
        System.out.println("4 - Inserir dados de pedra");
        System.out.println("5 - Inserir dados de esconderijo");
        System.out.println("0 - Voltar ao menu principal");
        int aux = sc.nextInt();
        return realizarAcoesMenuDeInsercao(aux);
    }

    public static int realizarAcoesMenuDeInsercao(int aux){
        int auxEntrada;
        switch (aux){
            case 1:
                TransmutacaoDAO transmutacaoDAO = new TransmutacaoDAO();
                Transmutacao transmutacao = new Transmutacao();

                System.out.println("Insira o encantamento da transmutação: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                transmutacao.setEncantamento(auxEntrada);

                System.out.println("Insira o grau da transmutação: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                transmutacao.setGrau(auxEntrada);

                System.out.println("Insira o preço desta transmutação: ");
                auxEntrada = sc.nextInt();

                transmutacao.setPreco(auxEntrada);
                transmutacaoDAO.insertTransmutacao(transmutacao);
                break;
            case 2:
                CouroDAO couroDAO = new CouroDAO();
                Couro couro = new Couro();

                System.out.println("Insira a quantidade de couros: ");
                auxEntrada = sc.nextInt();
                couro.setQuantidade(auxEntrada);

                System.out.println("Insira o preço unitário do couro: ");
                auxEntrada = sc.nextInt();
                couro.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do couro: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                couro.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do couro: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                couro.setGrau(auxEntrada);

                couroDAO.insertCouro(couro);
                break;
            case 3:
                CapuzDAO capuzDAO = new CapuzDAO();
                Capuz capuz = new Capuz();

                System.out.println("Insira o preço unitário do capuz: ");
                auxEntrada = sc.nextInt();
                capuz.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do capuz: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                capuz.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do capuz: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                capuz.setGrau(auxEntrada);

                capuzDAO.insertCapuz(capuz);
                break;
            case 4:
                PedraDAO pedraDAO = new PedraDAO();
                Pedra pedra = new Pedra();

                System.out.println("Insira a quantidade de pedras: ");
                auxEntrada = sc.nextInt();
                pedra.setQuantidade(auxEntrada);

                System.out.println("Insira o preço unitário da pedra: ");
                auxEntrada = sc.nextInt();
                pedra.setPreco(auxEntrada);

                System.out.println("Insira o encantamento da pedra: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                pedra.setEncantamento(auxEntrada);

                System.out.println("Insira o grau da pedra: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }

                pedra.setGrau(auxEntrada);
                pedraDAO.insertPedra(pedra);
                break;
            case 5:
                EsconderijoDAO esconderijoDAO = new EsconderijoDAO();
                Esconderijo esconderijo = new Esconderijo();

                System.out.println("Insira o preço unitário do esconderijo: ");
                auxEntrada = sc.nextInt();
                esconderijo.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do esconderijo: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                esconderijo.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do esconderijo: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }

                esconderijo.setGrau(auxEntrada);
                esconderijoDAO.insertEsconderijo(esconderijo);
                break;
            case 0:
                return 0;
            default:
                System.out.println("Opção inválida!");
                return 0;
        }
        return 0;
    }

    public static int exibirMenuDeTransmutacaoOuCrafting(){
        System.out.println("\n\n*********MENU DE TRANSMUTAÇÃO OU CRAFTING*********");
        System.out.println("1 - Realizar transmutacao");
        System.out.println("2 - Realizar crafting de capuz");
        System.out.println("3 - Realizar crafting de esconderijo");
        System.out.println("0 - Voltar ao menu principal");
        int aux = sc.nextInt();
        return realizarAcoesMenuDeTransmutacaoOuCrafting(aux);
    }

    public static int realizarAcoesMenuDeTransmutacaoOuCrafting(int aux){
        int auxEntrada;
        int id1;
        int id2;
        boolean checkExists1 = false;
        boolean checkExists2 = false;
        switch (aux){
            case 1:
                TransmutacaoDAO transmutacaoDAO = new TransmutacaoDAO();

                System.out.println("Selecione por id a transmutação para ser realizada:");
                transmutacaoDAO.selectTransmutacao();
                auxEntrada = sc.nextInt();
                transmutacaoDAO.deleteTransmutacao(auxEntrada);
                break;
            case 2:
                CouroDAO couroDAO = new CouroDAO();
                CapuzDAO capuzDAO = new CapuzDAO();
                ArrayList<Couro> couros = new ArrayList<>();
                ArrayList<Capuz> capuzes = new ArrayList<>();
                Couro couro = new Couro();
                Capuz capuz = new Capuz();

                System.out.println("Selecione por id o couro para ser craftado:");
                couros = couroDAO.selectCouro();
                id1 = sc.nextInt();

                for (int i = 0; i < couros.size(); i++) {
                    if(couros.get(i).getId() == id1){
                        couro = new Couro(couros.get(i).getId(), couros.get(i).getQuantidade(), couros.get(i).getPreco(), couros.get(i).getEncantamento(), couros.get(i).getGrau());
                        checkExists1 = true;
                    }
                }

                System.out.println("Selecione por id o capuz que será craftado:");
                capuzes = capuzDAO.selectCapuz();
                id2 = sc.nextInt();

                for (int i = 0; i < capuzes.size(); i++) {
                    if(capuzes.get(i).getId() == id2){
                        capuz = new Capuz(capuzes.get(i).getId(), capuzes.get(i).getPreco(), capuzes.get(i).getEncantamento(), capuzes.get(i).getGrau());
                        checkExists2 = true;
                    }
                }


                if(checkExists2 && checkExists1){
                } else{
                    System.out.println("Algum dos ids pedidos não foram encontrados!!!");
                    break;
                }

                if (capuz.getEncantamento() == couro.getEncantamento() && capuz.getGrau() == couro.getGrau()) {
                    capuz.setReceita((int) (capuz.getPreco() / ((couro.getPreco() * 8) * 0.5312)));
                    capuzDAO.craftar(id2, capuz, id1);
                    System.out.println("Receita: " + capuz.getReceita());
                }else{
                    System.out.println("Os graus/encantamentos dos itens não são iguais!!!");
                }

                break;
            case 3:
                PedraDAO pedraDAO = new PedraDAO();
                CapuzDAO capuzDAO = new CapuzDAO();
                ArrayList<Couro> pedras = new ArrayList<>();
                ArrayList<Capuz> capuzes = new ArrayList<>();
                Couro couro = new Couro();
                Capuz capuz = new Capuz();

                System.out.println("Selecione por id o couro para ser craftado:");
                pedras = pedraDAO.selectCouro();
                id1 = sc.nextInt();

                for (int i = 0; i < pedras.size(); i++) {
                    if(pedras.get(i).getId() == id1){
                        couro = new Couro(pedras.get(i).getId(), pedras.get(i).getQuantidade(), pedras.get(i).getPreco(), pedras.get(i).getEncantamento(), pedras.get(i).getGrau());
                        checkExists1 = true;
                    }
                }

                System.out.println("Selecione por id o capuz que será craftado:");
                capuzes = capuzDAO.selectCapuz();
                id2 = sc.nextInt();

                for (int i = 0; i < capuzes.size(); i++) {
                    if(capuzes.get(i).getId() == id2){
                        capuz = new Capuz(capuzes.get(i).getId(), capuzes.get(i).getPreco(), capuzes.get(i).getEncantamento(), capuzes.get(i).getGrau());
                        checkExists2 = true;
                    }
                }


                if(checkExists2 && checkExists1){
                } else{
                    System.out.println("Algum dos ids pedidos não foram encontrados!!!");
                    break;
                }

                if (capuz.getEncantamento() == couro.getEncantamento() && capuz.getGrau() == couro.getGrau()) {
                    capuz.setReceita((int) (capuz.getPreco() / ((couro.getPreco() * 8) * 0.5312)));
                    capuzDAO.craftar(id2, capuz, id1);
                    System.out.println("Receita: " + capuz.getReceita());
                }else{
                    System.out.println("Os graus/encantamentos dos itens não são iguais!!!");
                }

                break;
            case 0:
                return 0;
            default:
                System.out.println("Opção inválida!");
                return 0;
        }
        return 0;
    }

    public static int exibirMenuDeDelecaoOuAlteracao(){
        System.out.println("\n\n*********MENU DE DELEÇÃO OU ALTERAÇÃO DE DADOS*********");
        System.out.println("1 - Deletar dados de transmutação");
        System.out.println("2 - Deletar dados de couro");
        System.out.println("3 - Deletar dados de capuz");
        System.out.println("4 - Deletar dados de pedra");
        System.out.println("5 - Deletar dados de esconderijo");
        System.out.println("6 - Alterar dados de transmutação");
        System.out.println("7 - Alterar dados de couro");
        System.out.println("8 - Alterar dados de capuz");
        System.out.println("9 - Alterar dados de pedra");
        System.out.println("10 - Alterar dados de esconderijo");
        System.out.println("0 - Voltar ao menu principal");
        int aux = sc.nextInt();
        return realizarAcoesMenuDeDelecaoOuAlteracao(aux);
    }

    public static int realizarAcoesMenuDeDelecaoOuAlteracao(int aux){
        int auxEntrada;
        int id;
        switch (aux){
            //Deleções
            case 1:
                TransmutacaoDAO transmutacaoDAO = new TransmutacaoDAO();

                System.out.println("Selecione por id a transmutação para ser deletada:");
                transmutacaoDAO.selectTransmutacao();
                auxEntrada = sc.nextInt();
                transmutacaoDAO.deleteTransmutacao(auxEntrada);
                break;
            case 2:
                CouroDAO couroDAO = new CouroDAO();

                System.out.println("Selecione por id o couro para ser deletado:");
                couroDAO.selectCouro();
                auxEntrada = sc.nextInt();
                couroDAO.deleteCouro(auxEntrada);
                break;
            case 3:
                CapuzDAO capuzDAO = new CapuzDAO();

                System.out.println("Selecione por id o capuz para ser deletado:");
                capuzDAO.selectCapuz();
                auxEntrada = sc.nextInt();
                capuzDAO.deleteCapuz(auxEntrada);
                break;
            case 4:
                PedraDAO pedraDAO = new PedraDAO();

                System.out.println("Selecione por id a pedra para ser deletado:");
                pedraDAO.selectPedra();
                auxEntrada = sc.nextInt();
                pedraDAO.deletePedra(auxEntrada);
                break;
            case 5:
                EsconderijoDAO esconderijoDAO = new EsconderijoDAO();

                System.out.println("Selecione por id o capuz para ser deletado:");
                esconderijoDAO.selectEsconderijo();
                auxEntrada = sc.nextInt();
                esconderijoDAO.deleteEsconderijo(auxEntrada);
                break;
            //Atualizações
            case 6:
                TransmutacaoDAO transmutacaoDAOu = new TransmutacaoDAO();
                Transmutacao transmutacao = new Transmutacao();

                System.out.println("Selecione por id a transmutação para ser atualizada:");
                transmutacaoDAOu.selectTransmutacao();
                id = sc.nextInt();

                //Update info
                System.out.println("Insira o encantamento da transmutação: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                transmutacao.setEncantamento(auxEntrada);

                System.out.println("Insira o grau da transmutação: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                transmutacao.setGrau(auxEntrada);

                System.out.println("Insira o preço desta transmutação: ");
                auxEntrada = sc.nextInt();
                transmutacao.setPreco(auxEntrada);

                transmutacaoDAOu.updateTransmutacao(id, transmutacao);
                break;
            case 7:
                CouroDAO couroDAOu = new CouroDAO();
                Couro couro = new Couro();

                System.out.println("Selecione por id o couro para ser atualizado:");
                couroDAOu.selectCouro();
                id = sc.nextInt();

                System.out.println("Insira a quantidade de couros: ");
                auxEntrada = sc.nextInt();
                couro.setQuantidade(auxEntrada);

                System.out.println("Insira o preço unitário do couro: ");
                auxEntrada = sc.nextInt();
                couro.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do couro: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                couro.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do couro: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                couro.setGrau(auxEntrada);

                couroDAOu.updateCouro(id, couro);
                break;
            case 8:
                CapuzDAO capuzDAOu = new CapuzDAO();
                Capuz capuz = new Capuz();

                System.out.println("Selecione por id o capuz para ser atualizado:");
                capuzDAOu.selectCapuz();
                id = sc.nextInt();

                System.out.println("Insira o preço unitário do capuz: ");
                auxEntrada = sc.nextInt();
                capuz.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do capuz: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                capuz.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do capuz: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }
                capuz.setGrau(auxEntrada);

                capuzDAOu.updateCapuz(id, capuz);
                break;
            case 9:
                PedraDAO pedraDAOu = new PedraDAO();
                Pedra pedra = new Pedra();

                System.out.println("Selecione por id a pedra para ser atualizada:");
                pedraDAOu.selectPedra();
                id = sc.nextInt();

                System.out.println("Insira a quantidade de pedras: ");
                auxEntrada = sc.nextInt();
                pedra.setQuantidade(auxEntrada);

                System.out.println("Insira o preço unitário da pedra: ");
                auxEntrada = sc.nextInt();
                pedra.setPreco(auxEntrada);

                System.out.println("Insira o encantamento da pedra: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                pedra.setEncantamento(auxEntrada);

                System.out.println("Insira o grau da pedra: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }

                pedra.setGrau(auxEntrada);

                pedraDAOu.updatePedra(id, pedra);
                break;
            case 10:
                EsconderijoDAO esconderijoDAOu = new EsconderijoDAO();
                Esconderijo esconderijo = new Esconderijo();

                System.out.println("Selecione por id o capuz para ser deletado:");
                esconderijoDAOu.selectEsconderijo();
                id = sc.nextInt();

                System.out.println("Insira o preço unitário do esconderijo: ");
                auxEntrada = sc.nextInt();
                esconderijo.setPreco(auxEntrada);

                System.out.println("Insira o encantamento do esconderijo: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoEncantamento(auxEntrada)){
                    System.out.println("Encantamentos vão apenas de 1 a 4 !!!");
                    return 0;
                }
                esconderijo.setEncantamento(auxEntrada);

                System.out.println("Insira o grau do esconderijo: ");
                auxEntrada = sc.nextInt();
                if (checaCondicaoGrau(auxEntrada)){
                    System.out.println("Graus vão apenas de 4 a 8 !!!");
                    return 0;
                }

                esconderijo.setGrau(auxEntrada);

                esconderijoDAOu.updateEsconderijo(id, esconderijo);
                break;
            case 0:
                return 0;
            default:
                System.out.println("Opção inválida!");
                return 0;
        }
        return 0;
    }

    public static boolean checaCondicaoGrau(int entrada){
        if(entrada <= 3 || entrada >= 9){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checaCondicaoEncantamento(int entrada){
        if(entrada <= 0 || entrada >= 5){
            return true;
        }else{
            return false;
        }
    }
}