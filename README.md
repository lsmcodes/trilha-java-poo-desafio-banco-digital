# DIO - Trilha POO Java
www.dio.me

## Autor do Desafio e Repositório Original
- [Venilton FalvoJr](https://github.com/falvojr)
- [Lab Banco Digital](https://github.com/falvojr/lab-banco-digital-oo)

## Desafio de Projeto
Considerando o seu conhecimento no domínio bancário e e no domínio de Programação Orientada a Objetos, abstraia um banco com Java.

## Contexto
Um banco oferece aos seus clientes dois tipos de contas (`corrente` e `poupança`), as quais possuem as funcionalidades de `depósito`, `saque` e `transferência` (entre contas da própria instituição).

## Abstração
`Abstração` é o processo de esconder detalhes irrelevantes de implementação, de forma a evidenciar ao usuário apenas o que é essencial. A abstração pode ser alcançada em Java por meio de `classes abstratas` e `interfaces`.

- `Classe abstrata`: é uma classe restrita que não não pode ser utilizada para criar objetos (para ser acessada deve ser herdada por uma subclasse);

- `Método abstrato`: pode ser usado apenas em classes abstratas e não possui um corpo, sendo este provido pela subclasse que o herdou;
```java
// Classe abstrata
abstract class Animal {
  // Método abstrato (não contém corpo)
  public abstract void fazerSom();
  // Método normal
  public void dormir() {
    System.out.println("Zzz");
  }
}
```
- `Interface`: é uma classe "completamente abstrata", ou seja, uma classe com todos os métodos sem implementação.
```java
// Interface
interface Animal {
  // Método da interface (não possui corpo)
  public void fazerSom();
  // Método da interface (não possui corpo)
  public void correr();
}
```


## Encapsulamento
`Encapsulamento` consiste em limitar o acesso a informações "sensíveis" de uma classe, tornando-as privadas e permitindo que sejam acessadas e modificadas apenas por meio dos métodos públicos `Get` e `Set`.
```java
public class Pessoa {
  private String nome; // private = acesso restrito
  // Getter
  public String getNome() {
    return nome;
  }
  // Setter
  public void setNome(String novoNome) {
    this.nome = novoNome;
  }
}
```

## Herança
`Herança` é a capacidade de uma classe (`subclasse` ou classe filha) herdar atributos e métodos de uma outra classe (`superclasse`, classe pai ou classe base), o que dispensa a repetição do código.
```java
class Veiculo {
  protected String marca = "Ford"; // Atributo do Veiculo
  public void buzinar() { // Método do Veiculo
    System.out.println("Tuut, tuut!");
  }
}

class Carro extends Veiculo {
  private String modelo = "Mustang"; // Atributo de Carro
  public static void main(String[] args) {
    // Cria um objeto mewCarro
    Carro meuCarro = new Carro();
    // Invoca método da superclasse por meio da instância meuCarro da subclasse
    meuCarro.buzinar();
    // Imprime os valor dos atributos marca da superclasse e modelo da subclasse por meio da instância meuCarro da subclasse
    System.out.println(meuCarro.marca + " " + meuCarro.modelo);
  }
```

## Polimorfismo
"`Polimorfismo`" significa "muitas formas" e ocorre quando subclasses herdam um método e o implementam de forma distinta, o que faz com que o `mesmo método` desempenhe `funções diferentes` em classes diferentes.
```java
class Animal {
  public void fazerSom() {
    System.out.println("O animal faz um som");
  }
}

class Porco extends Animal {
  public void fazerSom() {
    System.out.println("O porco grunhe");
  }
}

class Cachorro extends Animal {
  public void animalSound() {
    System.out.println("O cachorro late");
  }
}
```


## Referências
- Java Abstraction - https://www.w3schools.com/java/java_abstract.asp
- Java Encapsulation - https://www.w3schools.com/java/java_encapsulation.asp
- Java Inheritance - https://www.w3schools.com/java/java_inheritance.asp
- Java Polymosphism - https://www.w3schools.com/java/java_polymorphism.asp