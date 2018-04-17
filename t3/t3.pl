% 1. Defina um predicado zeroInit(L) que é verdadeiro se L for uma lista que inicia com o número 0 (zero).
zeroInit(L):- L=[H|_], H=:=0.

% 2. Defina um predicado has5(L) que é verdadeiro se L for uma lista de 5 elementos. Resolva este exercício sem usar um predicado auxiliar.
has5l(L):- L=[_,_,_,_,_].

% 3. Defina um predicado hasN(L,N) que é verdadeiro se L for uma lista de N elementos.
hasN(L,N):- length(L, N).

% 4. Defina um predicado potN0(N,L), de forma que L seja uma lista de potências de 2, com expoentes de N a 0. Exemplo de uso:
potN0(0,[1]).
potN0(N,L):- N>=0,L=[H|T],H is 2^N, N1 is N-1, potN0(N1,T).

% 5. Defina um predicado zipmult(L1,L2,L3), de forma que cada elemento da lista L3 seja o produto dos elementos de L1 e L2 na mesma posição do elemento de L3. Exemplo:
zipmult([],[],[]).
zipmult(L1,L2,L3):- L1=[H1|T1],L2=[H2|T2],L3=[H3|T3], H3 is H1*H2, zipmult(T1,T2,T3).

% 6. Defina um predicado potencias(N,L), de forma que L seja uma lista com as N primeiras potências de 2, sendo a primeira 2^0 e assim por diante, conforme o exemplo abaixo:
potencias(N,L):- potencias2(0,N,L).
    
potencias2(N,N,[]).
potencias2(X,N,L):- 
    X=<N, 
    L=[H|T], 
    H is 2^X, 
    XI is X+1, 
    potencias2(XI,N,T).

% 7. Defina um predicado positivos(L1,L2), de forma que L2 seja uma lista só com os elementos positivos de L1, conforme o exemplo abaixo:
positivos([],[]).
positivos(L1,L2):- 
    L1=[H1|T1],
    L2=[H2|T2], 
    (H1>0 -> H2 is H1, T3 = T2; T3 = L2), 
    positivos(T1,T3).

% 8. Considere que L1 e L2 sejam permutações de uma lista de elementos distintos, sem repetições. Sabendo disso, defina um predicado mesmaPosicao(A,L1,L2) para verificar se um elemento A está na mesma posição nas listas L1 e L2. Exemplo de uso:
mesmaPosicao(A,[A|_],[A|_]).
mesmaPosicao(A,L1,L2):- 
    L1=[_|T1],
    L2=[_|T2],
    mesmaPosicao(A,T1,T2).
    
% 9. Dada uma lista de N alunos, deseja-se escolher NP alunos (NP < N) para formar uma comissão. Para isso, defina um predicado comissao(NP,LP,C), que permita gerar as possíveis combinações C com NP elementos da lista LP. Exemplo:
comissao(0, _, []).
comissao(NP,LP,C) :-
    NP > 0,
    NPI is NP - 1,
    C=[H|T],
    comissao2(H, LP, R),
    comissao(NPI, R, T).

comissao2(H,[H|T],T).
comissao2(H,[_|T],R) :- 
    comissao2(H,T,R).
    
% 10. (Adaptado de OBI2006-F1N1) Tem-se N azulejos 10cm x 10cm e, com eles, deve-se montar um conjunto de quadrados de modo a utilizar todos os azulejos dados, sem sobrepô-los. Inicialmente, deve-se montar o maior quadrado possível; então, com os azulejos que sobraram, deve-se montar o maior quadrado possível, e assim sucessivamente. Por exemplo, se forem dados 31 azulejos, o conjunto montado terá 4 quadrados. Para resolver este problema, você deverá definir um predicado azulejos(NA, NQ), de forma que NQ seja o número de quadrados que se deve montar com NA azulejos. Dica: use os predicados sqrt e floor, pré-definidos em Prolog.
azulejos(0,0).
azulejos(NA, NQ):- 
    NA>0,
    NA1 is floor(sqrt(NA)),
    NA2 is NA-NA1*NA1,
    azulejos(NA2,NQ1),
    NQ is NQ1+1.
