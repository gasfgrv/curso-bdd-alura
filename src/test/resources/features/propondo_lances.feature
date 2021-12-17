# language: pt

Funcionalidade: Propondo lances ao leilao

  Cenario: Propondo um unico lance valido
    Dado um lance válido
    Quando propoe ao leilão
    Entao o lance é aceito

  Cenario: Propondo um varios lances validos
    Dado um lance de 1.0 real do usuario "fulano"
    E um lance de 10.0 reais do usuario "beltrano"
    Quando propoe varios lances ao leilao
    Entao os lances sao aceitos

  Esquema do Cenario: Propondo um lance invalido
    Dado um lance invalido de <valor> reais e do usuario '<nomeUsuario>'
    Quando propoe ao leilão
    Entao o lance nao eh aceito

    Exemplos:
      | valor | nomeUsuario |
      | 0     | beltrano    |
      | -1    | cigano      |

  Cenario: Propondo uma sequencia de lances
    Dado dois lances
      | valor | nomeUsuario |
      | 1.0   | beltrano    |
      | 10.0  | beltrano    |
    Quando propoe varios lances ao leilao
    Entao o segundo lance nao eh aceito