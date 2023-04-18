import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import modelo.Carro;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Lista de carros
        List<Carro> carros = new ArrayList<>();

        // Lista de cores
        List<String> cores = new ArrayList<>();
        cores.add("Branco");
        cores.add("Preto");
        cores.add("Prata");
        cores.add("Vermelho");

        // Lista de combustíveis
        List<String> combustiveis = new ArrayList<>();
        combustiveis.add("Flex");
        combustiveis.add("Álcool");
        combustiveis.add("Gasolina");
        combustiveis.add("Diesel");

        int opcao = 0;
        while (true) {
            try {
                System.out.println("----------MENU PRINCIPAL-------------");
                System.out.println("1 - Cadastrar um carro");
                System.out.println("2 - Listar todos os carros cadastrados");
                System.out.println("3 - Encerrar o sistema");

                opcao = scanner.nextInt();
                scanner.nextLine();

                if (opcao == 1) {
                    // Adicionar um carro
                    System.out.println("\nCadastrar novo carro\n");

                    int corSelecionada;
                    do {
                        System.out.println("Selecione a cor do carro:");
                        if (cores != null) {
                            for (int i = 0; i < cores.size(); i++) {
                                System.out.println((i + 1) + " - " + cores.get(i));
                            }
                        }
                        corSelecionada = scanner.nextInt();
                        scanner.nextLine();
                        if (corSelecionada <1 || corSelecionada > 4) {
                            System.out.println("Opção inválida! Por favor, selecione um número entre 1 e 4.");
                        }
                    } while (corSelecionada < 1 || corSelecionada > 4);

                    System.out.println("Digite o modelo do carro:");
                    String modelo = scanner.nextLine();
                    while (modelo == null || modelo.trim().isEmpty()) {
                        System.out.println("Modelo inválido! Por favor, digite um modelo válido:");
                        modelo = scanner.nextLine();
                    }

                    System.out.println("Selecione o tipo de combustível:");
                    int combustivelSelecionado = 0;
                    do {
                        if (combustiveis != null) {
                            for (int i = 0; i < combustiveis.size(); i++) {
                                System.out.println((i + 1) + " - " + combustiveis.get(i));
                            }
                        }
                        try {
                            combustivelSelecionado = scanner.nextInt();
                            scanner.nextLine();
                            if (combustivelSelecionado < 1 || combustivelSelecionado > 4) {
                                System.out.println("Opção inválida! Por favor, selecione um número entre 1 e 4.");
                                continue;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Opção inválida! Por favor, informe um valor numérico.");
                            scanner.nextLine();
                            continue;
                        }
                        break;
                    } while (true);

                    System.out.println("Digite a potência do carro:");
                    int potencia = 0;
                    while (true) {
                        try {
                            potencia = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido! Por favor, informe um valor numérico.");
                            System.out.println("Digite a potência do carro:");
                        }
                    }

                    System.out.println("\n------------------------------------------\n");

                    Carro novoCarro = new Carro(cores.get(corSelecionada - 1), modelo,combustiveis.get(combustivelSelecionado - 1), potencia);

                    String salvar = null;
                    while (salvar == null || salvar.trim().isEmpty()) {
                        System.out.print("Deseja salvar as informações? (S/N): ");
                        salvar = scanner.nextLine();
                    }

                    if (salvar.equalsIgnoreCase("S")) {
                        carros.add(novoCarro);
                        System.out.println("Informações salvas com sucesso!");
                        System.out.println("Carro adicionado com sucesso!");
                    } else {
                        System.out.println("Informações descartadas.");
                    }

            } else if (opcao == 2) {
                System.out.println("\nListar todos os carros cadastrados\n");
                if (carros.isEmpty()) {
                    System.out.println("Nenhum carro cadastrado.");
                } else {
                    System.out.println("Lista de carros adicionados:");
                    for (Carro carro : carros) {
                        System.out.println("Cor: " + carro.getCor());
                        System.out.println("Modelo: " + carro.getModelo());
                        System.out.println("Tipo de combustível: " + carro.getCombustivel());
                        System.out.println("Potência: " + carro.getPotencia());
                        System.out.println("-----");
                    }
                }
            } else if (opcao == 3) {
                System.out.println("Sistema encerrado.");
                break;
            } else {
                System.out.println("\nOpção inválida! Tente novamente.\n");
            }
        }catch (InputMismatchException e){
            }
        }
    }
}