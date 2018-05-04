%  O Zoológico de São Paulo fez uma pesquisa pela internet para escolher o nome de seu mais novo
% habitante, recém-nascido: um lindo e simpático bicho-preguiça. Sete nomes foram colocados na
% pesquisa: Buda, Fofo, Pingo, Rock, Samba, Teco e Zorro. O Zoológico ordenou os nomes de acordo
% com o número de votos recebidos, do mais votado para o menos votado. O ganhador ainda não foi
% anunciado, mas alguns dados da pesquisa foram divulgados:
%  • Cada nome recebeu um número diferente de votos.
%  • Buda recebeu mais votos do que Teco.
%  • Teco recebeu mais votos do que Fofo.
%  • Fofo recebeu mais votos do que Rock.
%  • Samba não recebeu o menor número de votos.
%  • Zorro recebeu menos votos do que Pingo.
%  • Zorro recebeu mais votos do que Samba e mais votos do que Teco.

% Regras necessárias para a solução
% Um bicho recebeu mais votos que outro
regra1(Pessoa, Pessoa1, Rank):-
    nth1(Votos, Rank, Pessoa),
    nth1(Votos1, Rank, Pessoa1),
    Votos < Votos1.

% O bicho não foi o menos votado
regra2(Pessoa, Rank):-
    nth1(Votos, Rank, Pessoa),
    Votos<7.

% Um bicho recebeu menos votos que o outro
regra3(Pessoa, Pessoa1, Rank):-
    nth1(Votos, Rank, Pessoa),
    nth1(Votos1, Rank, Pessoa1),
    Votos > Votos1.

maisVotados(Rank):-
    % Existem 7 bichos então temos uma lista de 7 espaços
    Rank = [_,_,_,_,_,_,_],
    
    % Adicionando a lista
    member(buda,Rank),
    member(fofo,Rank),
    member(pingo,Rank),
    member(rock,Rank),
    member(samba,Rank),
    member(teco,Rank),
    member(zorro,Rank),
    
    % Aplicando as regras segundo o enunciado.
    regra1(buda,teco,Rank),
    regra1(teco,fofo,Rank),
    regra1(fofo,rock,Rank),
	  regra2(samba,Rank),
    regra3(zorro,pingo,Rank),
    regra1(zorro,samba,Rank),
    regra1(zorro,teco,Rank).
    
%  Questão 11. Qual das seguintes alternativas é
% uma possível lista completa e correta dos nomes
% ordenados, do mais votado ao menos votado?
%   (A) Buda, Pingo, Zorro, Samba, Fofo, Teco,
%   Rock
%   (B) Buda, Pingo, Zorro, Teco, Fofo, Rock,
%   Samba
%   (C) Pingo, Zorro, Buda, Samba, Teco, Fofo,
%   Rock
%   (D) Pingo, Zorro, Samba, Teco, Buda, Fofo,
%   Rock
%   (E) Zorro, Pingo, Buda, Teco, Samba, Fofo,
%   Rock
%   
%   ALTERNATIVA CORRETA: C, que aparecerá na oitava combinação.
