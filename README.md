# DIO - Trilha POO Java
<div style="display:inline-block">
        <picture  title="Java">
                <source height="40" width="40" media="(prefers-color-scheme: light)" srcset="https://cdn.simpleicons.org/openjdk/000000">
                <img height="40" width="40" src="https://cdn.simpleicons.org/openjdk/FFFFFF" />
        </picture>
        <picture  title="Apache Maven">
                <source height="40" width="40" media="(prefers-color-scheme: light)" srcset="https://cdn.simpleicons.org/apachemaven/000000">
                <img height="40" width="40" src="https://cdn.simpleicons.org/apachemaven/FFFFFF" />
        </picture>
        <picture  title="Spring Boot">
                <source height="40" width="40" media="(prefers-color-scheme: light)" srcset="https://cdn.simpleicons.org/springboot/000000">
                <img height="40" width="40" src="https://cdn.simpleicons.org/springboot/FFFFFF" />
        </picture>
</div>

## Autor do Desafio e Repositório Original
- [Venilton FalvoJr](https://github.com/falvojr)
- [Lab Banco Digital](https://github.com/falvojr/lab-banco-digital-oo)

## Desafio de Projeto
Abstraia um banco com Java e como desafio, evolua o projeto da forma que preferir e adicione o Lombok como dependência para diminuir a verbosidade do código.

## Contexto
Um banco oferece aos seus clientes dois tipos de contas (`corrente` e `poupança`), as quais possuem as funcionalidades de `depósito`, `saque` e `transferência` (entre contas da própria instituição).

## Abstração
`Abstração` é primeiramente o processo de abstrair objetos do mundo real para modelar classes que capturam os atributos e comportamentos essenciais desses objetos.

Em segundo lugar, abstração também é o processo de esconder detalhes irrelevantes de implementação, de forma a evidenciar ao usuário apenas o que é essencial. Isso pode ser alcançado em Java por meio de `classes abstratas` e `interfaces`.

- `Classe abstrata`: é uma classe restrita que não não pode ser utilizada para criar objetos (para ser acessada deve ser herdada por uma subclasse);
- `Método abstrato`: pode ser usado apenas em classes abstratas e não possui um corpo, sendo este provido pela subclasse que o herdou;

```java
// Classe abstrata
abstract class Animal {
	// Método abstrato (não possui corpo)
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
`Encapsulamento` consiste em limitar o acesso a dados internos de uma classe (atributos e métodos) para prevenir acesso não autorizado. Para encapsular dados existem modificadores de acesso como o `private`, que torna os atributos e métodos acessíveis apenas à sua própria classe.

Para permitir que atributos possam ser acessados por outras classes, os métodos `Get` e `Set` são utilizados.
```java
public class Pessoa {
	// Atributo de acesso restrito
	private String nome;

	// Getter
	public String getNome() {
		return nome;
	}

	// Setter
	public void setNome(String novoNome) {
		this.nome = novoNome;
	}

	// Método de acesso restrito
	private String normalizarNome() {
		return nome.trim().replaceAll("\\s+","").toUpperCase();
	}
}
```

## Herança
`Herança` é a capacidade de uma classe (`subclasse` ou classe filha) herdar atributos e métodos de uma outra classe (`superclasse`, classe pai ou classe base), o que dispensa a repetição do código.
```java
public class Veiculo {
	// Atributo do Veiculo
	protected String marca = "Ford";

	// Método do Veiculo
	public void buzinar() {
		System.out.println("Tuut, tuut!");
	}
}

class Carro extends Veiculo {
	// Atributo de Carro
	private String modelo = "Mustang";
	
	public static void main(String[] args) {
		// Cria um objeto meuCarro
		Carro meuCarro = new Carro();

		// Invoca método da superclasse por meio da instância meuCarro da subclasse
		meuCarro.buzinar();

		// Imprime os valores dos atributos marca da superclasse e modelo da subclasse por meio da instância meuCarro da subclasse
		System.out.println(meuCarro.marca + " " + meuCarro.modelo);
	}
```

## Polimorfismo
`"Polimorfismo"` significa "muitas formas" e ocorre quando subclasses herdam um método e o implementam de forma distinta, o que faz com que o `mesmo método` desempenhe `funções diferentes` em classes diferentes.
```java
public class Animal {
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
	public void fazerSom() {
		System.out.println("O cachorro late");
	}
}
```

## Referências
- Java Abstraction - https://www.w3schools.com/java/java_abstract.asp
- Java Encapsulation - https://www.w3schools.com/java/java_encapsulation.asp
- Java Inheritance - https://www.w3schools.com/java/java_inheritance.asp
- Java Polymorphism - https://www.w3schools.com/java/java_polymorphism.asp