## Desafio

Para este desafio, vamos consultar a API **ViaCEP**.

Provavelmente, você já se deparou com algum formulário em que, ao digitar seu CEP, seu endereço foi retornado automaticamente, bastando apenas você complementar com o número.

Essa é a ideia. Você fazer no Java uma aplicação que será um buscador de CEP.

Então, você vai consumir a API Via CEP, vai receber os dados e exibir o endereço na aplicação, gravar num JSON, fazer algo bem similar ao que fizemos durante o curso.

Aos poucos, conforme você avançar no desafio, pode ir explorando mais a aplicação.

No [site da ViaCEP](https://viacep.com.br/) podemos ler alguns exemplos.

No Postman, se realizarmos um GET no endereço disponibilizado como exemplo, ele já retorna um endereço no formato JSON. Nesse caso, é um endereço de São Paulo:

```
https://viacep.com.br/ws/01001000/json/
```
```json
{
  "cep": "01001-000",
  "logradouro": "Praça da Sé",
  "complemento": "lado ímpar",
  "bairro": "Sé",
  "localidade": "São Paulo",
  "uf": "SP",
  "ibge": "3550308",
  "gia": "1004",
  "ddd": "11",
  "siafi": "7107"
}
```
Nessa API você pode consultar por um CEP e, depois que concluir o desafio, existem outras possibilidades, como receber uma lista de JSON. Veja os exemplos no site da ViaCEP.

Então, esse é o desafio: **consumir a API ViaCEP na sua aplicação**.

Vou incentivar que você tente fazer sozinha ou sozinho, baseando-se no que vimos durante o curso. Mas vou mostrar alguns passos com a resolução do desafio, como fizemos em cursos anteriores.

### O que vamos fazer?

- [ ] Criar uma aplicação para consultar a API ViaCEP

- [ ] Menu para o usuário informar o CEP para busca

- [ ] Geração de um arquivo .JSON com os dados do endereço

Tente fazer, pesquise, relembre e assista aos vídeos anteriores.

Bons estudos!