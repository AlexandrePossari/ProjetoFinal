package org.example;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int auxMenuPrincipal;
        int auxMenuSecundario;

        //Menu principal
        do{
            auxMenuPrincipal = exibirMenuPrincipal();
            if(auxMenuPrincipal != 0){
                break;
            }

            //Menu secundário
            do {
                auxMenuSecundario = exibirMenuSecundario(auxMenuPrincipal);
            }while(auxMenuSecundario != 0);

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
        return sc.nextInt();
    }

    public static int exibirMenuDeTransmutacaoOuCrafting(){
        System.out.println("\n\n*********MENU DE TRANSMUTAÇÃO OU CRAFTING*********");
        System.out.println("1 - Realizar transmutacao");
        System.out.println("2 - Realizar crafting de capuz");
        System.out.println("3 - Realizar crafting de esconderijo");
        return sc.nextInt();
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
        return sc.nextInt();
    }
}