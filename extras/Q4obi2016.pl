% Olimpíada Brasileira de Informática – OBI2016 – Iniciação Nível 1 – Fase 1
% Nova cerca. João está contruindo uma cerca com postes e traves, como nos diagramas abaixo.
% D1 2P = 3T   D2 3P = 6T  D3  4P = 9T

nTraves(Postes, Preco):-
    Traves is (Postes-1)*3,
    PrecoP is Postes*10,
    PrecoT is Traves*5,
    Preco is Traves+Postes.

% Questão 10. Cada poste custa R$ 10,00 e cada trave custa R$ 5,00. Qual o custo de uma cerca com oito postes?
% (A) R$ 80,00
% (B) R$ 105,00
% (C) R$ 120,00
% (D) R$ 205,00
% (E) R$ 215,00
% Resposta: R$ 135,00, questão cancelada. <- nTraves(8, Preco).
