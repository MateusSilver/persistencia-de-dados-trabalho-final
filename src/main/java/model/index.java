package model;

import java.util.Scanner;

class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("AGENDA DE VACINAÇÃO\n\n1. Exibir todas as vacinas\n2. Cadastrar uma nova vacina\n3. Sair");

        int entrada = sc.nextInt();
        sc.nextLine();
        while(entrada != 3){
            switch (entrada) {
                case (1):
                    // exibeVacinas()
                    break;
                case (2):
                    // cadastrarVacina()
                    break;
                default:
                    System.out.println("insira um valor valido\n");
                    break;
            }
            entrada = sc.nextInt();
            sc.nextLine();
        }
    }
}